package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.ProductCategoryModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductCategoryEntity;
import ru.stc.ebpas.crm.asm.repository.ProductCategoryRepository;
import ru.stc.ebpas.crm.asm.service.api.ProductCategoryService;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl
        extends AbstractSimpleModelDefaultService<ProductCategoryEntity, ProductCategoryDto>
        implements ProductCategoryService {

    private final ProductCategoryModelMapper productCategoryModelMapper;

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public SimpleModelMapper<ProductCategoryEntity, ProductCategoryDto> getMapper() {
        return productCategoryModelMapper;
    }

    @Override
    public SimpleModelRepository<ProductCategoryEntity> getRepository() {
        return productCategoryRepository;
    }
}

