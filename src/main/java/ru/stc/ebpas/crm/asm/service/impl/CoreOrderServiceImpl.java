package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.CoreOrderMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreOrderEntity;
import ru.stc.ebpas.crm.asm.repository.CoreOrderRepository;
import ru.stc.ebpas.crm.asm.service.api.CoreOrderService;

@AllArgsConstructor
@Service
public class CoreOrderServiceImpl extends AbstractCommonService<CoreOrderEntity, CoreOrderDto> implements CoreOrderService {

    private final CoreOrderMapper CoreOrderMapper;

    private final CoreOrderRepository CoreOrderRepository;

    @Override
    public CommonMapper<CoreOrderEntity, CoreOrderDto> getMapper() {
        return CoreOrderMapper;
    }

    @Override
    public CommonRepository<CoreOrderEntity> getRepository() {
        return CoreOrderRepository;
    }
}

