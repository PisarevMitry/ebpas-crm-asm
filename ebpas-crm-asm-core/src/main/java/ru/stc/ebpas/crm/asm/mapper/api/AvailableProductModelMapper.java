package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.asm.model.entity.AvailableProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class,
                StoreModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ClientDeferredProductModelMapper.class,
                ClientOrderedProductModelMapper.class,
                ClientShoppedProductModelMapper.class})
public interface AvailableProductModelMapper extends SimpleModelMapper<AvailableProductEntity, AvailableProductDto> {

}
