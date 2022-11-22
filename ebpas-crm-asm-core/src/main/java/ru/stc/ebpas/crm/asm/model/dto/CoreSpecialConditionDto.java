package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Schema(description = "Основные данные специальных торговых условий")
public class CoreSpecialConditionDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private SpecialConditionTypeDto specialConditionType;

    private String description;

    private LocalDateTime startConditionDttm;

    private LocalDateTime endConditionDttm;

    private Object systemDetails;

    private Boolean displayed;

    private Boolean blocked;

    private Set<AvailableProductDto> availableProducts;

    private Set<ProductCategoryDto> categories;

    private Set<ClientDto> clients;

    private Set<ProductDto> products;

    private Set<StoreDto> stores;
}
