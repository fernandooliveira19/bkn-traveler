package com.fernando.oliveira.traveler.controller;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.mapper.TravelerMapper;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.request.UpdateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.service.TravelerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags="Traveler endpoint")
@RestController
@RequestMapping(value = "/v1/travelers")
public class TravelerController {

	@Autowired
	private TravelerService travelerService;

	@Autowired
	private TravelerMapper travelerMapper;


	@ApiOperation(value = "Realiza cadastro de viajante")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Viajante cadastrado com sucesso"),
			@ApiResponse(code = 400, message = "Dados de cadastro inválidos"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})
	@PostMapping("/create")
	public ResponseEntity<TravelerDetailResponse> createTraveler(@RequestBody @Valid CreateTravelerRequest request) {

		Traveler travelerCreated = travelerService.createTraveler(travelerMapper.requestToCreateTraveler(request));

		return ResponseEntity.status(HttpStatus.CREATED).body(travelerMapper.travelerToTravelerDetailResponse(travelerCreated));

	}

	@ApiOperation(value = "Realiza busca de viajante pelo identificador")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Viajante retornado com sucesso"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})
	@GetMapping("/{id}")
	public ResponseEntity<TravelerDetailResponse> findById(@PathVariable("id") Long id) {

		Traveler result = travelerService.findById(id);

		return ResponseEntity.status(HttpStatus.OK).body(travelerMapper.travelerToTravelerDetailResponse(result));

	}

	@ApiOperation(value = "Realiza busca de todos viajantes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Viajante retornado com sucesso"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})
	@GetMapping
	public ResponseEntity<List<TravelerDetailResponse>> findAll() {

		List<Traveler> result = travelerService.findAll();
		List<TravelerDetailResponse> response = result.stream().map(e -> travelerMapper.travelerToTravelerDetailResponse(e)).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@ApiOperation(value = "Realiza atualização de dados do viajante")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Atualização realizada com sucesso"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Pesquisa não retornou resultados"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})

	@PutMapping("/update/{id}")
	public ResponseEntity<TravelerDetailResponse> update(
			@PathVariable("id") Long id, @Valid  @RequestBody UpdateTravelerRequest request) {

		Traveler traveler = travelerMapper.requestToUpdateTraveler(request);
		Traveler updatedTraveler = travelerService.updateTraveler(id, traveler);
		TravelerDetailResponse response = travelerMapper.travelerToTravelerDetailResponse(updatedTraveler);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiOperation(value = "Realiza pesquisa de viajantes por nome")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pesquisa retornou dados com sucesso"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 404, message = "Pesquisa não retornou resultados"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})
	@GetMapping("/find")
	public ResponseEntity<List<TravelerDetailResponse>> findByName(@RequestParam String name) {

		List<Traveler> result = travelerService.findByNameContainingOrderByNameAsc(name);

		List<TravelerDetailResponse> response = result
				.stream()
				.map(traveler -> travelerMapper.travelerToTravelerDetailResponse(traveler))
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiOperation(value = "Realiza inativação de viajante pelo identificador")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Viajante inativado com sucesso"),
			@ApiResponse(code = 403, message = "Você não possui permissão para acessar esse recurso"),
			@ApiResponse(code = 500, message = "Ocorreu algum erro inesperado. Tente novamente mais tarde")})
	@PutMapping("/{id}/inactive")
	public ResponseEntity<Void> inactivateTraveler(@PathVariable("id") Long id) {

		travelerService.inactivateTraveler(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
}
