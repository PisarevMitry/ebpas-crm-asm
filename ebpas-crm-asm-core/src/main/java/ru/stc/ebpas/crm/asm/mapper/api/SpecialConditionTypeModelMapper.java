package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.SpecialConditionType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreSpecialConditionModelMapper.class})
public interface SpecialConditionTypeModelMapper extends SimpleModelMapper<SpecialConditionType, SpecialConditionTypeDto> {

}
