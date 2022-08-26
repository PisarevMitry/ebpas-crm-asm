package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Основные данные специальных торговых условий")
@Data
public class CoreSpecialConditionDto {

    private Long id;

    private SpecialConditionTypeDto specialConditionType;

    private String description;

    private LocalDateTime startConditionDttm;

    private LocalDateTime endConditionDttm;

    private String systemDetailsValue;

    private Boolean displayed;

    private Boolean blocked;

    private Set<AvailableProductDto> availableProducts;

    private Set<ProductCategoryDto> categories;

    private Set<ClientDto> clients;

    private Set<ProductDto> products;

    private Set<StoreDto> stores;
}
