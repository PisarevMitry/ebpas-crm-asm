package ru.stc.ebpas.crm.cm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.ClientDto;
import ru.stc.ebpas.crm.cm.repository.ClientRepository;
import ru.stc.ebpas.crm.cm.mapper.api.ClientModelMapper;
import ru.stc.ebpas.crm.cm.model.entity.ClientEntity;
import ru.stc.ebpas.crm.cm.service.api.ClientService;

@AllArgsConstructor
@Service
public class ClientServiceImpl
        extends AbstractSimpleModelDefaultService<ClientEntity, ClientDto>
        implements ClientService {

    private final ClientModelMapper clientModelMapper;

    private final ClientRepository clientRepository;

    @Override
    public SimpleModelMapper<ClientEntity, ClientDto> getMapper() {
        return clientModelMapper;
    }

    @Override
    public SimpleModelRepository<ClientEntity> getRepository() {
        return clientRepository;
    }
}

