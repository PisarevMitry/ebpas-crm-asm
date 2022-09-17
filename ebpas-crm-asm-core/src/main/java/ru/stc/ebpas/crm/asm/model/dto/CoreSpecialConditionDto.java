package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Основные данные специальных торговых условий")
public class CoreSpecialConditionDto implements DatabaseDto {

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
