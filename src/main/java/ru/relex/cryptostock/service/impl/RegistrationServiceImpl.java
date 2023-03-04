package ru.relex.cryptostock.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.cryptostock.dto.creating.ProfileCreatingDto;
import ru.relex.cryptostock.dto.response.RegistrationResponseDto;
import ru.relex.cryptostock.entity.Profile;
import ru.relex.cryptostock.model.ProfileRole;
import ru.relex.cryptostock.repository.ProfileRepository;
import ru.relex.cryptostock.service.ProfileService;
import ru.relex.cryptostock.service.RegistrationService;
import ru.relex.cryptostock.utils.HashUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final ProfileService profileService;


    @Override
    public RegistrationResponseDto register(ProfileCreatingDto dto) {
        Profile profile = createProfile(dto);
        profileService.save(profile);
        String token = HashUtils.encrypt(profile.getUserName());
        return new RegistrationResponseDto(token);
    }

    private Profile createProfile(ProfileCreatingDto dto) {
        return Profile.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .role(ProfileRole.USER)
                .build();
    }

}
