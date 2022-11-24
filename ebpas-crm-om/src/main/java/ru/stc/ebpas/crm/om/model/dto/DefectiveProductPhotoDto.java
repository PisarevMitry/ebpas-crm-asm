package ru.stc.ebpas.crm.om.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiMediaDto;

@Data
@Schema(description = "Фото бракованного товара")
public class DefectiveProductPhotoDto implements SimpleDatabaseDto {

    protected NsiMediaDto nsiMedia;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private DefectiveProductDto defectiveProduct;
}
