package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientAddressEntity;

@Mapper(componentModel = "spring")
public interface ClientAddressMapper extends CommonMapper<ClientAddressEntity, ClientAddressDto> {

}
