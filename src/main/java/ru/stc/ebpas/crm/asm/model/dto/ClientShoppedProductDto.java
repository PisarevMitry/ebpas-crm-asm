package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Товар, добавленный пользователем в корзину")
@Data
public class ClientShoppedProductDto {

    private ClientDto clientByClientId;

    private AvailableProductDto availableProduct;

    private Integer amountTotal;
}
