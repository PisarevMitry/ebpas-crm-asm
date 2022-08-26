package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Тип специальных торговых условий")
@Data
public class SpecialConditionTypeDto {

    private Long id;

    private String specialConditionName;

    private String systemDetails;

    private Set<CoreSpecialConditionDto> specialConditionDetails;
}
