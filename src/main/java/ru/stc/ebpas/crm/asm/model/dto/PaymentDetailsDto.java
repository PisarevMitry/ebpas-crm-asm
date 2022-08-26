package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

@Schema(description = "Сведения об оплате")
@Data
public class PaymentDetailsDto {

    private Long id;

    private PaymentTypeDto paymentType;

    private String systemDetailsValue;

    private NsiStatus nsiPaymentStatus;

    private CoreOrderDto coreOrder;
}
