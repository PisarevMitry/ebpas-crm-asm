package ru.stc.ebpas.crm.pm.controller;

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
import ru.stc.ebpas.crm.pm.model.dto.AvailableProductDto;
import ru.stc.ebpas.crm.pm.service.api.AvailableProductService;

import java.util.List;

@Tag(name = "API работы с доступными товарами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/available-product")
public class AvailableProductController {

    private final AvailableProductService availableProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public AvailableProductDto getById(@PathVariable Long id) {
        return availableProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<AvailableProductDto> getById(@RequestBody List<Long> listId) {
        return availableProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<AvailableProductDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return availableProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<AvailableProductDto> getAll() {
        return availableProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<AvailableProductDto> getAll(Pageable pageable) {
        return availableProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public AvailableProductDto update(@RequestBody AvailableProductDto dto) {
        return availableProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<AvailableProductDto> update(@RequestBody List<AvailableProductDto> dto) {
        return availableProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public AvailableProductDto save(@RequestBody AvailableProductDto dto) {
        return availableProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<AvailableProductDto> save(@RequestBody List<AvailableProductDto> dto) {
        return availableProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        availableProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        availableProductService.delete(id);
    }
}
