package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сведения о сборке заказа")
public class AssemblyDetailsDto implements SimpleDatabaseDto {

    private Long id;

    private NsiStatusDto nsiAssemblyStatus;

    private Set<ClientOrderedProductKey> orderedProducts;

    private Long coreOrder;
}
