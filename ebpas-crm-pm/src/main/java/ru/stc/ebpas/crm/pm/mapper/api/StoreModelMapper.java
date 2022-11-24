package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.StoreDto;
import ru.stc.ebpas.crm.pm.model.entity.StoreEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {AvailableProductModelMapper.class})
public interface StoreModelMapper extends SimpleModelMapper<StoreEntity, StoreDto> {

}
