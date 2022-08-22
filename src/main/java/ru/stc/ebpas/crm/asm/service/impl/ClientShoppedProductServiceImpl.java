package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientShoppedProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.asm.repository.ClientShoppedProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientShoppedProductService;

@AllArgsConstructor
@Service
public class ClientShoppedProductServiceImpl extends AbstractCommonService<ClientShoppedProductEntity, ClientShoppedProductDto>
        implements ClientShoppedProductService {

    private final ClientShoppedProductMapper ClientShoppedProductMapper;

    private final ClientShoppedProductRepository ClientShoppedProductRepository;

    @Override
    public CommonMapper<ClientShoppedProductEntity, ClientShoppedProductDto> getMapper() {
        return ClientShoppedProductMapper;
    }

    @Override
    public CommonRepository<ClientShoppedProductEntity> getRepository() {
        return ClientShoppedProductRepository;
    }
}

