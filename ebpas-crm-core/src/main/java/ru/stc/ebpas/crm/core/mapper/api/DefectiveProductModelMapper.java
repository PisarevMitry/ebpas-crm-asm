package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.core.model.entity.DefectiveProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ReturnDetailsModelMapper.class,
                ProductModelMapper.class,
                DefectiveProductPhotoModelMapper.class})
public interface DefectiveProductModelMapper extends SimpleModelMapper<DefectiveProductEntity, DefectiveProductDto> {

}
