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
@Schema(description = "Тип специальных торговых условий")
public class SpecialConditionTypeDto implements DatabaseDto {

    private Long id;

    private String specialConditionName;

    private String systemDetails;

    private Set<CoreSpecialConditionDto> specialConditionDetails;
}
