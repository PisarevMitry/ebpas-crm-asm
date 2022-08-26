package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.NsiAddress;
import ru.stc.ebpas.crm.asm.model.constant.NsiStatus;

import java.time.LocalDateTime;

@Schema(description = "Сведения о доставке заказа")
@Data
public class DeliveryDetailsDto {

    private Long id;

    private DeliveryTypeDto deliveryType;

    private NsiAddress nsiAddress;

    private LocalDateTime startDeliveryDttm;

    private LocalDateTime endDeliveryDttm;

    private String deliveryNotes;

    private NsiStatus nsiDeliveryStatus;

    private CoreOrderDto coreOrder;
}
