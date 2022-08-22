package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.SpecialConditionType;

@Mapper(componentModel = "spring")
public interface SpecialConditionTypeMapper extends CommonMapper<SpecialConditionType, SpecialConditionTypeDto> {

}
