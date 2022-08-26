package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Способ оплаты")
@Data
public class PaymentTypeDto {

    private Long id;

    private String payment_name;

    private String systemDetails;

    private Set<ClientPaymentMethodDto> clientPaymentMethods;

    private Set<PaymentDetailsDto> paymentDetails;
}
