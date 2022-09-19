package ru.stc.ebpas.crm.asm.mapper.impl;

import org.springframework.stereotype.Component;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientDeferredProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

@Component
public class ReferenceKeyMapper {

    public ClientShoppedProductKey mapClientShoppedProductKey(CompositeKey id) {
        return new ClientShoppedProductKey(id.getFirstPart(), id.getSecondPart());
    }

    public ClientDeferredProductKey mapClientDeferredProductKey(CompositeKey id) {
        return new ClientDeferredProductKey(id.getFirstPart(), id.getSecondPart());
    }

    public ClientOrderedProductKey mapClientOrderedProductKey(CompositeKey id) {
        return new ClientOrderedProductKey(id.getFirstPart(), id.getSecondPart());
    }
}

