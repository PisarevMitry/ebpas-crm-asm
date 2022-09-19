package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Основные данные о товаре")
public class CoreProductDto implements SimpleDatabaseDto {

    private Long id;

    private String productName;

    private String coreDescription;

    private String options;

    private Set<Long> products;
}
