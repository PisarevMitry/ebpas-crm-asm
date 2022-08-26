package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentType;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends CommonMapper<PaymentType, PaymentTypeDto> {

}
