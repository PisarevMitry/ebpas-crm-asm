package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class,
                AvailableProductModelMapper.class})
public interface ClientDeferredProductModelMapper
        extends ComplexModelMapper<ClientDeferredProductEntity, ClientDeferredProductDto, ClientDeferredProductKey> {

}
