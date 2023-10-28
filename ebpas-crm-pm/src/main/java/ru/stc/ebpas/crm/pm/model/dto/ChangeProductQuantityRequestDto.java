package ru.stc.ebpas.crm.pm.model.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Запрос на изменение количества/перемещение товара")
public class ChangeProductQuantityRequestDto {

    private String productNomenclature;

    private Integer count;

    @Hidden
    private Long senderStoreId;

    private Long recipientStoreId;

}
