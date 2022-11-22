package ru.stc.ebpas.crm.asm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stc.ebpas.crm.asm.model.dto.FeedbackPhotoDto;
import ru.stc.ebpas.crm.asm.service.api.FeedbackPhotoService;

import java.util.List;

@Tag(name = "API сущности 1")
@RequiredArgsConstructor
@RestController
@RequestMapping("/feedback-photo")
public class FeedbackPhotoController {

    private final FeedbackPhotoService feedbackPhotoService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public FeedbackPhotoDto getById(@PathVariable Long id) {
        return feedbackPhotoService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<FeedbackPhotoDto> getById(@RequestBody List<Long> listId) {
        return feedbackPhotoService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<FeedbackPhotoDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return feedbackPhotoService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<FeedbackPhotoDto> getAll() {
        return feedbackPhotoService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<FeedbackPhotoDto> getAll(Pageable pageable) {
        return feedbackPhotoService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public FeedbackPhotoDto update(@RequestBody FeedbackPhotoDto dto) {
        return feedbackPhotoService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<FeedbackPhotoDto> update(@RequestBody List<FeedbackPhotoDto> dto) {
        return feedbackPhotoService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public FeedbackPhotoDto save(@RequestBody FeedbackPhotoDto dto) {
        return feedbackPhotoService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<FeedbackPhotoDto> save(@RequestBody List<FeedbackPhotoDto> dto) {
        return feedbackPhotoService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        feedbackPhotoService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        feedbackPhotoService.delete(id);
    }
}
