package ru.stc.ebpas.crm.asm.service.api;

import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.asm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientShoppedProductKey;

@Service
public interface ClientShoppedProductService extends ComplexModelDefaultService<ClientShoppedProductDto, ClientShoppedProductKey> {

}
