package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreUserModelMapper.class,
                ClientAddressModelMapper.class,
                ClientPaymentMethodModelMapper.class,
                ClientDeferredProductModelMapper.class,
                ClientShoppedProductModelMapper.class})
public interface ClientModelMapper extends SimpleModelMapper<ClientEntity, ClientDto> {

}
