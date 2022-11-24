package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Категория товара")
public class ProductCategoryDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    private ProductCategoryDto parentProductCategory;

    private Set<CoreSpecialConditionDto> specialConditions;

    private Set<ProductDto> products;

    private Set<ProductCategoryDto> childProductCategories;
}
