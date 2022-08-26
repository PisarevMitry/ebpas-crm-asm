package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryDetailsEntity;

@Mapper(componentModel = "spring")
public interface DeliveryDetailsMapper extends CommonMapper<DeliveryDetailsEntity, DeliveryDetailsDto> {

}
