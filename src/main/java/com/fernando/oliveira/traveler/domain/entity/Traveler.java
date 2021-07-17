package com.fernando.oliveira.traveler.domain.entity;

import lombok.*;

import javax.persistence.*;


@Entity(name="traveler")
@Table(name="traveler" )
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Traveler {

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="EMAIL", nullable=false)
    private String email;

    @Column(name="DOCUMENT")
    private String document;

    @Column(name="STATUS", nullable = false)
    private String status;

    @Column(name="PREFIX_PHONE", nullable = false)
    private Integer prefixPhone;

    @Column(name="NUMBER_PHONE", nullable = false)
    private String numberPhone;
}
