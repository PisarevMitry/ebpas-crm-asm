package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.CoreUserModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreUserEntity;
import ru.stc.ebpas.crm.asm.repository.CoreUserRepository;
import ru.stc.ebpas.crm.asm.service.api.CoreUserService;

@AllArgsConstructor
@Service
public class CoreUserServiceImpl
        extends AbstractSimpleModelDefaultService<CoreUserEntity, CoreUserDto>
        implements CoreUserService {

    private final CoreUserModelMapper coreUserModelMapper;

    private final CoreUserRepository coreUserRepository;

    @Override
    public SimpleModelMapper<CoreUserEntity, CoreUserDto> getMapper() {
        return coreUserModelMapper;
    }

    @Override
    public SimpleModelRepository<CoreUserEntity> getRepository() {
        return coreUserRepository;
    }
}

