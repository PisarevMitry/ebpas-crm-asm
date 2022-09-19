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
@Schema(description = "Товар")
public class ProductDto implements SimpleDatabaseDto {

    private Long id;

    private Long coreProduct;

    private String description;

    private String options;

    private Boolean blocked;

    private Set<Long> availableProducts;

    private Set<Long> defectiveProducts;

    private Set<Long> categories;

    private Set<Long> feedbacks;

    private Set<Long> photos;

    private Set<Long> specialConditions;
}
