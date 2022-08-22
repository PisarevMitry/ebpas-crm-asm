package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientEntity;
import ru.stc.ebpas.crm.asm.repository.ClientRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientService;

@AllArgsConstructor
@Service
public class ClientServiceImpl extends AbstractCommonService<ClientEntity, ClientDto> implements ClientService {

    private final ClientMapper ClientMapper;

    private final ClientRepository ClientRepository;

    @Override
    public CommonMapper<ClientEntity, ClientDto> getMapper() {
        return ClientMapper;
    }

    @Override
    public CommonRepository<ClientEntity> getRepository() {
        return ClientRepository;
    }
}

