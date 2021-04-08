package com.fernando.oliveira.traveler.client;

import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="${feign.bkn.traveler.name}", url="${feign.bkn.traveler.url}")
@RequestMapping(path="/bkn", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface TravelerClient {

    @PostMapping(value="/travelers")
    TravelerDetailResponseDto createTraveler(@RequestBody CreateTravelerRequestDto requestDto);

    @GetMapping(value="/travelers")
    List<TravelerDetailResponseDto> findTraveler();

    @GetMapping(value="/travelers")
    List<TravelerDetailResponseDto> findTravelersByName(@RequestParam(name="name", required = true)String name);

    @GetMapping(value="/travelers")
    List<TravelerDetailResponseDto> findTravelersByEmail(@RequestParam(name="email", required = true)String email);
}
