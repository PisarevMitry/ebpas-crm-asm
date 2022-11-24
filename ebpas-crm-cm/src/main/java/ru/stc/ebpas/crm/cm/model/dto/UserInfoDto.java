package ru.stc.ebpas.crm.cm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

@Data
@Schema(description = "Сведения о пользователе")
public class UserInfoDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String firstName;

    private String middleName;

    private String secondName;

    private String phoneNumber;

    private String mail;

    private CoreUserDto coreUser;
}
