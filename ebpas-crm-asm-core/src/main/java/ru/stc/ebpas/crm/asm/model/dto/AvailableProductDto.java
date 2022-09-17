package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Товар, доступный на торговой площадке")
public class AvailableProductDto implements DatabaseDto {

    private Long id;

    private ProductDto product;

    private StoreDto store;

    private Integer amountTotal;

    private Integer blockedTotal;

    private Long priceUnit;
}
