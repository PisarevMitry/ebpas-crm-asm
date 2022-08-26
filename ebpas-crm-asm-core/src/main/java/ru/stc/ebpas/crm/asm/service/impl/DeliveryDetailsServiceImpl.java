package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.DeliveryDetailsMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.DeliveryDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.DeliveryDetailsService;

@AllArgsConstructor
@Service
public class DeliveryDetailsServiceImpl extends AbstractCommonService<DeliveryDetailsEntity, DeliveryDetailsDto> implements DeliveryDetailsService {

    private final DeliveryDetailsMapper DeliveryDetailsMapper;

    private final DeliveryDetailsRepository DeliveryDetailsRepository;

    @Override
    public CommonMapper<DeliveryDetailsEntity, DeliveryDetailsDto> getMapper() {
        return DeliveryDetailsMapper;
    }

    @Override
    public CommonRepository<DeliveryDetailsEntity> getRepository() {
        return DeliveryDetailsRepository;
    }
}

