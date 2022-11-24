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
import ru.stc.ebpas.crm.om.model.dto.DefectiveProductDto;
import ru.stc.ebpas.crm.om.service.api.DefectiveProductService;

import java.util.List;

@Tag(name = "API работы с бракованными товарами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/defective-product")
public class DefectiveProductController {

    private final DefectiveProductService defectiveProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public DefectiveProductDto getById(@PathVariable Long id) {
        return defectiveProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<DefectiveProductDto> getById(@RequestBody List<Long> listId) {
        return defectiveProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<DefectiveProductDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return defectiveProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<DefectiveProductDto> getAll() {
        return defectiveProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<DefectiveProductDto> getAll(Pageable pageable) {
        return defectiveProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public DefectiveProductDto update(@RequestBody DefectiveProductDto dto) {
        return defectiveProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<DefectiveProductDto> update(@RequestBody List<DefectiveProductDto> dto) {
        return defectiveProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public DefectiveProductDto save(@RequestBody DefectiveProductDto dto) {
        return defectiveProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<DefectiveProductDto> save(@RequestBody List<DefectiveProductDto> dto) {
        return defectiveProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        defectiveProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        defectiveProductService.delete(id);
    }
}
