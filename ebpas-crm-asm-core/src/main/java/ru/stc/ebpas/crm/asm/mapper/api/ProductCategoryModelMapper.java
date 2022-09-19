package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductCategoryEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductCategoryModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ProductModelMapper.class})
public interface ProductCategoryModelMapper extends SimpleModelMapper<ProductCategoryEntity, ProductCategoryDto> {

}
