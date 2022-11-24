package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.ProductPhotoModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ProductPhotoDto;
import ru.stc.ebpas.crm.core.model.entity.ProductPhotoEntity;
import ru.stc.ebpas.crm.core.repository.ProductPhotoRepository;
import ru.stc.ebpas.crm.core.service.api.ProductPhotoService;

@AllArgsConstructor
@Service
public class ProductPhotoServiceImpl
        extends AbstractSimpleModelDefaultService<ProductPhotoEntity, ProductPhotoDto>
        implements ProductPhotoService {

    private final ProductPhotoModelMapper productPhotoModelMapper;

    private final ProductPhotoRepository productPhotoRepository;

    @Override
    public SimpleModelMapper<ProductPhotoEntity, ProductPhotoDto> getMapper() {
        return productPhotoModelMapper;
    }

    @Override
    public SimpleModelRepository<ProductPhotoEntity> getRepository() {
        return productPhotoRepository;
    }
}

