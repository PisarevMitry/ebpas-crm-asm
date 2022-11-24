package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.CoreOrderModelMapper;
import ru.stc.ebpas.crm.core.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.core.model.entity.CoreOrderEntity;
import ru.stc.ebpas.crm.core.repository.CoreOrderRepository;
import ru.stc.ebpas.crm.core.service.api.CoreOrderService;

@AllArgsConstructor
@Service
public class CoreOrderServiceImpl
        extends AbstractSimpleModelDefaultService<CoreOrderEntity, CoreOrderDto>
        implements CoreOrderService {

    private final CoreOrderModelMapper coreOrderModelMapper;

    private final CoreOrderRepository coreOrderRepository;

    @Override
    public SimpleModelMapper<CoreOrderEntity, CoreOrderDto> getMapper() {
        return coreOrderModelMapper;
    }

    @Override
    public SimpleModelRepository<CoreOrderEntity> getRepository() {
        return coreOrderRepository;
    }
}

