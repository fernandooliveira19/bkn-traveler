package com.fernando.oliveira.traveler.domain.mapper;

import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TravelerMapper {
	
	CreateTravelerRequestDto createTravelerRequestToDto(CreateTravelerRequest request);

	TravelerDetailResponse detailResponseDtoToResponse(TravelerDetailResponseDto responseDto);

}
