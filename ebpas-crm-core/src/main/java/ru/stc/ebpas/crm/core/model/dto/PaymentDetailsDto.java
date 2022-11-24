package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

@Data
@Schema(description = "Сведения об оплате")
public class PaymentDetailsDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private PaymentTypeDto paymentType;

    private Object systemDetails;

    private NsiStatusDto nsiPaymentStatus;

    private CoreOrderDto coreOrder;
}
