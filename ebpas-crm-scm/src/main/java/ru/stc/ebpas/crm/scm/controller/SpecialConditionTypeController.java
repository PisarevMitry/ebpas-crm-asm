package ru.stc.ebpas.crm.scm.controller;

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
import ru.stc.ebpas.crm.scm.model.dto.SpecialConditionTypeDto;
import ru.stc.ebpas.crm.scm.service.api.SpecialConditionTypeService;

import java.util.List;

@Tag(name = "API модели 9")
@RequiredArgsConstructor
@RestController
@RequestMapping("/special-condition-type")
public class SpecialConditionTypeController {

    private final SpecialConditionTypeService specialConditionTypeService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public SpecialConditionTypeDto getById(@PathVariable Long id) {
        return specialConditionTypeService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<SpecialConditionTypeDto> getById(@RequestBody List<Long> listId) {
        return specialConditionTypeService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<SpecialConditionTypeDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return specialConditionTypeService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<SpecialConditionTypeDto> getAll() {
        return specialConditionTypeService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<SpecialConditionTypeDto> getAll(Pageable pageable) {
        return specialConditionTypeService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public SpecialConditionTypeDto update(@RequestBody SpecialConditionTypeDto dto) {
        return specialConditionTypeService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<SpecialConditionTypeDto> update(@RequestBody List<SpecialConditionTypeDto> dto) {
        return specialConditionTypeService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public SpecialConditionTypeDto save(@RequestBody SpecialConditionTypeDto dto) {
        return specialConditionTypeService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<SpecialConditionTypeDto> save(@RequestBody List<SpecialConditionTypeDto> dto) {
        return specialConditionTypeService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        specialConditionTypeService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        specialConditionTypeService.delete(id);
    }
}
