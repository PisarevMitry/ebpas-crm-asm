package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductPhotoEntity;

@Mapper(componentModel = "spring")
public interface DefectiveProductPhotoMapper extends CommonMapper<DefectiveProductPhotoEntity, DefectiveProductPhotoDto> {

}
