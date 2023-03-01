package ru.relex.cryptostock.dto.creating;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreatingDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String email;

}
