package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ReturnDetailsMapper;
import ru.stc.ebpas.crm.asm.model.dto.ReturnDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.ReturnDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.ReturnDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.ReturnDetailsService;

@AllArgsConstructor
@Service
public class ReturnDetailsServiceImpl extends AbstractCommonService<ReturnDetailsEntity, ReturnDetailsDto> implements ReturnDetailsService {

    private final ReturnDetailsMapper ReturnDetailsMapper;

    private final ReturnDetailsRepository ReturnDetailsRepository;

    @Override
    public CommonMapper<ReturnDetailsEntity, ReturnDetailsDto> getMapper() {
        return ReturnDetailsMapper;
    }

    @Override
    public CommonRepository<ReturnDetailsEntity> getRepository() {
        return ReturnDetailsRepository;
    }
}

