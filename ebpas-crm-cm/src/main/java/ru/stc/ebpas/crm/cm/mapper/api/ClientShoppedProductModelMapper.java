package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientShoppedProductDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientShoppedProductEntity;
import ru.stc.ebpas.crm.cm.model.entity.ClientShoppedProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class})
public interface ClientShoppedProductModelMapper
        extends ComplexModelMapper<ClientShoppedProductEntity, ClientShoppedProductDto, ClientShoppedProductKey> {
}
