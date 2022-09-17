package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiMediaDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Фото бракованного товара")
public class DefectiveProductPhotoDto implements DatabaseDto {

    protected NsiMediaDto nsiMedia;
    private Long id;
    private DefectiveProductDto defectiveProduct;

}
