package ru.stc.ebpas.crm.core.mapper.api;


import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.core.model.entity.AssemblyDetailsEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientOrderedProductModelMapper.class,
                CoreOrderModelMapper.class})
public interface AssemblyDetailsModelMapper extends SimpleModelMapper<AssemblyDetailsEntity, AssemblyDetailsDto> {
}
