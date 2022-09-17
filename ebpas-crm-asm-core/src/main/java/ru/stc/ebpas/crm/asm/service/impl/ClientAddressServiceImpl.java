package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientAddressModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientAddressEntity;
import ru.stc.ebpas.crm.asm.repository.ClientAddressRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientAddressService;

@AllArgsConstructor
@Service
public class ClientAddressServiceImpl
        extends AbstractSimpleModelDefaultService<ClientAddressEntity, ClientAddressDto>
        implements ClientAddressService {

    private final ClientAddressModelMapper clientAddressModelMapper;

    private final ClientAddressRepository clientAddressRepository;

    @Override
    public SimpleModelMapper<ClientAddressEntity, ClientAddressDto> getMapper() {
        return clientAddressModelMapper;
    }

    @Override
    public SimpleModelRepository<ClientAddressEntity> getRepository() {
        return clientAddressRepository;
    }
}

