package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.DefectiveProductMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductEntity;
import ru.stc.ebpas.crm.asm.repository.DefectiveProductRepository;
import ru.stc.ebpas.crm.asm.service.api.DefectiveProductService;

@AllArgsConstructor
@Service
public class DefectiveProductServiceImpl extends AbstractCommonService<DefectiveProductEntity, DefectiveProductDto>
        implements DefectiveProductService {

    private final DefectiveProductMapper DefectiveProductMapper;

    private final DefectiveProductRepository DefectiveProductRepository;

    @Override
    public CommonMapper<DefectiveProductEntity, DefectiveProductDto> getMapper() {
        return DefectiveProductMapper;
    }

    @Override
    public CommonRepository<DefectiveProductEntity> getRepository() {
        return DefectiveProductRepository;
    }
}

