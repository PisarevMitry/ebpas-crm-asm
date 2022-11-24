package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.DeliveryTypeModelMapper;
import ru.stc.ebpas.crm.core.model.dto.DeliveryTypeDto;
import ru.stc.ebpas.crm.core.model.entity.DeliveryType;
import ru.stc.ebpas.crm.core.repository.DeliveryTypeRepository;
import ru.stc.ebpas.crm.core.service.api.DeliveryTypeService;

@AllArgsConstructor
@Service
public class DeliveryTypeServiceImpl
        extends AbstractSimpleModelDefaultService<DeliveryType, DeliveryTypeDto>
        implements DeliveryTypeService {

    private final DeliveryTypeModelMapper deliveryTypeModelMapper;

    private final DeliveryTypeRepository deliveryTypeRepository;

    @Override
    public SimpleModelMapper<DeliveryType, DeliveryTypeDto> getMapper() {
        return deliveryTypeModelMapper;
    }

    @Override
    public SimpleModelRepository<DeliveryType> getRepository() {
        return deliveryTypeRepository;
    }
}

