package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.AvailableProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.asm.model.entity.AvailableProductEntity;
import ru.stc.ebpas.crm.asm.repository.AvailableProductRepository;
import ru.stc.ebpas.crm.asm.service.api.AvailableProductService;

@AllArgsConstructor
@Service
public class AvailableProductServiceImpl extends AbstractCommonService<AvailableProductEntity, AvailableProductDto>
        implements AvailableProductService {

    private final AvailableProductMapper AvailableProductMapper;

    private final AvailableProductRepository AvailableProductRepository;

    @Override
    public CommonMapper<AvailableProductEntity, AvailableProductDto> getMapper() {
        return AvailableProductMapper;
    }

    @Override
    public CommonRepository<AvailableProductEntity> getRepository() {
        return AvailableProductRepository;
    }
}

