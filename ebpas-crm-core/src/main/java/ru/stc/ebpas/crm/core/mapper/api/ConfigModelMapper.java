package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.crm.core.mapper.impl.DateTimeMapper;
import ru.stc.ebpas.crm.core.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.core.mapper.impl.ReferenceKeyMapper;
import ru.stc.ebpas.crm.core.mapper.impl.ReferenceMapper;

@MapperConfig(componentModel = "spring",
        uses = {ReferenceMapper.class,
                ReferenceKeyMapper.class,
                NsiRecordMapper.class,
                DateTimeMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ConfigModelMapper {
}
