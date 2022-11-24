package ru.stc.ebpas.crm.cm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Клиент")
public class ClientDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private CoreUserDto coreUser;

    private Set<ClientAddressDto> addresses;

    private Set<ClientPaymentMethodDto> paymentMethods;

    private Set<ClientDeferredProductDto> deferredProducts;

    private Set<ClientShoppedProductDto> shoppedProducts;

    private Set<Long> coreOrders;

    private Set<Long> specialConditions;

    private Set<Long> productFeedbacks;
}
