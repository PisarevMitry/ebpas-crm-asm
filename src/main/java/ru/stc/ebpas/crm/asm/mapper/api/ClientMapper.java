package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientMapper extends CommonMapper<ClientEntity, ClientDto> {

}
