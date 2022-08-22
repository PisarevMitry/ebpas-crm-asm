package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentDetailsEntity;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper extends CommonMapper<PaymentDetailsEntity, PaymentDetailsDto> {

}
