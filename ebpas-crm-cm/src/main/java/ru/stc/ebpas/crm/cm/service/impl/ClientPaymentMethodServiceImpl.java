package ru.stc.ebpas.crm.cm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.cm.repository.ClientPaymentMethodRepository;
import ru.stc.ebpas.crm.cm.mapper.api.ClientPaymentMethodModelMapper;
import ru.stc.ebpas.crm.cm.model.entity.ClientPaymentMethodEntity;
import ru.stc.ebpas.crm.cm.service.api.ClientPaymentMethodService;

@AllArgsConstructor
@Service
public class ClientPaymentMethodServiceImpl
        extends AbstractSimpleModelDefaultService<ClientPaymentMethodEntity, ClientPaymentMethodDto>
        implements ClientPaymentMethodService {

    private final ClientPaymentMethodModelMapper clientPaymentMethodModelMapper;

    private final ClientPaymentMethodRepository clientPaymentMethodRepository;

    @Override
    public SimpleModelMapper<ClientPaymentMethodEntity, ClientPaymentMethodDto> getMapper() {
        return clientPaymentMethodModelMapper;
    }

    @Override
    public SimpleModelRepository<ClientPaymentMethodEntity> getRepository() {
        return clientPaymentMethodRepository;
    }
}

