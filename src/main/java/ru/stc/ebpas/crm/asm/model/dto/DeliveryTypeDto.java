package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Способ доставки")
@Data
public class DeliveryTypeDto {

    private Long id;

    private String deliveryName;

    private String systemDetails;

    private Set<DeliveryDetailsDto> deliveryDetails;
}
