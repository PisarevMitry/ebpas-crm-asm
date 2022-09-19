package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Бракованный товар")
public class DefectiveProductDto implements SimpleDatabaseDto {

    private Long id;

    private Long returnDetails;

    private Long product;

    private String defectDescription;

    private Boolean receivingStatus;

    private String systemDetails;

    private String systemDetailsValue;

    private Set<Long> defectiveProductPhotos;
}
