package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.ProductFeedbackMapper;
import ru.stc.ebpas.crm.asm.model.dto.ProductFeedbackDto;
import ru.stc.ebpas.crm.asm.model.entity.ProductFeedbackEntity;
import ru.stc.ebpas.crm.asm.repository.ProductFeedbackRepository;
import ru.stc.ebpas.crm.asm.service.api.ProductFeedbackService;

@AllArgsConstructor
@Service
public class ProductFeedbackServiceImpl extends AbstractCommonService<ProductFeedbackEntity, ProductFeedbackDto> implements ProductFeedbackService {

    private final ProductFeedbackMapper ProductFeedbackMapper;

    private final ProductFeedbackRepository ProductFeedbackRepository;

    @Override
    public CommonMapper<ProductFeedbackEntity, ProductFeedbackDto> getMapper() {
        return ProductFeedbackMapper;
    }

    @Override
    public CommonRepository<ProductFeedbackEntity> getRepository() {
        return ProductFeedbackRepository;
    }
}

