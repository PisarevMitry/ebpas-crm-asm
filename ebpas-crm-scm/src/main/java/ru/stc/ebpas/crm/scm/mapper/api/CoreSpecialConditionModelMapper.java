package ru.stc.ebpas.crm.scm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.scm.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.scm.model.entity.CoreSpecialConditionEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {SpecialConditionTypeModelMapper.class})
public interface CoreSpecialConditionModelMapper extends SimpleModelMapper<CoreSpecialConditionEntity, CoreSpecialConditionDto> {

}