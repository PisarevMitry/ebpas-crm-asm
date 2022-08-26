package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;

@Mapper(componentModel = "spring")
public interface ClientDeferredProductMapper extends CommonMapper<ClientDeferredProductEntity, ClientDeferredProductDto> {

}
