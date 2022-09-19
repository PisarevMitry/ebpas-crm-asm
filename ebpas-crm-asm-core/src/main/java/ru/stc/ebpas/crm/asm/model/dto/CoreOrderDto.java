package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Основные данные о заказе")
public class CoreOrderDto implements SimpleDatabaseDto {

    private Long id;

    private Long assemblyDetails;

    private Long paymentDetails;

    private Long deliveryDetails;

    private Long returnDetails;

    private Long client;

    private NsiStatusDto nsiCoreOrderStatus;

    private Boolean requirementOrgDocStatus;
}
