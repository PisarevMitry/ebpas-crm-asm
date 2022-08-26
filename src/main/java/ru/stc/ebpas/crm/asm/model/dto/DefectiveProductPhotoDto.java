package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.MediaDto;

@Schema(description = "Фото бракованного товара")
@Data
public class DefectiveProductPhotoDto extends MediaDto {

    private Long id;

    private DefectiveProductDto defectiveProduct;

}
