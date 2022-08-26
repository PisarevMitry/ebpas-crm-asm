package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Товар")
@Data
public class ProductDto {

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
