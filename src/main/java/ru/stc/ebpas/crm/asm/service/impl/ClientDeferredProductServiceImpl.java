package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientDeferredProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductEntity;
import ru.stc.ebpas.crm.asm.repository.ClientDeferredProductRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientDeferredProductService;

@AllArgsConstructor
@Service
public class ClientDeferredProductServiceImpl extends AbstractCommonService<ClientDeferredProductEntity, ClientDeferredProductDto>
        implements ClientDeferredProductService {

    private final ClientDeferredProductMapper ClientDeferredProductMapper;

    private final ClientDeferredProductRepository ClientDeferredProductRepository;

    @Override
    public CommonMapper<ClientDeferredProductEntity, ClientDeferredProductDto> getMapper() {
        return ClientDeferredProductMapper;
    }

    @Override
    public CommonRepository<ClientDeferredProductEntity> getRepository() {
        return ClientDeferredProductRepository;
    }
}

