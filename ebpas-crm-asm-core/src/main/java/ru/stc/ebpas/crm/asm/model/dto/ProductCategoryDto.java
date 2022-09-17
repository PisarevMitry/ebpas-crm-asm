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
@Schema(description = "Категория товара")
public class ProductCategoryDto implements DatabaseDto {

    private Long id;

    private String name;

    private ProductCategoryDto parentProductCategory;

    private Set<CoreSpecialConditionDto> specialConditions;

    private Set<ProductDto> products;

    private Set<ProductCategoryDto> childProductCategories;
}
