package com.fernando.oliveira.traveler.domain.mapper;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TravelerMapper {
	
	Traveler requestToTraveler(TravelerRequest request);

	TravelerDetailResponse travelerToTravelerDetailResponse(Traveler traveler);

}
