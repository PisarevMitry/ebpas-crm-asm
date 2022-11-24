package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class,
                AvailableProductModelMapper.class})
public interface ClientDeferredProductModelMapper
        extends ComplexModelMapper<ClientDeferredProductEntity, ClientDeferredProductDto, ClientDeferredProductKey> {

}
