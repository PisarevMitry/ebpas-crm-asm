package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.StoreModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.StoreDto;
import ru.stc.ebpas.crm.asm.model.entity.StoreEntity;
import ru.stc.ebpas.crm.asm.repository.StoreRepository;
import ru.stc.ebpas.crm.asm.service.api.StoreService;

@AllArgsConstructor
@Service
public class StoreServiceImpl
        extends AbstractSimpleModelDefaultService<StoreEntity, StoreDto>
        implements StoreService {

    private final StoreModelMapper storeModelMapper;

    private final StoreRepository storeRepository;

    @Override
    public SimpleModelMapper<StoreEntity, StoreDto> getMapper() {
        return storeModelMapper;
    }

    @Override
    public SimpleModelRepository<StoreEntity> getRepository() {
        return storeRepository;
    }
}

