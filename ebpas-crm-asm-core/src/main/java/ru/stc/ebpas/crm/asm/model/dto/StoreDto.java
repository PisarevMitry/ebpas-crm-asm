package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Торговая площадка")
public class StoreDto implements SimpleDatabaseDto {

    private Long id;

    private String name;

    private NsiAddressDto nsiAddress;

    private Boolean pickupAvailable;

    private Boolean available;

    private Set<Long> availableProducts;

    private Set<Long> specialConditions;
}
