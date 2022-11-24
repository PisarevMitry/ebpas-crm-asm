package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.core.model.entity.PaymentType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientPaymentMethodModelMapper.class,
                PaymentDetailsModelMapper.class})
public interface PaymentTypeModelMapper extends SimpleModelMapper<PaymentType, PaymentTypeDto> {

}
