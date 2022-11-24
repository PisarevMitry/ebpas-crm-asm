package ru.stc.ebpas.crm.cm.service.api;

import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientShoppedProductKey;

@Service
public interface ClientShoppedProductService extends ComplexModelDefaultService<ClientShoppedProductDto, ClientShoppedProductKey> {

}
