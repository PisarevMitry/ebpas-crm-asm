package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Основные данные о товаре")
@Data
public class CoreProductDto {

    private Long id;

    private String productName;

    private String coreDescription;

    private String options;

    private Set<ProductDto> products;
}
