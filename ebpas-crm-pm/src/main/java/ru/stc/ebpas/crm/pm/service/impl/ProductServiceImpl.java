package ru.stc.ebpas.crm.pm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.pm.mapper.api.ProductModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.ProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ProjectProductDto;
import ru.stc.ebpas.crm.pm.model.entity.ProductEntity;
import ru.stc.ebpas.crm.pm.repository.ProductRepository;
import ru.stc.ebpas.crm.pm.service.api.ProductService;

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

    @Override
    public ProductDto save(ProjectProductDto projectProduct) {
        ProductEntity product = productModelMapper.map(projectProduct);
        ProductEntity savedProduct = productRepository.save(product);
        return productModelMapper.toDto(savedProduct);
    }
}

