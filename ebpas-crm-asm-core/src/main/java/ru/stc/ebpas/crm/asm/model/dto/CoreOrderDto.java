package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

@Data
@Schema(description = "Основные данные о заказе")
public class CoreOrderDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private AssemblyDetailsDto assemblyDetails;

    private PaymentDetailsDto paymentDetails;

    private DeliveryDetailsDto deliveryDetails;

    private ReturnDetailsDto returnDetails;

    private ClientDto client;

    private NsiStatusDto nsiCoreOrderStatus;

    private Boolean requirementOrgDocStatus;
}
