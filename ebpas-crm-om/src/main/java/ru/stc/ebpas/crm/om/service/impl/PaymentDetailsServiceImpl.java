package ru.stc.ebpas.crm.om.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.om.mapper.api.PaymentDetailsModelMapper;
import ru.stc.ebpas.crm.om.model.dto.PaymentDetailsDto;
import ru.stc.ebpas.crm.om.model.entity.PaymentDetailsEntity;
import ru.stc.ebpas.crm.om.repository.PaymentDetailsRepository;
import ru.stc.ebpas.crm.om.service.api.PaymentDetailsService;

@AllArgsConstructor
@Service
public class PaymentDetailsServiceImpl
        extends AbstractSimpleModelDefaultService<PaymentDetailsEntity, PaymentDetailsDto>
        implements PaymentDetailsService {

    private final PaymentDetailsModelMapper paymentDetailsModelMapper;

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public SimpleModelMapper<PaymentDetailsEntity, PaymentDetailsDto> getMapper() {
        return paymentDetailsModelMapper;
    }

    @Override
    public SimpleModelRepository<PaymentDetailsEntity> getRepository() {
        return paymentDetailsRepository;
    }
}

