package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.core.model.entity.AvailableProductEntity;

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
