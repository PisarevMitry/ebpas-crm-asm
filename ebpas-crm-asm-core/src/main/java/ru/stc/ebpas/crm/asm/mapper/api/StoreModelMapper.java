package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.StoreDto;
import ru.stc.ebpas.crm.asm.model.entity.StoreEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {AvailableProductModelMapper.class,
                CoreSpecialConditionModelMapper.class})
public interface StoreModelMapper extends SimpleModelMapper<StoreEntity, StoreDto> {

}
