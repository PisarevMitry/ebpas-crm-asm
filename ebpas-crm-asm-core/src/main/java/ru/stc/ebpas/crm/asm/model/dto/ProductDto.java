package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.DatabaseDto;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Товар")
public class ProductDto implements DatabaseDto {

    private Long id;

    private CoreProductDto coreProduct;

    private String description;

    private String options;

    private Boolean blocked;

    private Set<AvailableProductDto> availableProducts;

    private Set<DefectiveProductDto> defectiveProducts;

    private Set<ProductCategoryDto> categories;

    private Set<ProductFeedbackDto> feedbacks;

    private Set<ProductPhotoDto> photos;

    private Set<CoreSpecialConditionDto> specialConditions;
}
