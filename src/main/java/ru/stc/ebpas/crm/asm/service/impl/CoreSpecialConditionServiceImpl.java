package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreSpecialConditionEntity;
import ru.stc.ebpas.crm.asm.repository.CoreSpecialConditionRepository;
import ru.stc.ebpas.crm.asm.service.api.CoreSpecialConditionService;

@AllArgsConstructor
@Service
public class CoreSpecialConditionServiceImpl extends AbstractCommonService<CoreSpecialConditionEntity, CoreSpecialConditionDto>
        implements CoreSpecialConditionService {

    private final ru.stc.ebpas.crm.asm.mapper.api.CoreSpecialConditionMapper CoreSpecialConditionMapper;

    private final CoreSpecialConditionRepository CoreSpecialConditionRepository;

    @Override
    public CommonMapper<CoreSpecialConditionEntity, CoreSpecialConditionDto> getMapper() {
        return CoreSpecialConditionMapper;
    }

    @Override
    public CommonRepository<CoreSpecialConditionEntity> getRepository() {
        return CoreSpecialConditionRepository;
    }
}

