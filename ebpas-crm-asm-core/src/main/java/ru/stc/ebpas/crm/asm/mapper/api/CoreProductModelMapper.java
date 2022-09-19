package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class})
public interface CoreProductModelMapper extends SimpleModelMapper<CoreProductEntity, CoreProductDto> {

}