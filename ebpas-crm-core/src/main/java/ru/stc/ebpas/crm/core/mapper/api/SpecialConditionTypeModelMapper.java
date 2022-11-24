package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.core.model.entity.SpecialConditionType;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreSpecialConditionModelMapper.class})
public interface SpecialConditionTypeModelMapper extends SimpleModelMapper<SpecialConditionType, SpecialConditionTypeDto> {

}
