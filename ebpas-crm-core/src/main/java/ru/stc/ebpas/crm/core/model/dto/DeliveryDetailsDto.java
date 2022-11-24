package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiAddressDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;

import java.time.LocalDateTime;

@Data
@Schema(description = "Сведения о доставке заказа")
public class DeliveryDetailsDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private DeliveryTypeDto deliveryType;

    private NsiAddressDto nsiAddress;

    private LocalDateTime startDeliveryDttm;

    private LocalDateTime endDeliveryDttm;

    private String deliveryNotes;

    private NsiStatusDto nsiDeliveryStatus;

    private CoreOrderDto coreOrder;
}
