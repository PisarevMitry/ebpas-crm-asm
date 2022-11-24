package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.core.model.entity.CoreOrderEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {AssemblyDetailsModelMapper.class,
                PaymentDetailsModelMapper.class,
                DeliveryDetailsModelMapper.class,
                ReturnDetailsModelMapper.class,
                ClientModelMapper.class})
public interface CoreOrderModelMapper extends SimpleModelMapper<CoreOrderEntity, CoreOrderDto> {

}
