package ru.stc.ebpas.crm.om.controller;

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
import ru.stc.ebpas.crm.om.model.dto.DefectiveProductPhotoDto;
import ru.stc.ebpas.crm.om.service.api.DefectiveProductPhotoService;

import java.util.List;

@Tag(name = "API работы с фото бракованных товаров")
@RequiredArgsConstructor
@RestController
@RequestMapping("/defective-product-photo")
public class DefectiveProductPhotoController {

    private final DefectiveProductPhotoService defectiveProductPhotoService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public DefectiveProductPhotoDto getById(@PathVariable Long id) {
        return defectiveProductPhotoService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<DefectiveProductPhotoDto> getById(@RequestBody List<Long> listId) {
        return defectiveProductPhotoService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<DefectiveProductPhotoDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return defectiveProductPhotoService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<DefectiveProductPhotoDto> getAll() {
        return defectiveProductPhotoService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<DefectiveProductPhotoDto> getAll(Pageable pageable) {
        return defectiveProductPhotoService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public DefectiveProductPhotoDto update(@RequestBody DefectiveProductPhotoDto dto) {
        return defectiveProductPhotoService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<DefectiveProductPhotoDto> update(@RequestBody List<DefectiveProductPhotoDto> dto) {
        return defectiveProductPhotoService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public DefectiveProductPhotoDto save(@RequestBody DefectiveProductPhotoDto dto) {
        return defectiveProductPhotoService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<DefectiveProductPhotoDto> save(@RequestBody List<DefectiveProductPhotoDto> dto) {
        return defectiveProductPhotoService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        defectiveProductPhotoService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        defectiveProductPhotoService.delete(id);
    }
}
