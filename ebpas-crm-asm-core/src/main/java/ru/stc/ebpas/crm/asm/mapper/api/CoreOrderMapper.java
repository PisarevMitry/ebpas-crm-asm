package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreOrderEntity;

@Mapper(componentModel = "spring")
public interface CoreOrderMapper extends CommonMapper<CoreOrderEntity, CoreOrderDto> {

}
