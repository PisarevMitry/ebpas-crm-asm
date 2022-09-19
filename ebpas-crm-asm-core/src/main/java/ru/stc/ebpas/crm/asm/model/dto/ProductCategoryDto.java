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
@Schema(description = "Категория товара")
public class ProductCategoryDto implements SimpleDatabaseDto {

    private Long id;

    private String name;

    private Long parentProductCategory;

    private Set<Long> specialConditions;

    private Set<Long> products;

    private Set<Long> childProductCategories;
}
