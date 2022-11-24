package ru.stc.ebpas.crm.om.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.om.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.om.model.entity.DefectiveProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ReturnDetailsModelMapper.class,
                DefectiveProductPhotoModelMapper.class})
public interface DefectiveProductModelMapper extends SimpleModelMapper<DefectiveProductEntity, DefectiveProductDto> {

}
