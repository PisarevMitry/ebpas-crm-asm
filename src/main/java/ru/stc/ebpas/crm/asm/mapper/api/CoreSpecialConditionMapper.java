package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreSpecialConditionEntity;

@Mapper(componentModel = "spring")
public interface CoreSpecialConditionMapper extends CommonMapper<CoreSpecialConditionEntity, CoreSpecialConditionDto> {

}