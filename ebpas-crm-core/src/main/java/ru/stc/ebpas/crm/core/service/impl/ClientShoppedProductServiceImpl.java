package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractComplexModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.ClientShoppedProductModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductKey;
import ru.stc.ebpas.crm.core.repository.ClientShoppedProductRepository;
import ru.stc.ebpas.crm.core.service.api.ClientShoppedProductService;

@AllArgsConstructor
@Service
public class ClientShoppedProductServiceImpl
        extends AbstractComplexModelDefaultService<ClientShoppedProductEntity, ClientShoppedProductDto, ClientShoppedProductKey>
        implements ClientShoppedProductService {

    private final ClientShoppedProductModelMapper clientShoppedProductModelMapper;

    private final ClientShoppedProductRepository clientShoppedProductRepository;

    @Override
    public ComplexModelMapper<ClientShoppedProductEntity, ClientShoppedProductDto, ClientShoppedProductKey> getMapper() {
        return clientShoppedProductModelMapper;
    }

    @Override
    public ComplexModelRepository<ClientShoppedProductEntity, ClientShoppedProductKey> getRepository() {
        return clientShoppedProductRepository;
    }
}

