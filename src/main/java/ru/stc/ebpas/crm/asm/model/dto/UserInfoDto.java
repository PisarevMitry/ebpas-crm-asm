package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Сведения о пользователе")
@Data
public class UserInfoDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String secondName;

    private String phoneNumber;

    private String mail;

    private CoreUserDto coreUser;
}
