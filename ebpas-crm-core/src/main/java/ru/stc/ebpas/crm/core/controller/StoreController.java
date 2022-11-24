package ru.stc.ebpas.crm.core.controller;

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
import ru.stc.ebpas.crm.core.model.dto.StoreDto;
import ru.stc.ebpas.crm.core.service.api.StoreService;

import java.util.List;

@Tag(name = "API модели 10")
@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public StoreDto getById(@PathVariable Long id) {
        return storeService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<StoreDto> getById(@RequestBody List<Long> listId) {
        return storeService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<StoreDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return storeService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<StoreDto> getAll() {
        return storeService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<StoreDto> getAll(Pageable pageable) {
        return storeService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public StoreDto update(@RequestBody StoreDto dto) {
        return storeService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<StoreDto> update(@RequestBody List<StoreDto> dto) {
        return storeService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public StoreDto save(@RequestBody StoreDto dto) {
        return storeService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<StoreDto> save(@RequestBody List<StoreDto> dto) {
        return storeService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        storeService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        storeService.delete(id);
    }
}
