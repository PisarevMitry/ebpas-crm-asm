package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

import java.util.Set;

@Data
@Schema(description = "Сведения о возврате заказа")
public class ReturnDetailsDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private NsiStatusDto nsiReturnReason;

    private NsiStatusDto nsiReturnStatus;

    private NsiStatusDto nsiReturnRequirement;

    private String systemDetails;

    private String systemDetailsValue;

    private CoreOrderDto coreOrder;

    private Set<DefectiveProductDto> defectiveProducts;
}