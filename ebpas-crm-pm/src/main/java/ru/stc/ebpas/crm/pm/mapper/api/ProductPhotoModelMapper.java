package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.ProductPhotoDto;
import ru.stc.ebpas.crm.pm.model.entity.ProductPhotoEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ProductModelMapper.class})
public interface ProductPhotoModelMapper extends SimpleModelMapper<ProductPhotoEntity, ProductPhotoDto> {

}
