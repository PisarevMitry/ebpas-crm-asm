package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.UserInfoMapper;
import ru.stc.ebpas.crm.asm.model.dto.UserInfoDto;
import ru.stc.ebpas.crm.asm.model.entity.UserInfoEntity;
import ru.stc.ebpas.crm.asm.repository.UserInfoRepository;
import ru.stc.ebpas.crm.asm.service.api.UserInfoService;

@AllArgsConstructor
@Service
public class UserInfoServiceImpl extends AbstractCommonService<UserInfoEntity, UserInfoDto> implements UserInfoService {

    private final UserInfoMapper UserInfoMapper;

    private final UserInfoRepository UserInfoRepository;

    @Override
    public CommonMapper<UserInfoEntity, UserInfoDto> getMapper() {
        return UserInfoMapper;
    }

    @Override
    public CommonRepository<UserInfoEntity> getRepository() {
        return UserInfoRepository;
    }
}

