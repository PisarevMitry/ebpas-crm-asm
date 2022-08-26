package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.asm.model.entity.AvailableProductEntity;

@Mapper(componentModel = "spring")
public interface AvailableProductMapper extends CommonMapper<AvailableProductEntity, AvailableProductDto> {

}
