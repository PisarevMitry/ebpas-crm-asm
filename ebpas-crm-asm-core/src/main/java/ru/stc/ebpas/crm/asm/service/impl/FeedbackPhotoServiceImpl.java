package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.FeedbackPhotoMapper;
import ru.stc.ebpas.crm.asm.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.asm.model.entity.FeedbackPhotoEntity;
import ru.stc.ebpas.crm.asm.repository.FeedbackPhotoRepository;
import ru.stc.ebpas.crm.asm.service.api.FeedbackPhotoService;

@AllArgsConstructor
@Service
public class FeedbackPhotoServiceImpl extends AbstractCommonService<FeedbackPhotoEntity, FeedbackPhotoDto> implements FeedbackPhotoService {

    private final FeedbackPhotoMapper FeedbackPhotoMapper;

    private final FeedbackPhotoRepository FeedbackPhotoRepository;

    @Override
    public CommonMapper<FeedbackPhotoEntity, FeedbackPhotoDto> getMapper() {
        return FeedbackPhotoMapper;
    }

    @Override
    public CommonRepository<FeedbackPhotoEntity> getRepository() {
        return FeedbackPhotoRepository;
    }
}

