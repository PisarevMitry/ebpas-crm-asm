package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.asm.mapper.impl.ReferenceMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentDetailsEntity;

@Mapper(componentModel = "spring",
        uses = {ReferenceMapper.class,
                PaymentTypeModelMapper.class,
                NsiRecordMapper.class,

                CoreOrderModelMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface PaymentDetailsModelMapper extends SimpleModelMapper<PaymentDetailsEntity, PaymentDetailsDto> {

}
