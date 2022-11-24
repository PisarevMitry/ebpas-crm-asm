package ru.stc.ebpas.crm.core.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.core.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.core.model.entity.ClientAddressEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class})
public interface ClientAddressModelMapper extends SimpleModelMapper<ClientAddressEntity, ClientAddressDto> {

}
