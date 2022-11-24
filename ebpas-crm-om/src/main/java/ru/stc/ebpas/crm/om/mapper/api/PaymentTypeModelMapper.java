package ru.stc.ebpas.crm.om.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.om.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.om.model.entity.PaymentType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {PaymentDetailsModelMapper.class})
public interface PaymentTypeModelMapper extends SimpleModelMapper<PaymentType, PaymentTypeDto> {

}
