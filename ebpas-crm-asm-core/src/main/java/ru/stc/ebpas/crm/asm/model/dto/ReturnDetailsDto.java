package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сведения о возврате заказа")
public class ReturnDetailsDto implements SimpleDatabaseDto {

    private Long id;

    private NsiStatusDto nsiReturnReason;

    private NsiStatusDto nsiReturnStatus;

    private NsiStatusDto nsiReturnRequirement;

    private String systemDetails;

    private String systemDetailsValue;

    private Long coreOrder;

    private Set<Long> defectiveProducts;
}
