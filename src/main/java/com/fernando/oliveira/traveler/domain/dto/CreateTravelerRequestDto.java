package com.fernando.oliveira.traveler.domain.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTravelerRequestDto {

    private String name;

    private String email;

    private String document;

    private String status;

    private Integer prefixPhone;

    private String numberPhone;
}
