package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractComplexModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.ClientDeferredProductModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.core.repository.ClientDeferredProductRepository;
import ru.stc.ebpas.crm.core.service.api.ClientDeferredProductService;

@AllArgsConstructor
@Service
public class ClientDeferredProductServiceImpl
        extends AbstractComplexModelDefaultService<ClientDeferredProductEntity, ClientDeferredProductDto, ClientDeferredProductKey>
        implements ClientDeferredProductService {

    private final ClientDeferredProductModelMapper clientDeferredProductModelMapper;

    private final ClientDeferredProductRepository clientDeferredProductRepository;

    @Override
    public ComplexModelMapper getMapper() {
        return clientDeferredProductModelMapper;
    }

    @Override
    public ComplexModelRepository getRepository() {
        return clientDeferredProductRepository;
    }
}

