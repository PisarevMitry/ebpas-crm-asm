package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.StoreMapper;
import ru.stc.ebpas.crm.asm.model.dto.StoreDto;
import ru.stc.ebpas.crm.asm.model.entity.StoreEntity;
import ru.stc.ebpas.crm.asm.repository.StoreRepository;
import ru.stc.ebpas.crm.asm.service.api.StoreService;

@AllArgsConstructor
@Service
public class StoreServiceImpl extends AbstractCommonService<StoreEntity, StoreDto> implements StoreService {

    private final StoreMapper StoreMapper;

    private final StoreRepository StoreRepository;

    @Override
    public CommonMapper<StoreEntity, StoreDto> getMapper() {
        return StoreMapper;
    }

    @Override
    public CommonRepository<StoreEntity> getRepository() {
        return StoreRepository;
    }
}

