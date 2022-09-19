package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Клиент")
public class ClientDto implements SimpleDatabaseDto {

    private Long id;

    private Long coreUser;

    private Set<Long> addresses;

    private Set<Long> paymentMethods;

    private Set<ClientDeferredProductKey> deferredProducts;

    private Set<ClientShoppedProductKey> shoppedProducts;

    private Set<Long> coreOrders;

    private Set<Long> specialConditions;

    private Set<Long> productFeedbacks;
}
