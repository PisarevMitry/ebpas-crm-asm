package ru.stc.ebpas.crm.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.common.core.model.dto.SimpleDatabaseDto;

import java.util.Set;

@Data
@Schema(description = "Отзыв пользователя о товаре")
public class ProductFeedbackDto implements SimpleDatabaseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private ProductDto product;

    private ClientDto client;

    private Short grade;

    private String description;

    private Set<FeedbackPhotoDto> photos;
}
