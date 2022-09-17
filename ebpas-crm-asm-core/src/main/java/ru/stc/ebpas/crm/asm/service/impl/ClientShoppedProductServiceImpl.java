package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractComplexModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientShoppedProductModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;
import ru.stc.ebpas.crm.asm.repository.ClientShoppedProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientShoppedProductService;

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

