package com.fernando.oliveira.traveler.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TravelerMapper {
	
	@Mapping(source = "travelerName", target = "name")
	@Mapping(source = "travelerEmail", target="email")
	@Mapping(source = "prefixPhone", target="phone.prefix")
	@Mapping(source = "numberPhone", target="phone.number")
	Traveler requestToEntity(CreateTravelerRequest request);
	
	@Mapping(source = "name", target = "travelerName")
	@Mapping(source = "email", target="travelerEmail")
	@Mapping(source = "phone.prefix", target="prefixPhone")
	@Mapping(source = "phone.number", target="numberPhone")
	TravelerDetailResponse entityToResponse(Traveler traveler);

}
