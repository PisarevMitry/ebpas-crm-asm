package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ProductPhotoMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductPhotoEntity;
import ru.stc.ebpas.crm.asm.repository.ProductPhotoRepository;
import ru.stc.ebpas.crm.asm.service.api.ProductPhotoService;

@AllArgsConstructor
@Service
public class ProductPhotoServiceImpl extends AbstractCommonService<ProductPhotoEntity, ProductPhotoDto> implements ProductPhotoService {

    private final ProductPhotoMapper ProductPhotoMapper;

    private final ProductPhotoRepository ProductPhotoRepository;

    @Override
    public CommonMapper<ProductPhotoEntity, ProductPhotoDto> getMapper() {
        return ProductPhotoMapper;
    }

    @Override
    public CommonRepository<ProductPhotoEntity> getRepository() {
        return ProductPhotoRepository;
    }
}

