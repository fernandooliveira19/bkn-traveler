package com.fernando.oliveira.traveler.domain.response;

import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Api(value = "Detalhes do viajante")
public class TravelerDetailResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="id", value="Identificador do viajante", example = "1", hidden = true)
	private Long id;
	@ApiModelProperty(name="name", value="Nome completo do viajante", example="José da Silva")
	private String name;
	@ApiModelProperty(name="email", value="Email do viajante", example="jose.silva@gmail.com")
	private String email;
	@ApiModelProperty(name="document", value="Documento do viajante", example="jose.silva@gmail.com")
	private String document;
	@ApiModelProperty(name="prefixPhone", value="Prefixo do telefone", example = "11")
	private Integer prefixPhone;
	@ApiModelProperty(name="numberPhone", value="Numero do telefone", example = "98888-7777")
	private String numberPhone;
	@ApiModelProperty(name="status", value="Status do viajante", example = "<li><lu>A - Ativo</lu><lu>I - Inativo</lu></li>")
	private String status;

}
