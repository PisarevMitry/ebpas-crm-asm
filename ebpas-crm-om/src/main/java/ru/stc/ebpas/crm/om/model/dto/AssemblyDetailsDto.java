package ru.stc.ebpas.crm.om.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

import java.util.Set;

@Data
@Schema(description = "Сведения о сборке заказа")
public class AssemblyDetailsDto implements SimpleDatabaseDto {

    @Schema(description = "Идентификатор")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Schema(description = "Статус сборки заказа")
    private NsiStatusDto nsiAssemblyStatus;

    private Set<Long> clientOrderedProducts;

    private CoreOrderDto coreOrder;
}
