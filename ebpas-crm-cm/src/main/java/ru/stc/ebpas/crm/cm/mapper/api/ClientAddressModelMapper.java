package ru.stc.ebpas.crm.cm.mapper.api;

import org.mapstruct.Mapper;
import ru.stc.ebpas.common.data.core.mapper.SimpleModelMapper;
import ru.stc.ebpas.crm.cm.model.dto.ClientAddressDto;
import ru.stc.ebpas.crm.cm.model.entity.ClientAddressEntity;

@Mapper(componentModel = "spring",
        config = ConfigModelMapper.class,
        uses = {ClientModelMapper.class})
public interface ClientAddressModelMapper extends SimpleModelMapper<ClientAddressEntity, ClientAddressDto> {

}
