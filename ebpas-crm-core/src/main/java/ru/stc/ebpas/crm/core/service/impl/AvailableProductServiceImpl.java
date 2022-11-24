package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.AvailableProductModelMapper;
import ru.stc.ebpas.crm.core.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.core.model.entity.AvailableProductEntity;
import ru.stc.ebpas.crm.core.repository.AvailableProductRepository;
import ru.stc.ebpas.crm.core.service.api.AvailableProductService;

@AllArgsConstructor
@Service
public class AvailableProductServiceImpl
        extends AbstractSimpleModelDefaultService<AvailableProductEntity, AvailableProductDto>
        implements AvailableProductService {

    private final AvailableProductModelMapper availableProductMapper;

    private final AvailableProductRepository availableProductRepository;

    @Override
    public SimpleModelMapper<AvailableProductEntity, AvailableProductDto> getMapper() {
        return availableProductMapper;
    }

    @Override
    public SimpleModelRepository<AvailableProductEntity> getRepository() {
        return availableProductRepository;
    }
}

