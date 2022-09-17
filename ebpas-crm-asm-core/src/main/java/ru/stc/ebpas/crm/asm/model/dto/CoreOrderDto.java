package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Основные данные о заказе")
public class CoreOrderDto implements DatabaseDto {

    private Long id;

    private AssemblyDetailsDto assemblyDetails;

    private PaymentDetailsDto paymentDetails;

    private DeliveryDetailsDto deliveryDetails;

    private ReturnDetailsDto returnDetails;

    private ClientDto client;//TODO

    private NsiStatusDto nsiCoreOrderStatus;

    private Boolean requirementOrgDocStatus;
}
