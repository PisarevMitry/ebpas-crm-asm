package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ProductCategoryMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductCategoryDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductCategoryEntity;
import ru.stc.ebpas.crm.asm.repository.ProductCategoryRepository;
import ru.stc.ebpas.crm.asm.service.api.ProductCategoryService;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl extends AbstractCommonService<ProductCategoryEntity, ProductCategoryDto> implements ProductCategoryService {

    private final ProductCategoryMapper ProductCategoryMapper;

    private final ProductCategoryRepository ProductCategoryRepository;

    @Override
    public CommonMapper<ProductCategoryEntity, ProductCategoryDto> getMapper() {
        return ProductCategoryMapper;
    }

    @Override
    public CommonRepository<ProductCategoryEntity> getRepository() {
        return ProductCategoryRepository;
    }
}

