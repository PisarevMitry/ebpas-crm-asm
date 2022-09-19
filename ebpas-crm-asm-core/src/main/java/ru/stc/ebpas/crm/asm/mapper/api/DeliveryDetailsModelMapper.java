package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {DeliveryTypeModelMapper.class,
                CoreOrderModelMapper.class})
public interface DeliveryDetailsModelMapper extends SimpleModelMapper<DeliveryDetailsEntity, DeliveryDetailsDto> {

}
