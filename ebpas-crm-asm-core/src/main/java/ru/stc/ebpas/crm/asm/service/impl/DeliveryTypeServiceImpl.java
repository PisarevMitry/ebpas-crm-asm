package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.DeliveryTypeMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryType;
import ru.stc.ebpas.crm.asm.repository.DeliveryTypeRepository;
import ru.stc.ebpas.crm.asm.service.api.DeliveryTypeService;

@AllArgsConstructor
@Service
public class DeliveryTypeServiceImpl extends AbstractCommonService<DeliveryType, DeliveryTypeDto> implements DeliveryTypeService {

    private final DeliveryTypeMapper DeliveryTypeMapper;

    private final DeliveryTypeRepository DeliveryTypeRepository;

    @Override
    public CommonMapper<DeliveryType, DeliveryTypeDto> getMapper() {
        return DeliveryTypeMapper;
    }

    @Override
    public CommonRepository<DeliveryType> getRepository() {
        return DeliveryTypeRepository;
    }
}

