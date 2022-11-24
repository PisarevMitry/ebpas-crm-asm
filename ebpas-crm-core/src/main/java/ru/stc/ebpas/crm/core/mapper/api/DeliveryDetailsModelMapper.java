package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.core.model.entity.DeliveryDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {DeliveryTypeModelMapper.class,
                CoreOrderModelMapper.class})
public interface DeliveryDetailsModelMapper extends SimpleModelMapper<DeliveryDetailsEntity, DeliveryDetailsDto> {

}
