package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Клиент")
@Data
public class ClientDto {

    private Long id;

    private CoreUserDto coreUser;

    private Set<ClientAddressDto> addresses;

    private Set<ClientPaymentMethodDto> paymentMethods;

    private Set<ClientDeferredProductDto> deferredProducts;

    private Set<ClientShoppedProductDto> shoppedProducts;

    private Set<CoreOrderDto> coreOrders;

    private Set<CoreSpecialConditionDto> specialConditions;

    private Set<ProductFeedbackDto> productFeedbacks;
}
