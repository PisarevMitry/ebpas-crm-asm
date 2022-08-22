package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductPhotoEntity;

@Mapper(componentModel = "spring")
public interface ProductPhotoMapper extends CommonMapper<ProductPhotoEntity, ProductPhotoDto> {

}
