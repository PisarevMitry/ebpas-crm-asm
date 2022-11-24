package ru.stc.ebpas.crm.pm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Товар")
public class ProductDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String nomenclature;

    private CoreProductDto coreProduct;

    private String description;

    private ObjectNode options;

    private Boolean blocked;

    private Set<AvailableProductDto> availableProducts;

    private Set<Long> defectiveProducts;

    private Set<ProductCategoryDto> categories;

    private Set<ProductFeedbackDto> feedbacks;

    private Set<ProductPhotoDto> photos;

    private Set<Long> specialConditions;
}
