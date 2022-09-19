package ru.stc.ebpas.crm.asm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.ComplexModelMapper;
import ru.stc.ebpas.crm.asm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductEntity;
import ru.stc.ebpas.crm.asm.model.entity.ClientOrderedProductKey;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {AvailableProductModelMapper.class})
public interface ClientOrderedProductModelMapper
        extends ComplexModelMapper<ClientOrderedProductEntity, ClientOrderedProductDto, ClientOrderedProductKey> {

}
