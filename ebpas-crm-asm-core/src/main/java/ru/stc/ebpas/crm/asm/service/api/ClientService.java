package ru.stc.ebpas.crm.asm.service.api;

import org.springframework.stereotype.Service;
import ru.stc.ebpas.common.data.core.service.SimpleModelDefaultService;
import ru.stc.ebpas.crm.asm.model.dto.ClientDto;

@Service
public interface ClientService extends SimpleModelDefaultService<ClientDto> {

}