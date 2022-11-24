package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Корневая сущность пользователя")
public class CoreUserDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private UserInfoDto userInfo;

    private OrganizationInfoDto organizationInfo;

    private Boolean blocked;

    private Set<ClientDto> clients;
}
