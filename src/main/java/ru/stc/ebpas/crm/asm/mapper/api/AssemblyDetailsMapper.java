package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.AssemblyDetailsEntity;

@Mapper(componentModel = "spring")
public interface AssemblyDetailsMapper extends CommonMapper<AssemblyDetailsEntity, AssemblyDetailsDto> {

}
