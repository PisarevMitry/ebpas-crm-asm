package ru.stc.ebpas.crm.cm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.cm.repository.OrganizationInfoRepository;
import ru.stc.ebpas.crm.cm.mapper.api.OrganizationInfoModelMapper;
import ru.stc.ebpas.crm.cm.model.entity.OrganizationInfoEntity;
import ru.stc.ebpas.crm.cm.service.api.OrganizationInfoService;

@AllArgsConstructor
@Service
public class OrganizationInfoServiceImpl
        extends AbstractSimpleModelDefaultService<OrganizationInfoEntity, OrganizationInfoDto>
        implements OrganizationInfoService {

    private final OrganizationInfoModelMapper organizationInfoModelMapper;

    private final OrganizationInfoRepository organizationInfoRepository;

    @Override
    public SimpleModelMapper<OrganizationInfoEntity, OrganizationInfoDto> getMapper() {
        return organizationInfoModelMapper;
    }

    @Override
    public SimpleModelRepository<OrganizationInfoEntity> getRepository() {
        return organizationInfoRepository;
    }
}

