package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper extends CommonMapper<ProductEntity, ProductDto> {

}
