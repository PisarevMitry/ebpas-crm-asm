package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.stc.ebpas.crm.pm.mapper.impl.DateTimeMapper;
import ru.stc.ebpas.crm.pm.mapper.impl.NsiRecordMapper;
import ru.stc.ebpas.crm.pm.mapper.impl.ReferenceKeyMapper;
import ru.stc.ebpas.crm.pm.mapper.impl.ReferenceMapper;

@MapperConfig(componentModel = "spring",
        uses = {ReferenceMapper.class,
                ReferenceKeyMapper.class,
                NsiRecordMapper.class,
                DateTimeMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface ConfigModelMapper {
}
