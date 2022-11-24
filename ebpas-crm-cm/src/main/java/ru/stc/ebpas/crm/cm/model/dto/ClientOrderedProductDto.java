package ru.stc.ebpas.crm.cm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.ComplexDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.cm.model.entity.ClientOrderedProductKey;

@Data
@Schema(description = "Товар, заказанный пользователем")
public class ClientOrderedProductDto implements ComplexDatabaseDto {

    private ClientOrderedProductKey clientOrderedProductKey;

    private Long assemblyDetails;

    private Long availableProduct;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer amountTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long priceUnit;

    @Override
    public CompositeKey getId() {
        return clientOrderedProductKey;
    }
}
