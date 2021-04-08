package com.fernando.oliveira.traveler.domain.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelerDetailResponseDto {

    private Long id;

    private String name;

    private String email;

    private String document;

    private String status;

    private Integer prefixPhone;

    private String numberPhone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelerDetailResponseDto that = (TravelerDetailResponseDto) o;
        return name.equals(that.name) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
