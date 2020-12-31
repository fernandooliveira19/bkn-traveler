package com.fernando.oliveira.traveler.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fernando.oliveira.traveler.domain.entity.Phone;
import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.enums.Status;
import com.fernando.oliveira.traveler.domain.mapper.TravelerMapper;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.exception.TravelerException;
import com.fernando.oliveira.traveler.exception.TravelerInvalidException;
import com.fernando.oliveira.traveler.exception.TravelerNotFoundException;
import com.fernando.oliveira.traveler.repository.TravelerRepository;

@Service
public class TravelerService{

	@Autowired
	private TravelerRepository travelerRepository;
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private TravelerMapper travelerMapper;

	
	@Transactional
	public TravelerDetailResponse createTraveler(CreateTravelerRequest request) {
		
		Traveler travelerToSave = travelerMapper.requestToEntity(request);
		
		validate(travelerToSave);
		travelerToSave.setStatus(Status.ACTIVE);
		Traveler createdTraveler = travelerRepository.save(travelerToSave);
		
		createOrUpdatePhone(createdTraveler);

		
		return convertToResponse(createdTraveler);
	}

	private void createOrUpdatePhone(Traveler traveler) {
		
		Phone phone = traveler.getPhone();
		phone.setTraveler(traveler);
		phoneService.save(phone);
		
	}
	
	public Traveler update(Traveler traveler) {
		
		validate(traveler);
		
		Traveler savedTraveler = findById(traveler.getId());
		
		savedTraveler.setName(traveler.getName());
		savedTraveler.setEmail(traveler.getEmail());
		savedTraveler.setDocument(traveler.getDocument());
		savedTraveler.getPhone().setPrefix(traveler.getPhone().getPrefix());
		savedTraveler.getPhone().setNumber(traveler.getPhone().getNumber());
		
		return travelerRepository.save(savedTraveler);
	}
	
	public TravelerDetailResponse convertToResponse(Traveler traveler) {
		
		return travelerMapper.entityToResponse(traveler);
	}
	
	public TravelerDetailResponse getById(Long id) {
		
		Traveler result = findById(id);
		
		return convertToResponse(result);
	}
	
	public Traveler findById(Long id) {
		
		Optional<Traveler> result = travelerRepository.findById(id);
		
		return result.orElseThrow(() -> new TravelerNotFoundException("Viajante não encontrado pelo id: " + id) );
	}

	public List<Traveler> findAll() {
		List<Traveler> result = travelerRepository.findAll();
		if(result.isEmpty()) {
			throw new TravelerNotFoundException("Não foram encontrados resultados");
		}
		return result;
	}
	
	public Traveler findTravelerByName(String name) {
		Optional<Traveler> result = travelerRepository.findByName(name);
		return result.orElseThrow(() -> new TravelerNotFoundException("Não foram encontrados resultados"));
	}
	
	
//	public PageModel<TravelerDTO> findAll(PageRequestModel pageRequestModel) {
//		
//		Pageable pageable = pageRequestModel.toSpringPageRequest();
//		
//		Page<Traveler> page = travelerRepository.findAll(pageable);
//		
//		List<TravelerDTO> collect = page.getContent()
//		.stream()
//		.map((e) -> e.convertToDTO())
//		.collect(Collectors.toList());
//		
//		PageModel<TravelerDTO> pageModel = new PageModel<TravelerDTO>((int)page.getTotalElements(), page.getSize(),page.getTotalPages(), collect);
//		
//		return pageModel;
//	}

	
//	public PageModel<TravelerDTO> findByNameContainingOrderByNameAsc(String name, PageRequestModel pageRequestModel) {
//		Pageable pageable = pageRequestModel.toSpringPageRequest();
//		
//		Page<Traveler> page = travelerRepository.findByNameContainingOrderByNameAsc(name, pageable);
//		
//		List<TravelerDTO> collect = page.getContent()
//				.stream()
//				.map((e) -> e.convertToDTO())
//				.collect(Collectors.toList());
//		
//		if(collect.isEmpty()) {
//			throw new TravelerNotFoundException("Não foram encontrados resultados");
//		}
//		
//		PageModel<TravelerDTO> pageModel = new PageModel<TravelerDTO>((int)page.getTotalElements(), page.getSize(),page.getTotalPages(), collect);
//		
//		return pageModel;
//	}
	
