package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Способ оплаты, сохраненый пользователем")
public class ClientPaymentMethodDto implements SimpleDatabaseDto {

    private Long id;

    private Long client;

    private Long paymentType;

    private String systemDetailsValue;

    private Boolean displayed;

    private Boolean defaultUsed;

    private Boolean blocked;
}
