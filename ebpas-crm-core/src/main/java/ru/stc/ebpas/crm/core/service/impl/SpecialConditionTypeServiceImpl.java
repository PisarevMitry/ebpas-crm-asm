package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.SpecialConditionTypeModelMapper;
import ru.stc.ebpas.crm.core.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.core.model.entity.SpecialConditionType;
import ru.stc.ebpas.crm.core.repository.SpecialConditionTypeRepository;
import ru.stc.ebpas.crm.core.service.api.SpecialConditionTypeService;

@AllArgsConstructor
@Service
public class SpecialConditionTypeServiceImpl
        extends AbstractSimpleModelDefaultService<SpecialConditionType, SpecialConditionTypeDto>
        implements SpecialConditionTypeService {

    private final SpecialConditionTypeModelMapper specialConditionTypeModelMapper;

    private final SpecialConditionTypeRepository specialConditionTypeRepository;

    @Override
    public SimpleModelMapper<SpecialConditionType, SpecialConditionTypeDto> getMapper() {
        return specialConditionTypeModelMapper;
    }

    @Override
    public SimpleModelRepository<SpecialConditionType> getRepository() {
        return specialConditionTypeRepository;
    }
}

