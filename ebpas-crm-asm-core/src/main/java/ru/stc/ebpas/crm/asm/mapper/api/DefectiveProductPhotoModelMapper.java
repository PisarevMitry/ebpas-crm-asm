package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductPhotoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {DefectiveProductModelMapper.class})
public interface DefectiveProductPhotoModelMapper extends SimpleModelMapper<DefectiveProductPhotoEntity, DefectiveProductPhotoDto> {

}
