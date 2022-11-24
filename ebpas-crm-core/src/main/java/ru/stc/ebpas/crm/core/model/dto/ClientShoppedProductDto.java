package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.ComplexDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductKey;

@Data
@Schema(description = "Товар, добавленный пользователем в корзину")
public class ClientShoppedProductDto implements ComplexDatabaseDto {

    private ClientShoppedProductKey clientShoppedProductKey;

    private ClientDto client;

    private AvailableProductDto availableProduct;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer amountTotal;

    @Override
    public CompositeKey getId() {
        return clientShoppedProductKey;
    }
}
