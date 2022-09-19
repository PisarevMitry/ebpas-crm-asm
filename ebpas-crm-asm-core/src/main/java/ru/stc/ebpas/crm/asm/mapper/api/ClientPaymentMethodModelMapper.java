package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientPaymentMethodEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class,
                PaymentTypeModelMapper.class})
public interface ClientPaymentMethodModelMapper extends SimpleModelMapper<ClientPaymentMethodEntity, ClientPaymentMethodDto> {

}
