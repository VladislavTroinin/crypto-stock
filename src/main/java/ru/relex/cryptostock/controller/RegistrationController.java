package ru.relex.cryptostock.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.relex.cryptostock.dto.creating.ProfileCreatingDto;
import ru.relex.cryptostock.dto.response.RegistrationResponseDto;
import ru.relex.cryptostock.service.RegistrationService;

import javax.validation.Valid;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping
    public RegistrationResponseDto register(@RequestBody @Valid ProfileCreatingDto dto) {
        return registrationService.register(dto);
    }

}
