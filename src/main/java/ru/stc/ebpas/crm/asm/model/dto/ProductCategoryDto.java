package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Schema(description = "Категория товара")
@Data
public class ProductCategoryDto {

    private Long id;

    private String name;

    private ProductCategoryDto parentProductCategory;

    private Set<CoreSpecialConditionDto> specialConditions;

    private Set<ProductDto> products;

    private Set<ProductCategoryDto> childProductCategories;
}
