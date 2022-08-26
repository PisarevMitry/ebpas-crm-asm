package ru.stc.ebpas.crm.asm.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.stc.ebpas.crm.asm.model.constant.MediaDto;

@Schema(description = "Фото для отзыва")
@Data
public class FeedbackPhotoDto extends MediaDto {

    private Long id;

    private ProductFeedbackDto productFeedback;

}
