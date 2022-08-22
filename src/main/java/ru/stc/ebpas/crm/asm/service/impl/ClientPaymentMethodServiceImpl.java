package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientPaymentMethodMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientPaymentMethodDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientPaymentMethodEntity;
import ru.stc.ebpas.crm.asm.repository.ClientPaymentMethodRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientPaymentMethodService;

@AllArgsConstructor
@Service
public class ClientPaymentMethodServiceImpl extends AbstractCommonService<ClientPaymentMethodEntity, ClientPaymentMethodDto>
        implements ClientPaymentMethodService {

    private final ClientPaymentMethodMapper ClientPaymentMethodMapper;

    private final ClientPaymentMethodRepository ClientPaymentMethodRepository;

    @Override
    public CommonMapper<ClientPaymentMethodEntity, ClientPaymentMethodDto> getMapper() {
        return ClientPaymentMethodMapper;
    }

    @Override
    public CommonRepository<ClientPaymentMethodEntity> getRepository() {
        return ClientPaymentMethodRepository;
    }
}

