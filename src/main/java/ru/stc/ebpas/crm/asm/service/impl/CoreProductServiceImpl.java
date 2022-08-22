package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.asm.model.entity.CoreProductEntity;
import ru.stc.ebpas.crm.asm.repository.CoreProductRepository;
import ru.stc.ebpas.crm.asm.service.api.CoreProductService;

@AllArgsConstructor
@Service
public class CoreProductServiceImpl extends AbstractCommonService<CoreProductEntity, CoreProductDto> implements CoreProductService {

    private final ru.stc.ebpas.crm.asm.mapper.api.CoreProductMapper CoreProductMapper;

    private final CoreProductRepository CoreProductRepository;

    @Override
    public CommonMapper<CoreProductEntity, CoreProductDto> getMapper() {
        return CoreProductMapper;
    }

    @Override
    public CommonRepository<CoreProductEntity> getRepository() {
        return CoreProductRepository;
    }
}

