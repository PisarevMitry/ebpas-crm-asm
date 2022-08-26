package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductEntity;
import ru.stc.ebpas.crm.asm.repository.ProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ProductService;

@AllArgsConstructor
@Service
public class ProductServiceImpl extends AbstractCommonService<ProductEntity, ProductDto> implements ProductService {

    private final ProductMapper ProductMapper;

    private final ProductRepository ProductRepository;

    @Override
    public CommonMapper<ProductEntity, ProductDto> getMapper() {
        return ProductMapper;
    }

    @Override
    public CommonRepository<ProductEntity> getRepository() {
        return ProductRepository;
    }
}

