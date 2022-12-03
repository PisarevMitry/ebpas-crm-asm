package ru.stc.ebpas.crm.pm.service.api;

import ru.stc.ebpas.common.data.core.service.SimpleModelDefaultService;
import ru.stc.ebpas.crm.pm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ChangeProductQuantityRequestDto;

public interface AvailableProductService extends SimpleModelDefaultService<AvailableProductDto> {

    void changeProductQuantity(ChangeProductQuantityRequestDto changeProductQuantityRequest);
}
