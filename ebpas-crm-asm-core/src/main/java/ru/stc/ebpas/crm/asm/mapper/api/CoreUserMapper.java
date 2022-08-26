package ru.stc.ebpas.crm.asm.mapper.api;


import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreUserEntity;

@Mapper(componentModel = "spring")
public interface CoreUserMapper extends CommonMapper<CoreUserEntity, CoreUserDto> {

}