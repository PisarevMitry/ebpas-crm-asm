package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreProductEntity;

@Mapper(componentModel = "spring")
public interface CoreProductMapper extends CommonMapper<CoreProductEntity, CoreProductDto> {

}