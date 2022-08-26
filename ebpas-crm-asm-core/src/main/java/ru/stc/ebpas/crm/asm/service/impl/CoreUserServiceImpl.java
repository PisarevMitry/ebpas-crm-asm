package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreUserEntity;
import ru.stc.ebpas.crm.asm.repository.CoreUserRepository;
import ru.stc.ebpas.crm.asm.service.api.CoreUserService;

@AllArgsConstructor
@Service
public class CoreUserServiceImpl extends AbstractCommonService<CoreUserEntity, CoreUserDto> implements CoreUserService {

    private final ru.stc.ebpas.crm.asm.mapper.api.CoreUserMapper CoreUserMapper;

    private final CoreUserRepository CoreUserRepository;

    @Override
    public CommonMapper<CoreUserEntity, CoreUserDto> getMapper() {
        return CoreUserMapper;
    }

    @Override
    public CommonRepository<CoreUserEntity> getRepository() {
        return CoreUserRepository;
    }
}

