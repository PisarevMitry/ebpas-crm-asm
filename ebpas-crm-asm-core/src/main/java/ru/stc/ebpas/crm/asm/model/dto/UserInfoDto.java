package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сведения о пользователе")
public class UserInfoDto implements SimpleDatabaseDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String secondName;

    private String phoneNumber;

    private String mail;

    private Long coreUser;
}
