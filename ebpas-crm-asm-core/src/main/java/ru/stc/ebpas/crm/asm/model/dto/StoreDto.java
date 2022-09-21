package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;

import java.util.Set;

@Data
@Schema(description = "Торговая площадка")
public class StoreDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    private NsiAddressDto nsiAddress;

    private Boolean pickupAvailable;

    private Boolean available;

    private Set<AvailableProductDto> availableProducts;

    private Set<CoreSpecialConditionDto> specialConditions;
}
