package ru.stc.ebpas.crm.core.service.api;


import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.ComplexModelDefaultService;
import ru.stc.ebpas.crm.core.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientOrderedProductKey;

@Service
public interface ClientOrderedProductService extends ComplexModelDefaultService<ClientOrderedProductDto, ClientOrderedProductKey> {

}
