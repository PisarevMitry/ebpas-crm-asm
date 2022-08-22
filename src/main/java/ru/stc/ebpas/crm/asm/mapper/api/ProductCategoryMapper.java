package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductCategoryEntity;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends CommonMapper<ProductCategoryEntity, ProductCategoryDto> {

}
