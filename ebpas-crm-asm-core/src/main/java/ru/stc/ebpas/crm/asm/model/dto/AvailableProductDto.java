package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Товар, доступный на торговой площадке")
public class AvailableProductDto implements SimpleDatabaseDto {

    private Long id;

    private Long product;

    private Long store;

    private Integer amountTotal;

    private Integer blockedTotal;

    private Long priceUnit;

    private Set<Long> specialConditions;

    private Set<ClientDeferredProductKey> clientDeferredProducts;

    private Set<ClientOrderedProductKey> clientOrderedProducts;

    private Set<ClientShoppedProductKey> clientShoppedProducts;
}
