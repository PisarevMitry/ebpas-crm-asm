package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Сведения об организации")
@Data
public class OrganizationInfoDto {

    private Long id;

    private Set<CoreUserDto> coreUsers;
}
