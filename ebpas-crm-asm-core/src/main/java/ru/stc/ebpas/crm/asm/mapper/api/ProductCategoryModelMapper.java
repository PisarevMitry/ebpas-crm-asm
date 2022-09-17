package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.ReferenceMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductCategoryEntity;

@Mapper(componentModel = "spring",
        uses = {ReferenceMapper.class,
                NsiRecordMapper.class,
                ProductCategoryModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ProductModelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ProductCategoryModelMapper extends SimpleModelMapper<ProductCategoryEntity, ProductCategoryDto> {

}
