package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.pm.model.entity.AvailableProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class,
                StoreModelMapper.class})
public interface AvailableProductModelMapper extends SimpleModelMapper<AvailableProductEntity, AvailableProductDto> {

}
