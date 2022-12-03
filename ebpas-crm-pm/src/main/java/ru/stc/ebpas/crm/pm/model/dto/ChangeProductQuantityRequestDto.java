package ru.stc.ebpas.crm.pm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Запрос на изменение количества/перемещение товара")
public class ChangeProductQuantityRequestDto {

    private String productNomenclature;

    private Integer count;

    private Long senderStoreId;

    private Long recipientStoreId;

}
