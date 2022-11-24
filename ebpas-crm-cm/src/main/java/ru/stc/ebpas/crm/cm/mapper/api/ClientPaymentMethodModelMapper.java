package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientPaymentMethodEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class})
public interface ClientPaymentMethodModelMapper extends SimpleModelMapper<ClientPaymentMethodEntity, ClientPaymentMethodDto> {

}
