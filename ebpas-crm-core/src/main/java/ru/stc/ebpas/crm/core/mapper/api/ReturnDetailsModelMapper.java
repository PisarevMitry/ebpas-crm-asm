package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ReturnDetailsDto;
import ru.stc.ebpas.crm.core.model.entity.ReturnDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreOrderModelMapper.class,
                DefectiveProductModelMapper.class})
public interface ReturnDetailsModelMapper extends SimpleModelMapper<ReturnDetailsEntity, ReturnDetailsDto> {

}
