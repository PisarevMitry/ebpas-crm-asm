package ru.stc.ebpas.crm.asm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Бракованный товар")
public class DefectiveProductDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ReturnDetailsDto returnDetails;

    private ProductDto product;

    private String defectDescription;

    private Boolean receivingStatus;

    private Object systemDetails;

    private Set<DefectiveProductPhotoDto> defectiveProductPhotos;
}
