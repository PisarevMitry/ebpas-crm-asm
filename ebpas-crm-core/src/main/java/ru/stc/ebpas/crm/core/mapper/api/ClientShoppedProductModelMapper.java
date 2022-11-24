package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.core.model.entity.ClientShoppedProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class,
                AvailableProductModelMapper.class})
public interface ClientShoppedProductModelMapper
        extends ComplexModelMapper<ClientShoppedProductEntity, ClientShoppedProductDto, ClientShoppedProductKey> {
}
