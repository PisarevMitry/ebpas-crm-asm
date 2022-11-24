package ru.stc.ebpas.crm.pm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiMediaDto;

@Data
@Schema(description = "Фото товара")
public class ProductPhotoDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private NsiMediaDto nsiMedia;

    private Long product;
}
