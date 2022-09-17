package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сведения о доставке заказа")
public class DeliveryDetailsDto implements DatabaseDto {

    private Long id;

    private DeliveryTypeDto deliveryType;

    private NsiAddressDto nsiAddress;

    private LocalDateTime startDeliveryDttm;

    private LocalDateTime endDeliveryDttm;

    private String deliveryNotes;

    private NsiStatusDto nsiDeliveryStatus;

    private Long coreOrder;
}
