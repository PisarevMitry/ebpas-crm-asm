package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {DeliveryDetailsModelMapper.class})
public interface DeliveryTypeModelMapper extends SimpleModelMapper<DeliveryType, DeliveryTypeDto> {

}
