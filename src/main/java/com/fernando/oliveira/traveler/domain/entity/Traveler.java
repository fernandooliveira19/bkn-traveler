package com.fernando.oliveira.traveler.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "bkn-travelers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Traveler {
    @Id
    private String id;
    private String name;
    private String email;
    private String document;
    private Integer prefixPhone;
    private String numberPhone;
    private String status;
}