	private void validate(Traveler traveler) {
		
		validateTravelerData(traveler);
		validateTravelerPhone(traveler);
		
	}
	
	private void validateTravelerData(Traveler traveler) {
		
		validateTravelerName(traveler);
		
		validateTravelerEmail(traveler);
		
		validateUniqueTraveler(traveler);
		
	}

	public void validateUniqueTraveler(Traveler traveler) {
		Optional<Traveler> savedTraveler = travelerRepository.findByName(traveler.getName());
		
		if(savedTraveler.isPresent()
				&& (traveler.getId() == null 
					|| !traveler.getId().equals(savedTraveler.get().getId()))) {
			throw new TravelerInvalidException("Já existe viajante com o nome informado");
		}
	}
	
	private void validateTravelerName(Traveler traveler) {
		if(StringUtils.isEmpty(traveler.getName())) {
			throw new TravelerInvalidException("Nome é obrigatório");
		}
	}
	
	private void validateTravelerEmail(Traveler traveler) {
		
		if(StringUtils.isEmpty(traveler.getEmail())) {
			throw new TravelerInvalidException("Email é obrigatório");
		}
		validateEmail(traveler.getEmail());
	}

	private void validateTravelerPhone(Traveler traveler) {
	
		if(traveler.getPhone() == null) {
			throw new TravelerInvalidException("Telefone é obrigatório");
		}
		
		if(traveler.getPhone().getPrefix() == null) {
			throw new TravelerInvalidException("Telefone inválido");
		}
		
		if(StringUtils.isEmpty(traveler.getPhone().getNumber())){
			throw new TravelerInvalidException("Telefone inválido");
		}
		
		if(traveler.getPhone().getPrefix() != null
				&& String.valueOf(traveler.getPhone().getPrefix()).length() != 2) {
			throw new TravelerInvalidException("DDD inválido");
		}
	}
	
	private void validateEmail(String email) {

		String inv = "((.)*@(.)*@(.)*|(.)*[.][.](.)*|(.)*[.]@(.)*|(.)*@[.](.)*|^[.](.)*)";
		boolean invalido = Pattern.matches(inv, email);

		if (invalido) {
			throw new TravelerException("Email inválido");
		}

		String regValido = "^(.)+@[a-zA-Z0-9[-][.]]+[.]([a-zA-Z]{2,61}|[0-9]{1,3})";
		boolean valido = Pattern.matches(regValido, email);

		if (!valido) {
			throw new TravelerInvalidException("Email inválido");
		}

	}

	
	public void deleteById(Long id) {
		
		Traveler travelerToUpdate = findById(id);
		
		travelerRepository.delete(travelerToUpdate);
		
	}

	public List<Traveler> findAllByOrderByName() {
		
		return travelerRepository.findAllByOrderByName();
	}

	public Traveler updateStatus(Traveler traveler) {
		Traveler savedTraveler = findById(traveler.getId());
		
		savedTraveler.setStatus(traveler.getStatus());
		
		return travelerRepository.save(savedTraveler);
		
	}
	
//	public List<TravelerDto> findByNameContainingOrderByNameAsc(String name) {
//		
//		
//		List<Traveler> result = travelerRepository.findByNameContainingOrderByNameAsc(name);
//		
//		List<TravelerDto> collect = result
//				.stream()
//				.map((e) -> e.convertToDTO())
//				.collect(Collectors.toList());
//		
//		if(collect.isEmpty()) {
//			throw new TravelerNotFoundException("Não foram encontrados resultados");
//		}
//		
//		
//		return collect;
//	}
//

}
