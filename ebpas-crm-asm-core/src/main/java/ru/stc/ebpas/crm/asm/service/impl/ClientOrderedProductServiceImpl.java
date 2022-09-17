package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.common.data.core.repository.ComplexModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractComplexModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientOrderedProductModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.asm.repository.ClientOrderedProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientOrderedProductService;

@AllArgsConstructor
@Service
public class ClientOrderedProductServiceImpl
        extends AbstractComplexModelDefaultService<ClientOrderedProductEntity, ClientOrderedProductDto, ClientOrderedProductKey>
        implements ClientOrderedProductService {

    private final ClientOrderedProductModelMapper clientOrderedProductModelMapper;

    private final ClientOrderedProductRepository clientOrderedProductRepository;

    @Override
    public ComplexModelMapper<ClientOrderedProductEntity, ClientOrderedProductDto, ClientOrderedProductKey> getMapper() {
        return clientOrderedProductModelMapper;
    }

    @Override
    public ComplexModelRepository getRepository() {
        return clientOrderedProductRepository;
    }
}

