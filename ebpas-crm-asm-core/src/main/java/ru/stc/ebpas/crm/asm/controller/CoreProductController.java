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
import ru.stc.ebpas.crm.asm.model.dto.CoreProductDto;
import ru.stc.ebpas.crm.asm.service.api.CoreProductService;

import java.util.List;

@Tag(name = "API работы с базовым товаром")
@RequiredArgsConstructor
@RestController
@RequestMapping("/core-product")
public class CoreProductController {

    private final CoreProductService coreProductService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public CoreProductDto getById(@PathVariable Long id) {
        return coreProductService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<CoreProductDto> getById(@RequestBody List<Long> listId) {
        return coreProductService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<CoreProductDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return coreProductService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<CoreProductDto> getAll() {
        return coreProductService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<CoreProductDto> getAll(Pageable pageable) {
        return coreProductService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public CoreProductDto update(@RequestBody CoreProductDto dto) {
        return coreProductService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<CoreProductDto> update(@RequestBody List<CoreProductDto> dto) {
        return coreProductService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public CoreProductDto save(@RequestBody CoreProductDto dto) {
        return coreProductService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<CoreProductDto> save(@RequestBody List<CoreProductDto> dto) {
        return coreProductService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coreProductService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        coreProductService.delete(id);
    }
}
