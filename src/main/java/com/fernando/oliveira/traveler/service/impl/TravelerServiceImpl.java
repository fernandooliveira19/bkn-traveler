package com.fernando.oliveira.traveler.service.impl;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.enums.StatusEnum;
import com.fernando.oliveira.traveler.exception.TravelerException;
import com.fernando.oliveira.traveler.repository.TravelerRepository;
import com.fernando.oliveira.traveler.service.TravelerService;
import com.fernando.oliveira.traveler.utils.FormatterUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fernando.oliveira.traveler.utils.FormatterUtils.*;

@Service
public class TravelerServiceImpl implements TravelerService {


    @Autowired
    private TravelerRepository repository;


    public Traveler createTraveler(Traveler traveler) {

        formatFields(traveler);
        validate(traveler);
        traveler.setStatus(StatusEnum.ACTIVE.getCode());

        return repository.save(traveler);

    }



    private void validate(Traveler traveler) {
        List<Traveler> travelers = findTravelersByNameOrEmail(traveler.getName(), traveler.getEmail());

        if (!travelers.isEmpty()) {

            if (traveler.getId() == null) {
                throw new TravelerException("Já existe outro viajante cadastrado com mesmo nome ou email");
            } else {
                validateUpdateTraveler(traveler, travelers);
            }
        }

    }

    private void validateUpdateTraveler(Traveler traveler, List<Traveler> travelers) {

        for (Traveler t : travelers) {
            if (!t.getId().equals(traveler.getId())) {
                throw new TravelerException("Já existe outro viajante cadastrado com mesmo nome ou email");
            }
        }

    }

    @Override
    public List<Traveler> findTravelersByNameOrEmail(String name, String email) {

        return repository.findByNameOrEmail(name, email);

    }

    @Override
    public Traveler findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TravelerException("Nenhum viajante encontrado pelo id: " + id));
    }

    @Override
    public List<Traveler> findAll() {

        return repository.findAll();
    }

    @Override
    public Traveler updateTraveler(Long id, Traveler traveler) {
        Traveler travelerToUpdate = findById(id);
        travelerToUpdate.setName(traveler.getName());
        travelerToUpdate.setEmail(traveler.getEmail());
        travelerToUpdate.setDocument(traveler.getDocument());
        travelerToUpdate.setStatus(traveler.getStatus());
        travelerToUpdate.setPrefixPhone(traveler.getPrefixPhone());
        travelerToUpdate.setNumberPhone(traveler.getNumberPhone());
        formatFields(travelerToUpdate);
        validate(travelerToUpdate);
        return repository.save(travelerToUpdate);
    }

    @Override
    public List<Traveler> findByNameContainingOrderByNameAsc(String name) {
        return repository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    @Override
    public void inactivateTraveler(Long id) {
        Traveler traveler = findById(id);
        traveler.setStatus(StatusEnum.INACTIVE.getCode());
        repository.save(traveler);
    }

    @Override
    public List<Traveler> findActiveTravelers() {
        return repository.findActiveTravelers();
    }

    private void formatFields(Traveler traveler) {

        if (!StringUtils.isEmpty(traveler.getDocument())){
            traveler.setDocument(formatCpf(traveler.getDocument()));
        }

        traveler.setNumberPhone(formatPhoneNumber(traveler.getNumberPhone()));
    }

}
