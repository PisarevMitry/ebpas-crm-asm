package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.ReferenceMapper;
import ru.stc.ebpas.crm.asm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.asm.model.entity.AvailableProductEntity;

@Mapper(componentModel = "spring",
        uses = {ReferenceMapper.class,
                NsiRecordMapper.class,
                ProductModelMapper.class,
                StoreModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ClientDeferredProductModelMapper.class,
                ClientOrderedProductModelMapper.class,
                ClientShoppedProductModelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface AvailableProductModelMapper extends SimpleModelMapper<AvailableProductEntity, AvailableProductDto> {

}
