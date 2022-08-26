package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.SpecialConditionTypeMapper;
import ru.stc.ebpas.crm.asm.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.SpecialConditionType;
import ru.stc.ebpas.crm.asm.repository.SpecialConditionTypeRepository;
import ru.stc.ebpas.crm.asm.service.api.SpecialConditionTypeService;

@AllArgsConstructor
@Service
public class SpecialConditionTypeServiceImpl extends AbstractCommonService<SpecialConditionType, SpecialConditionTypeDto>
        implements SpecialConditionTypeService {

    private final SpecialConditionTypeMapper SpecialConditionTypeMapper;

    private final SpecialConditionTypeRepository SpecialConditionTypeRepository;

    @Override
    public CommonMapper<SpecialConditionType, SpecialConditionTypeDto> getMapper() {
        return SpecialConditionTypeMapper;
    }

    @Override
    public CommonRepository<SpecialConditionType> getRepository() {
        return SpecialConditionTypeRepository;
    }
}

