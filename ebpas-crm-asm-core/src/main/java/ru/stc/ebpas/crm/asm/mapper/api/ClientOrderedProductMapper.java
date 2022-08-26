package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;

@Mapper(componentModel = "spring")
public interface ClientOrderedProductMapper extends CommonMapper<ClientOrderedProductEntity, ClientOrderedProductDto> {

}
