package ru.stc.ebpas.crm.core.service.api;

import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.core.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductKey;

@Service
public interface ClientShoppedProductService extends ComplexModelDefaultService<ClientShoppedProductDto, ClientShoppedProductKey> {

}
