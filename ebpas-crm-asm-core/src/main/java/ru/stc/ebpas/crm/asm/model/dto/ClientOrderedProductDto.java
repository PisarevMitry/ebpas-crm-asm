package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Товар, заказанный пользователем")
@Data
public class ClientOrderedProductDto {

    private AssemblyDetailsDto assemblyDetails;

    private AvailableProductDto availableProduct;

    private Integer amountTotal;

    private Long priceUnit;
}
