package ru.stc.ebpas.crm.pm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.ProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ProjectProductDto;
import ru.stc.ebpas.crm.pm.model.entity.ProductEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {CoreProductModelMapper.class,
                AvailableProductModelMapper.class,
                ProductCategoryModelMapper.class,
                ProductFeedbackModelMapper.class,
                ProductPhotoModelMapper.class})
public interface ProductModelMapper extends SimpleModelMapper<ProductEntity, ProductDto> {

    default ProductEntity map(ProjectProductDto projectProduct) {
        ProductEntity product = new ProductEntity();
        product.setNomenclature(projectProduct.getNomenclature());
        return product;
    }
}
