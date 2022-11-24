package ru.stc.ebpas.crm.cm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

@Data
@Schema(description = "Способ оплаты, сохраненый пользователем")
public class ClientPaymentMethodDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ClientDto client;

    private Long paymentType;

    private Object systemDetails;

    private Boolean displayed;

    private Boolean defaultUsed;

    private Boolean blocked;
}
