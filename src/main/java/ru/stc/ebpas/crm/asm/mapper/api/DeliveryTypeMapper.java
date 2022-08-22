package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryType;

@Mapper(componentModel = "spring")
public interface DeliveryTypeMapper extends CommonMapper<DeliveryType, DeliveryTypeDto> {

}
