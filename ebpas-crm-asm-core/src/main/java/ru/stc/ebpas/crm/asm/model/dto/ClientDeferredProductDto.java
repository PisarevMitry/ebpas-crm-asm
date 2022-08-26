package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Товар, добавленный в список понравившихся")
@Data
public class ClientDeferredProductDto {

    private ClientDto client;

    private AvailableProductDto availableProduct;
}
