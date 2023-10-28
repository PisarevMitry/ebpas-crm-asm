package ru.stc.ebpas.crm.pm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.pm.mapper.api.ProductFeedbackModelMapper;
import ru.stc.ebpas.crm.pm.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.pm.model.entity.FeedbackEntity;
import ru.stc.ebpas.crm.pm.repository.ProductFeedbackRepository;
import ru.stc.ebpas.crm.pm.service.api.ProductFeedbackService;

@AllArgsConstructor
@Service
public class ProductFeedbackServiceImpl
        extends AbstractSimpleModelDefaultService<FeedbackEntity, ProductFeedbackDto>
        implements ProductFeedbackService {

    private final ProductFeedbackModelMapper productFeedbackModelMapper;

    private final ProductFeedbackRepository productFeedbackRepository;

    @Override
    public SimpleModelMapper<FeedbackEntity, ProductFeedbackDto> getMapper() {
        return productFeedbackModelMapper;
    }

    @Override
    public SimpleModelRepository<FeedbackEntity> getRepository() {
        return productFeedbackRepository;
    }
}

