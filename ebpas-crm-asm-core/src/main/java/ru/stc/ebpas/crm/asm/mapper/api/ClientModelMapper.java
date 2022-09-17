package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.ReferenceMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientEntity;

@Mapper(componentModel = "spring",
        uses = {ReferenceMapper.class,
                NsiRecordMapper.class,

                CoreUserModelMapper.class,
                ClientAddressModelMapper.class,
                ClientPaymentMethodModelMapper.class,
                ClientDeferredProductModelMapper.class,
                ClientShoppedProductModelMapper.class,
                CoreOrderModelMapper.class,
                CoreSpecialConditionModelMapper.class,
                ProductFeedbackModelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ClientModelMapper extends SimpleModelMapper<ClientEntity, ClientDto> {

}
