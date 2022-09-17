package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Корневая сущность пользователя")
public class CoreUserDto implements DatabaseDto {

    private Long id;

    private UserInfoDto userInfo;

    private OrganizationInfoDto organizationInfo;

    private Boolean blocked;

    private Set<ClientDto> clients;
}
