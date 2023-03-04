package ru.relex.cryptostock.service;

import ru.relex.cryptostock.entity.Profile;

public interface ProfileService {

    Profile getByToken(String token);

    Profile save(Profile profile);

}
