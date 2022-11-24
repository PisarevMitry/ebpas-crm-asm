package ru.stc.ebpas.crm.scm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.scm.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.scm.model.entity.SpecialConditionType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreSpecialConditionModelMapper.class})
public interface SpecialConditionTypeModelMapper extends SimpleModelMapper<SpecialConditionType, SpecialConditionTypeDto> {

}
