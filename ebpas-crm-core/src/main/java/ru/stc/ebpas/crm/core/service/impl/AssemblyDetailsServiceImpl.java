package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.AssemblyDetailsModelMapper;
import ru.stc.ebpas.crm.core.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.core.model.entity.AssemblyDetailsEntity;
import ru.stc.ebpas.crm.core.repository.AssemblyDetailsRepository;
import ru.stc.ebpas.crm.core.service.api.AssemblyDetailsService;

@AllArgsConstructor
@Service
public class AssemblyDetailsServiceImpl
        extends AbstractSimpleModelDefaultService<AssemblyDetailsEntity, AssemblyDetailsDto>
        implements AssemblyDetailsService {

    private final AssemblyDetailsModelMapper assemblyDetailsMapper;

    private final AssemblyDetailsRepository assemblyDetailsRepository;

    @Override
    public SimpleModelMapper<AssemblyDetailsEntity, AssemblyDetailsDto> getMapper() {
        return assemblyDetailsMapper;
    }

    @Override
    public SimpleModelRepository<AssemblyDetailsEntity> getRepository() {
        return assemblyDetailsRepository;
    }
}
