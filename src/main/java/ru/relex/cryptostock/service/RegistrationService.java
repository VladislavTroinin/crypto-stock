package ru.relex.cryptostock.service;

import ru.relex.cryptostock.dto.creating.ProfileCreatingDto;
import ru.relex.cryptostock.dto.response.RegistrationResponseDto;

public interface RegistrationService {

    RegistrationResponseDto register(ProfileCreatingDto dto);

}
