package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreSpecialConditionEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {SpecialConditionTypeModelMapper.class,
                AvailableProductModelMapper.class,
                ProductCategoryModelMapper.class,
                ClientModelMapper.class,
                ProductModelMapper.class,
                StoreModelMapper.class})
public interface CoreSpecialConditionModelMapper extends SimpleModelMapper<CoreSpecialConditionEntity, CoreSpecialConditionDto> {

}