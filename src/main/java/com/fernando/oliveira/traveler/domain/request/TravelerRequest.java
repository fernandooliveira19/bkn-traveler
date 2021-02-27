package com.fernando.oliveira.traveler.domain.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Requisição utilizada no cadastro de viajante")
public class TravelerRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="id", value="Identificador do viajante", example="1", hidden = true)
	private Long id;
	@ApiModelProperty(name="travelerName", value="Nome completo do viajante", example="José da Silva")
	private String travelerName;
	@ApiModelProperty(name="travelerEmail", value="Email do viajante", example="jose.silva@gmail.com")
	private String travelerEmail;
	@ApiModelProperty(name="idPhone", value="Identificador do telefone do viajante", example="1", hidden = true)
	private Long idPhone;
	@ApiModelProperty(name="prefixPhone", value="Prefixo do telefone", example = "11")
	private Integer prefixPhone;
	@ApiModelProperty(name="numberPhone", value="Numero do telefone", example = "98888-7777")
	private String numberPhone;
	

}
