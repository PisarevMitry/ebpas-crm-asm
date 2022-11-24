package ru.stc.ebpas.crm.scm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Тип специальных торговых условий")
public class SpecialConditionTypeDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String specialConditionName;

    private Object systemDetails;

    private Set<CoreSpecialConditionDto> specialConditionDetails;
}