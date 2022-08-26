package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

@Schema(description = "Основные данные о заказе")
@Data
public class CoreOrderDto {

    private Long id;

    private AssemblyDetailsDto assemblyDetails;

    private PaymentDetailsDto paymentDetails;

    private DeliveryDetailsDto deliveryDetails;

    private ReturnDetailsDto returnDetails;

    private ClientDto client;

    private NsiStatus nsiCoreOrderStatus;

    private Boolean requirementOrgDocStatus;
}
