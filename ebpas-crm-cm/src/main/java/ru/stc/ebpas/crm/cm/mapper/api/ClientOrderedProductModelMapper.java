package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientOrderedProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class)
public interface ClientOrderedProductModelMapper
        extends ComplexModelMapper<ClientOrderedProductEntity, ClientOrderedProductDto, ClientOrderedProductKey> {

}
