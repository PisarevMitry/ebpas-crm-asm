package ru.stc.ebpas.crm.core.service.api;


import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.core.model.dto.ClientDeferredProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientDeferredProductKey;

@Service
public interface ClientDeferredProductService extends ComplexModelDefaultService<ClientDeferredProductDto, ClientDeferredProductKey> {

}
