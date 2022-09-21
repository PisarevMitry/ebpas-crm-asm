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
import ru.stc.ebpas.crm.asm.model.dto.CoreOrderDto;
import ru.stc.ebpas.crm.asm.service.api.CoreOrderService;

import java.util.List;

@Tag(name = "API работы с деталями о заказе")
@RequiredArgsConstructor
@RestController
@RequestMapping("/core-order")
public class CoreOrderController {

    private final CoreOrderService coreOrderService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public CoreOrderDto getById(@PathVariable Long id) {
        return coreOrderService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<CoreOrderDto> getById(@RequestBody List<Long> listId) {
        return coreOrderService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<CoreOrderDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return coreOrderService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<CoreOrderDto> getAll() {
        return coreOrderService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<CoreOrderDto> getAll(Pageable pageable) {
        return coreOrderService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public CoreOrderDto update(@RequestBody CoreOrderDto dto) {
        return coreOrderService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<CoreOrderDto> update(@RequestBody List<CoreOrderDto> dto) {
        return coreOrderService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public CoreOrderDto save(@RequestBody CoreOrderDto dto) {
        return coreOrderService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<CoreOrderDto> save(@RequestBody List<CoreOrderDto> dto) {
        return coreOrderService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coreOrderService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        coreOrderService.delete(id);
    }
}
