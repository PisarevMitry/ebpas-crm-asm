package ru.stc.ebpas.crm.om.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Способ оплаты")
public class PaymentTypeDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String payment_name;

    private Object systemDetails;

    private Set<PaymentDetailsDto> paymentDetails;
}
