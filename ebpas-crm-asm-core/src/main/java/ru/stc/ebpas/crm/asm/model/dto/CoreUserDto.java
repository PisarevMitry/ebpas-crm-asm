package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Корневая сущность пользователя")
@Data
public class CoreUserDto {

    private Long id;

    private UserInfoDto userInfo;

    private OrganizationInfoDto organizationInfo;

    private Boolean blocked;

    private Set<ClientDto> clients;
}
