package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.ProductModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ProductDto;
import ru.stc.ebpas.crm.core.model.entity.ProductEntity;
import ru.stc.ebpas.crm.core.repository.ProductRepository;
import ru.stc.ebpas.crm.core.service.api.ProductService;

@AllArgsConstructor
@Service
public class ProductServiceImpl
        extends AbstractSimpleModelDefaultService<ProductEntity, ProductDto>
        implements ProductService {

    private final ProductModelMapper productModelMapper;

    private final ProductRepository productRepository;

    @Override
    public SimpleModelMapper<ProductEntity, ProductDto> getMapper() {
        return productModelMapper;
    }

    @Override
    public SimpleModelRepository<ProductEntity> getRepository() {
        return productRepository;
    }
}

