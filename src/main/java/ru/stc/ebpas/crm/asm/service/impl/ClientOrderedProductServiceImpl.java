package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientOrderedProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.asm.repository.ClientOrderedProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientOrderedProductService;

@AllArgsConstructor
@Service
public class ClientOrderedProductServiceImpl extends AbstractCommonService<ClientOrderedProductEntity, ClientOrderedProductDto>
        implements ClientOrderedProductService {

    private final ClientOrderedProductMapper ClientOrderedProductMapper;

    private final ClientOrderedProductRepository ClientOrderedProductRepository;

    @Override
    public CommonMapper<ClientOrderedProductEntity, ClientOrderedProductDto> getMapper() {
        return ClientOrderedProductMapper;
    }

    @Override
    public CommonRepository<ClientOrderedProductEntity> getRepository() {
        return ClientOrderedProductRepository;
    }
}

