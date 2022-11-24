package ru.stc.ebpas.crm.core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.core.mapper.api.ProductFeedbackModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.core.model.entity.ProductFeedbackEntity;
import ru.stc.ebpas.crm.core.repository.ProductFeedbackRepository;
import ru.stc.ebpas.crm.core.service.api.ProductFeedbackService;

@AllArgsConstructor
@Service
public class ProductFeedbackServiceImpl
        extends AbstractSimpleModelDefaultService<ProductFeedbackEntity, ProductFeedbackDto>
        implements ProductFeedbackService {

    private final ProductFeedbackModelMapper productFeedbackModelMapper;

    private final ProductFeedbackRepository productFeedbackRepository;

    @Override
    public SimpleModelMapper<ProductFeedbackEntity, ProductFeedbackDto> getMapper() {
        return productFeedbackModelMapper;
    }

    @Override
    public SimpleModelRepository<ProductFeedbackEntity> getRepository() {
        return productFeedbackRepository;
    }
}

