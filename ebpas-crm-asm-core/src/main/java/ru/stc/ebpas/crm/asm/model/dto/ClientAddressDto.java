package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.AddressDto;

@Schema(description = "Адрес, сохраненный пользователем")
@Data
public class ClientAddressDto extends AddressDto {

    private Long id;

    private ClientDto client;
}
