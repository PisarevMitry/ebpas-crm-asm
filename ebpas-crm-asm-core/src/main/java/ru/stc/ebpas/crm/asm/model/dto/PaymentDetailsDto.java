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
@Schema(description = "Сведения об оплате")
public class PaymentDetailsDto implements DatabaseDto {

    private Long id;

    private PaymentTypeDto paymentType;

    private String systemDetailsValue;

    private NsiStatusDto nsiPaymentStatus;

    private Long coreOrder;
}
