package ru.stc.ebpas.crm.cm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.cm.repository.UserInfoRepository;
import ru.stc.ebpas.crm.cm.mapper.api.UserInfoModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.UserInfoDto;
import ru.stc.ebpas.crm.cm.model.entity.UserInfoEntity;
import ru.stc.ebpas.crm.cm.service.api.UserInfoService;

@AllArgsConstructor
@Service
public class UserInfoServiceImpl
        extends AbstractSimpleModelDefaultService<UserInfoEntity, UserInfoDto>
        implements UserInfoService {

    private final UserInfoModelMapper userInfoModelMapper;

    private final UserInfoRepository userInfoRepository;

    @Override
    public SimpleModelMapper<UserInfoEntity, UserInfoDto> getMapper() {
        return userInfoModelMapper;
    }

    @Override
    public SimpleModelRepository<UserInfoEntity> getRepository() {
        return userInfoRepository;
    }
}

