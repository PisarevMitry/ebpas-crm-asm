package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.ReferenceMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;

@Mapper(componentModel = "spring",
        uses = {ReferenceMapper.class,
                NsiRecordMapper.class,
                ClientModelMapper.class,
                AvailableProductModelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ClientDeferredProductModelMapper extends ComplexModelMapper<ClientDeferredProductEntity, ClientDeferredProductDto, ClientDeferredProductKey> {

}
