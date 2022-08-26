package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

import java.util.Set;

@Schema(description = "Сведения о сборке заказа")
@Data
public class AssemblyDetailsDto {

    private Long id;

    private NsiStatus nsiAssemblyStatus;

    private Set<ClientOrderedProductDto> orderedProducts;

    //private CoreOrderDto coreOrder;
}
