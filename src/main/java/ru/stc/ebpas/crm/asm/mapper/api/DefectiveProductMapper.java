package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductEntity;

@Mapper(componentModel = "spring")
public interface DefectiveProductMapper extends CommonMapper<DefectiveProductEntity, DefectiveProductDto> {

}
