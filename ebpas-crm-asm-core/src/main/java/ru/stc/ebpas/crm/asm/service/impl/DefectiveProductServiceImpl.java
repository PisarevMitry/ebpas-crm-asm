package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.DefectiveProductModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductEntity;
import ru.stc.ebpas.crm.asm.repository.DefectiveProductRepository;
import ru.stc.ebpas.crm.asm.service.api.DefectiveProductService;

@AllArgsConstructor
@Service
public class DefectiveProductServiceImpl
        extends AbstractSimpleModelDefaultService<DefectiveProductEntity, DefectiveProductDto>
        implements DefectiveProductService {

    private final DefectiveProductModelMapper defectiveProductModelMapper;

    private final DefectiveProductRepository defectiveProductRepository;

    @Override
    public SimpleModelMapper<DefectiveProductEntity, DefectiveProductDto> getMapper() {
        return defectiveProductModelMapper;
    }

    @Override
    public SimpleModelRepository<DefectiveProductEntity> getRepository() {
        return defectiveProductRepository;
    }
}

