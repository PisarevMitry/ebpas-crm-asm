package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientDto;
import ru.stc.ebpas.crm.core.model.entity.ClientEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreUserModelMapper.class,
                ClientAddressModelMapper.class,
                ClientPaymentMethodModelMapper.class,
                ClientDeferredProductModelMapper.class,
                ClientShoppedProductModelMapper.class,
                CoreOrderModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ProductFeedbackModelMapper.class})
public interface ClientModelMapper extends SimpleModelMapper<ClientEntity, ClientDto> {

}
