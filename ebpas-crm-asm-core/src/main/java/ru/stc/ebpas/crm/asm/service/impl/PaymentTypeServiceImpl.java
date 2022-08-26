package ru.stc.ebpas.crm.asm.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.mapper.CommonMapper;
import ru.stc.ebpas.common.data.core.repository.CommonRepository;
import ru.stc.ebpas.common.data.core.service.AbstractCommonService;
import ru.stc.ebpas.crm.asm.mapper.api.PaymentTypeMapper;
import ru.stc.ebpas.crm.asm.model.dto.PaymentTypeDto;
import ru.stc.ebpas.crm.asm.model.entity.PaymentType;
import ru.stc.ebpas.crm.asm.repository.PaymentTypeRepository;
import ru.stc.ebpas.crm.asm.service.api.PaymentTypeService;

@AllArgsConstructor
@Service
public class PaymentTypeServiceImpl extends AbstractCommonService<PaymentType, PaymentTypeDto> implements PaymentTypeService {

    private final PaymentTypeMapper PaymentTypeMapper;

    private final PaymentTypeRepository PaymentTypeRepository;

    @Override
    public CommonMapper<PaymentType, PaymentTypeDto> getMapper() {
        return PaymentTypeMapper;
    }

    @Override
    public CommonRepository<PaymentType> getRepository() {
        return PaymentTypeRepository;
    }
}

