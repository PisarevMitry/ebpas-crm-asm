package ru.stc.ebpas.crm.om.mapper.api;


import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.om.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.om.model.entity.AssemblyDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreOrderModelMapper.class})
public interface AssemblyDetailsModelMapper extends SimpleModelMapper<AssemblyDetailsEntity, AssemblyDetailsDto> {
}
