package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.DefectiveProductPhotoModelMapper;
import ru.stc.ebpas.crm.core.model.dto.DefectiveProductPhotoDto;
import ru.stc.ebpas.crm.core.model.entity.DefectiveProductPhotoEntity;
import ru.stc.ebpas.crm.core.repository.DefectiveProductPhotoRepository;
import ru.stc.ebpas.crm.core.service.api.DefectiveProductPhotoService;

@AllArgsConstructor
@Service
public class DefectiveProductPhotoServiceImpl
        extends AbstractSimpleModelDefaultService<DefectiveProductPhotoEntity, DefectiveProductPhotoDto>
        implements DefectiveProductPhotoService {

    private final DefectiveProductPhotoModelMapper defectiveProductPhotoModelMapper;

    private final DefectiveProductPhotoRepository defectiveProductPhotoRepository;

    @Override
    public SimpleModelMapper<DefectiveProductPhotoEntity, DefectiveProductPhotoDto> getMapper() {
        return defectiveProductPhotoModelMapper;
    }

    @Override
    public SimpleModelRepository<DefectiveProductPhotoEntity> getRepository() {
        return defectiveProductPhotoRepository;
    }
}

