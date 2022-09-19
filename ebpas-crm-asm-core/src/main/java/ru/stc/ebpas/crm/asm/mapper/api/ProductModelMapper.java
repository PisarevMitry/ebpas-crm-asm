package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreProductModelMapper.class,
                AvailableProductModelMapper.class,
                DefectiveProductModelMapper.class,
                ProductCategoryModelMapper.class,
                ProductFeedbackModelMapper.class,
                ProductPhotoModelMapper.class,
                CoreSpecialConditionModelMapper.class})
public interface ProductModelMapper extends SimpleModelMapper<ProductEntity, ProductDto> {

}
