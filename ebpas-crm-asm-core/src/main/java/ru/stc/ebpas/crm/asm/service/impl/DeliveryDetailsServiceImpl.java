package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.DeliveryDetailsModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.DeliveryDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.DeliveryDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.DeliveryDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.DeliveryDetailsService;

@AllArgsConstructor
@Service
public class DeliveryDetailsServiceImpl
        extends AbstractSimpleModelDefaultService<DeliveryDetailsEntity, DeliveryDetailsDto>
        implements DeliveryDetailsService {

    private final DeliveryDetailsModelMapper deliveryDetailsModelMapper;

    private final DeliveryDetailsRepository deliveryDetailsRepository;

    @Override
    public SimpleModelMapper<DeliveryDetailsEntity, DeliveryDetailsDto> getMapper() {
        return deliveryDetailsModelMapper;
    }

    @Override
    public SimpleModelRepository<DeliveryDetailsEntity> getRepository() {
        return deliveryDetailsRepository;
    }
}

