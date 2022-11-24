package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.core.model.entity.CoreProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class})
public interface CoreProductModelMapper extends SimpleModelMapper<CoreProductEntity, CoreProductDto> {

}