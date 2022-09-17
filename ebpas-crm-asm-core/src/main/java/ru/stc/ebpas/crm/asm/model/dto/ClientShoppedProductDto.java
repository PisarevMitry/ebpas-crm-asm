package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.ComplexDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Товар, добавленный пользователем в корзину")
public class ClientShoppedProductDto implements ComplexDatabaseDto {

    private ClientDto client;

    private AvailableProductDto availableProduct;

    private Integer amountTotal;

    @Override
    public CompositeKey getId() {
        return new ClientShoppedProductKey(client.getId(), availableProduct.getId());
    }
}
