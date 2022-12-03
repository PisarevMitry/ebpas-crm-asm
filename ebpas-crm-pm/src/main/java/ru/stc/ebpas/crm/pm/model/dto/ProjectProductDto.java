package ru.stc.ebpas.crm.pm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Проект товара")
public class ProjectProductDto {

    private String nomenclature;
}
