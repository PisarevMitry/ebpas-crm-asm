package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.StoreDto;
import ru.stc.ebpas.crm.asm.model.entity.StoreEntity;

@Mapper(componentModel = "spring")
public interface StoreMapper extends CommonMapper<StoreEntity, StoreDto> {

}
