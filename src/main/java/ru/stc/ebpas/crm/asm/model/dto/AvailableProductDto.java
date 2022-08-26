package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Товар, доступный на торговой площадке")
@Data
public class AvailableProductDto {

    private Long id;

    private ProductDto product;

    private StoreDto store;

    private Integer amountTotal;

    private Integer blockedTotal;

    private Long priceUnit;
}
