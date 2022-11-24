package ru.stc.ebpas.crm.cm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractComplexModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.cm.repository.ClientDeferredProductRepository;
import ru.stc.ebpas.crm.cm.mapper.api.ClientDeferredProductModelMapper;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.cm.service.api.ClientDeferredProductService;

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

