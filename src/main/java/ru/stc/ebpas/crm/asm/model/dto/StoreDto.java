package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiAddress;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

import java.util.Set;

@Schema(description = "Торговая площадка")
@Data
public class StoreDto {

    private Long id;

    private String name;

    private NsiAddress nsiAddress;

    private Boolean pickupAvailable;

    private Boolean available;

    private Set<AvailableProductDto> availableProducts;

    private Set<CoreSpecialConditionDto> specialConditions;
}
