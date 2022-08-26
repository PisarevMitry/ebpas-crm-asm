package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductEntity;

@Mapper(componentModel = "spring")
public interface ClientShoppedProductMapper extends CommonMapper<ClientShoppedProductEntity, ClientShoppedProductDto> {

}
