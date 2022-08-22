package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ReturnDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.ReturnDetailsEntity;

@Mapper(componentModel = "spring")
public interface ReturnDetailsMapper extends CommonMapper<ReturnDetailsEntity, ReturnDetailsDto> {

}
