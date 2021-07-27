package com.fernando.oliveira.traveler.domain.request;

import com.fernando.oliveira.traveler.validation.Cpf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Requisição para cadastro de viajantes")
public class CreateTravelerRequest extends TravelerRequest implements Serializable{

	private static final long serialVersionUID = 1L;


}
