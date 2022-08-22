package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.OrganizationInfoMapper;
import ru.stc.ebpas.crm.asm.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.asm.model.entity.OrganizationInfoEntity;
import ru.stc.ebpas.crm.asm.repository.OrganizationInfoRepository;
import ru.stc.ebpas.crm.asm.service.api.OrganizationInfoService;

@AllArgsConstructor
@Service
public class OrganizationInfoServiceImpl extends AbstractCommonService<OrganizationInfoEntity, OrganizationInfoDto>
        implements OrganizationInfoService {

    private final OrganizationInfoMapper OrganizationInfoMapper;

    private final OrganizationInfoRepository OrganizationInfoRepository;

    @Override
    public CommonMapper<OrganizationInfoEntity, OrganizationInfoDto> getMapper() {
        return OrganizationInfoMapper;
    }

    @Override
    public CommonRepository<OrganizationInfoEntity> getRepository() {
        return OrganizationInfoRepository;
    }
}

