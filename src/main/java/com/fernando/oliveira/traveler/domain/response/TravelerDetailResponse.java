package com.fernando.oliveira.traveler.domain.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Detalhes do viajante")
public class TravelerDetailResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name="travelerName", value="Nome completo do viajante")
	private String travelerName;
	@ApiModelProperty(name="travelerEmail", value="Email do viajante")
	private String travelerEmail;
	@ApiModelProperty(name="prefixPhone", value="Prefixo do telefone")
	private Integer prefixPhone;
	@ApiModelProperty(name="numberPhone", value="Numero do telefone")
	private String numberPhone;

}
