package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.CoreSpecialConditionModelMapper;
import ru.stc.ebpas.crm.core.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.core.model.entity.CoreSpecialConditionEntity;
import ru.stc.ebpas.crm.core.repository.CoreSpecialConditionRepository;
import ru.stc.ebpas.crm.core.service.api.CoreSpecialConditionService;

@AllArgsConstructor
@Service
public class CoreSpecialConditionServiceImpl
        extends AbstractSimpleModelDefaultService<CoreSpecialConditionEntity, CoreSpecialConditionDto>
        implements CoreSpecialConditionService {

    private final CoreSpecialConditionModelMapper coreSpecialConditionModelMapper;

    private final CoreSpecialConditionRepository coreSpecialConditionRepository;

    @Override
    public SimpleModelMapper<CoreSpecialConditionEntity, CoreSpecialConditionDto> getMapper() {
        return coreSpecialConditionModelMapper;
    }

    @Override
    public SimpleModelRepository<CoreSpecialConditionEntity> getRepository() {
        return coreSpecialConditionRepository;
    }
}

