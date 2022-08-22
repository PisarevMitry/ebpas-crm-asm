package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientPaymentMethodEntity;

@Mapper(componentModel = "spring")
public interface ClientPaymentMethodMapper extends CommonMapper<ClientPaymentMethodEntity, ClientPaymentMethodDto> {

}
