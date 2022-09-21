package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.ComplexDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;

@Data
@Schema(description = "Товар, добавленный в список понравившихся")
public class ClientDeferredProductDto implements ComplexDatabaseDto {

    private ClientDeferredProductKey clientDeferredProductKey;

    private ClientDto client;

    private AvailableProductDto availableProduct;

    @Override
    public CompositeKey getId() {
        return clientDeferredProductKey;
    }
}
