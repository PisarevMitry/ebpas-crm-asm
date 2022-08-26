package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Способ оплаты, сохраненый пользователем")
@Data
public class ClientPaymentMethodDto {

    private Long id;

    private ClientDto client;

    private PaymentTypeDto paymentType;

    private String systemDetailsValue;

    private Boolean displayed;

    private Boolean defaultUsed;

    private Boolean blocked;
}
