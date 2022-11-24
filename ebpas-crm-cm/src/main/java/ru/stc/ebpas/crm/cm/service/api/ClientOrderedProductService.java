package ru.stc.ebpas.crm.cm.service.api;


import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.cm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientOrderedProductKey;

@Service
public interface ClientOrderedProductService extends ComplexModelDefaultService<ClientOrderedProductDto, ClientOrderedProductKey> {

}
