package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ClientAddressMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientAddressEntity;
import ru.stc.ebpas.crm.asm.repository.ClientAddressRepository;
import ru.stc.ebpas.crm.asm.service.api.ClientAddressService;

@AllArgsConstructor
@Service
public class ClientAddressServiceImpl extends AbstractCommonService<ClientAddressEntity, ClientAddressDto> implements ClientAddressService {

    private final ClientAddressMapper ClientAddressMapper;

    private final ClientAddressRepository ClientAddressRepository;

    @Override
    public CommonMapper<ClientAddressEntity, ClientAddressDto> getMapper() {
        return ClientAddressMapper;
    }

    @Override
    public CommonRepository<ClientAddressEntity> getRepository() {
        return ClientAddressRepository;
    }
}

