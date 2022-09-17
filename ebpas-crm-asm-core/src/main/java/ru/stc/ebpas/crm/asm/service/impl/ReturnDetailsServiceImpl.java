package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.ReturnDetailsModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ReturnDetailsDto;
import ru.stc.ebpas.crm.asm.model.entity.ReturnDetailsEntity;
import ru.stc.ebpas.crm.asm.repository.ReturnDetailsRepository;
import ru.stc.ebpas.crm.asm.service.api.ReturnDetailsService;

@AllArgsConstructor
@Service
public class ReturnDetailsServiceImpl
        extends AbstractSimpleModelDefaultService<ReturnDetailsEntity, ReturnDetailsDto>
        implements ReturnDetailsService {

    private final ReturnDetailsModelMapper returnDetailsModelMapper;

    private final ReturnDetailsRepository returnDetailsRepository;

    @Override
    public SimpleModelMapper<ReturnDetailsEntity, ReturnDetailsDto> getMapper() {
        return returnDetailsModelMapper;
    }

    @Override
    public SimpleModelRepository<ReturnDetailsEntity> getRepository() {
        return returnDetailsRepository;
    }
}

