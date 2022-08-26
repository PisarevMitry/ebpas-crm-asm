package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.AssemblyDetailsMapper;
import ru.stc.ebpas.crm.asm.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.AssemblyDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.AssemblyDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.AssemblyDetailsService;

@AllArgsConstructor
@Service
public class AssemblyDetailsServiceImpl extends AbstractCommonService<AssemblyDetailsEntity, AssemblyDetailsDto> implements AssemblyDetailsService {

    private final AssemblyDetailsMapper assemblyDetailsMapper;

    private final AssemblyDetailsRepository assemblyDetailsRepository;

    @Override
    public CommonMapper<AssemblyDetailsEntity, AssemblyDetailsDto> getMapper() {
        return assemblyDetailsMapper;
    }

    @Override
    public CommonRepository<AssemblyDetailsEntity> getRepository() {
        return assemblyDetailsRepository;
    }
}
