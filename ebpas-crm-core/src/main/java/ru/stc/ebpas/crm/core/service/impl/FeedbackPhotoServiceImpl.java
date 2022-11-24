package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.FeedbackPhotoModelMapper;
import ru.stc.ebpas.crm.core.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.core.model.entity.FeedbackPhotoEntity;
import ru.stc.ebpas.crm.core.repository.FeedbackPhotoRepository;
import ru.stc.ebpas.crm.core.service.api.FeedbackPhotoService;

@AllArgsConstructor
@Service
public class FeedbackPhotoServiceImpl
        extends AbstractSimpleModelDefaultService<FeedbackPhotoEntity, FeedbackPhotoDto>
        implements FeedbackPhotoService {

    private final FeedbackPhotoModelMapper feedbackPhotoModelMapper;

    private final FeedbackPhotoRepository feedbackPhotoRepository;

    @Override
    public SimpleModelMapper<FeedbackPhotoEntity, FeedbackPhotoDto> getMapper() {
        return feedbackPhotoModelMapper;
    }

    @Override
    public SimpleModelRepository<FeedbackPhotoEntity> getRepository() {
        return feedbackPhotoRepository;
    }
}

