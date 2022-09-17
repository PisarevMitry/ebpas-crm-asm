package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.common.data.core.repository.SimpleModelRepository;
import ru.stc.ebpas.common.data.core.service.AbstractSimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.mapper.api.PaymentTypeModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentType;
import ru.stc.ebpas.crm.asm.repository.PaymentTypeRepository;
import ru.stc.ebpas.crm.asm.service.api.PaymentTypeService;

@AllArgsConstructor
@Service
public class PaymentTypeServiceImpl
        extends AbstractSimpleModelDefaultService<PaymentType, PaymentTypeDto>
        implements PaymentTypeService {

    private final PaymentTypeModelMapper paymentTypeModelMapper;

    private final PaymentTypeRepository paymentTypeRepository;

    @Override
    public SimpleModelMapper<PaymentType, PaymentTypeDto> getMapper() {
        return paymentTypeModelMapper;
    }

    @Override
    public SimpleModelRepository<PaymentType> getRepository() {
        return paymentTypeRepository;
    }
}

