package ru.relex.cryptostock.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.cryptostock.entity.Profile;
import ru.relex.cryptostock.repository.ProfileRepository;
import ru.relex.cryptostock.service.ProfileService;
import ru.relex.cryptostock.utils.HashUtils;

@Service
@AllArgsConstructor
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;


    @Override
    public Profile getByToken(String token) {
        String userName = HashUtils.decrypt(token);
        return profileRepository.findByUserName(userName);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

}
