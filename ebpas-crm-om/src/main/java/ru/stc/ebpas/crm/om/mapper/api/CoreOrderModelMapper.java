package ru.stc.ebpas.crm.om.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.om.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.om.model.entity.CoreOrderEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {AssemblyDetailsModelMapper.class,
                PaymentDetailsModelMapper.class,
                DeliveryDetailsModelMapper.class,
                ReturnDetailsModelMapper.class})
public interface CoreOrderModelMapper extends SimpleModelMapper<CoreOrderEntity, CoreOrderDto> {

}
