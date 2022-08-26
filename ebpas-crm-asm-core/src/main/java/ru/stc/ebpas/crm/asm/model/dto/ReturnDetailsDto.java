package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

import java.util.Set;

@Schema(description = "Сведения о возврате заказа")
@Data
public class ReturnDetailsDto {

    private Long id;

    private NsiStatus nsiReturnReason;

    private NsiStatus nsiReturnStatus;

    private NsiStatus nsiReturnRequirement;

    private String systemDetails;

    private String systemDetailsValue;

    private CoreOrderDto coreOrder;

    private Set<DefectiveProductDto> defectiveProducts;
}
