package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Клиент")
public class ClientDto implements DatabaseDto {

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
