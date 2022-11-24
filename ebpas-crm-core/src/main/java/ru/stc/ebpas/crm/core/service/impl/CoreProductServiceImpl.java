package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.CoreProductModelMapper;
import ru.stc.ebpas.crm.core.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.core.model.entity.CoreProductEntity;
import ru.stc.ebpas.crm.core.repository.CoreProductRepository;
import ru.stc.ebpas.crm.core.service.api.CoreProductService;

@AllArgsConstructor
@Service
public class CoreProductServiceImpl
        extends AbstractSimpleModelDefaultService<CoreProductEntity, CoreProductDto>
        implements CoreProductService {

    private final CoreProductModelMapper coreProductModelMapper;

    private final CoreProductRepository coreProductRepository;

    @Override
    public SimpleModelMapper<CoreProductEntity, CoreProductDto> getMapper() {
        return coreProductModelMapper;
    }

    @Override
    public SimpleModelRepository<CoreProductEntity> getRepository() {
        return coreProductRepository;
    }
}

