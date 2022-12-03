package ru.stc.ebpas.crm.pm.service.api;

import ru.stc.ebpas.common.data.core.service.SimpleModelDefaultService;
import ru.stc.ebpas.crm.pm.model.dto.ProductDto;
import ru.stc.ebpas.crm.pm.model.dto.ProjectProductDto;

public interface ProductService extends SimpleModelDefaultService<ProductDto> {

    ProductDto save(ProjectProductDto dto);
}
