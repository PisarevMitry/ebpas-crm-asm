package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

import java.util.Set;

@Data
@Schema(description = "Товар, доступный на торговой площадке")
public class AvailableProductDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ProductDto product;

    private StoreDto store;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer amountTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer blockedTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long priceUnit;

    private Set<SpecialConditionTypeDto> specialConditions;

    private Set<ClientDeferredProductKey> clientDeferredProducts;

    private Set<ClientOrderedProductKey> clientOrderedProducts;

    private Set<ClientShoppedProductKey> clientShoppedProducts;
}
