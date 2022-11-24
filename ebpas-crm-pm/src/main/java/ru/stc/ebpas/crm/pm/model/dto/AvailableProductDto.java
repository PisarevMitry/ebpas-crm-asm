package ru.stc.ebpas.crm.pm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

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

    private Set<Long> specialConditions;

    private Set<Long> clientDeferredProducts;

    private Set<Long> clientOrderedProducts;

    private Set<Long> clientShoppedProducts;
}
