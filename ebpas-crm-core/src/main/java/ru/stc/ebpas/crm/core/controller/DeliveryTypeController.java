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
import ru.stc.ebpas.crm.core.model.dto.DeliveryTypeDto;
import ru.stc.ebpas.crm.core.service.api.DeliveryTypeService;

import java.util.List;

@Tag(name = "API работы с типом доставки")
@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery-type")
public class DeliveryTypeController {

    private final DeliveryTypeService deliveryTypeService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public DeliveryTypeDto getById(@PathVariable Long id) {
        return deliveryTypeService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<DeliveryTypeDto> getById(@RequestBody List<Long> listId) {
        return deliveryTypeService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<DeliveryTypeDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return deliveryTypeService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<DeliveryTypeDto> getAll() {
        return deliveryTypeService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<DeliveryTypeDto> getAll(Pageable pageable) {
        return deliveryTypeService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public DeliveryTypeDto update(@RequestBody DeliveryTypeDto dto) {
        return deliveryTypeService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<DeliveryTypeDto> update(@RequestBody List<DeliveryTypeDto> dto) {
        return deliveryTypeService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public DeliveryTypeDto save(@RequestBody DeliveryTypeDto dto) {
        return deliveryTypeService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<DeliveryTypeDto> save(@RequestBody List<DeliveryTypeDto> dto) {
        return deliveryTypeService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryTypeService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        deliveryTypeService.delete(id);
    }
}
