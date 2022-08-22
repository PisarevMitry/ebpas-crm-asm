package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.DefectiveProductPhotoMapper;
import ru.stc.ebpas.crm.asm.model.dto.DefectiveProductPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.DefectiveProductPhotoEntity;
import ru.stc.ebpas.crm.asm.repository.DefectiveProductPhotoRepository;
import ru.stc.ebpas.crm.asm.service.api.DefectiveProductPhotoService;

@AllArgsConstructor
@Service
public class DefectiveProductPhotoServiceImpl extends AbstractCommonService<DefectiveProductPhotoEntity, DefectiveProductPhotoDto> implements
        DefectiveProductPhotoService {

    private final DefectiveProductPhotoMapper DefectiveProductPhotoMapper;

    private final DefectiveProductPhotoRepository DefectiveProductPhotoRepository;

    @Override
    public CommonMapper<DefectiveProductPhotoEntity, DefectiveProductPhotoDto> getMapper() {
        return DefectiveProductPhotoMapper;
    }

    @Override
    public CommonRepository<DefectiveProductPhotoEntity> getRepository() {
        return DefectiveProductPhotoRepository;
    }
}

