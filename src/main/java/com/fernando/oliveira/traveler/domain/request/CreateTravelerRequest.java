package com.fernando.oliveira.traveler.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Requisição utilizada no cadastro de viajante")
public class CreateTravelerRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty(name="name", value="Nome completo do viajante", example="José da Silva")
	private String name;

	@ApiModelProperty(name="email", value="Email do viajante", example="jose.silva@gmail.com")
	private String email;

	@ApiModelProperty(name="document", value="Documento do viajante", example="12345678910")
	private String document;

	@ApiModelProperty(name="prefixPhone", value="Prefixo do telefone", example = "11")
	private Integer prefixPhone;

	@ApiModelProperty(name="numberPhone", value="Numero do telefone", example = "988887777")
	private String numberPhone;
	

}