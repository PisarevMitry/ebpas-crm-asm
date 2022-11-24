package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class})
public interface ClientDeferredProductModelMapper
        extends ComplexModelMapper<ClientDeferredProductEntity, ClientDeferredProductDto, ClientDeferredProductKey> {

}
