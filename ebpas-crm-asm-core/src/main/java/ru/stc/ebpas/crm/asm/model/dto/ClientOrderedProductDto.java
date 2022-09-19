package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.ComplexDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Товар, заказанный пользователем")
public class ClientOrderedProductDto implements ComplexDatabaseDto {

    private ClientOrderedProductKey clientOrderedProductKey;

    private Integer amountTotal;

    private Long priceUnit;

    @Override
    public CompositeKey getId() {
        return clientOrderedProductKey;
    }
}
