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
@Schema(description = "Сведения об оплате")
public class PaymentDetailsDto implements SimpleDatabaseDto {

    private Long id;

    private Long paymentType;

    private String systemDetailsValue;

    private NsiStatusDto nsiPaymentStatus;

    private Long coreOrder;
}
