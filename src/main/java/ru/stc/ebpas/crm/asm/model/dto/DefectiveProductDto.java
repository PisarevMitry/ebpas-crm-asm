package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Бракованный товар")
@Data
public class DefectiveProductDto {

    private Long id;

    private ReturnDetailsDto returnDetails;

    private ProductDto product;

    private String defectDescription;

    private Boolean receivingStatus;

    private String systemDetails;

    private String systemDetailsValue;

    private Set<DefectiveProductPhotoDto> defectiveProductPhotos;
}
