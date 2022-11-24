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
import ru.stc.ebpas.crm.scm.model.dto.CoreSpecialConditionDto;
import ru.stc.ebpas.crm.scm.service.api.CoreSpecialConditionService;

import java.util.List;

@Tag(name = "API работы со специальными условиями торговли")
@RequiredArgsConstructor
@RestController
@RequestMapping("/core-special-condition")
public class CoreSpecialConditionController {

    private final CoreSpecialConditionService coreSpecialConditionService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public CoreSpecialConditionDto getById(@PathVariable Long id) {
        return coreSpecialConditionService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<CoreSpecialConditionDto> getById(@RequestBody List<Long> listId) {
        return coreSpecialConditionService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<CoreSpecialConditionDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return coreSpecialConditionService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<CoreSpecialConditionDto> getAll() {
        return coreSpecialConditionService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<CoreSpecialConditionDto> getAll(Pageable pageable) {
        return coreSpecialConditionService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public CoreSpecialConditionDto update(@RequestBody CoreSpecialConditionDto dto) {
        return coreSpecialConditionService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<CoreSpecialConditionDto> update(@RequestBody List<CoreSpecialConditionDto> dto) {
        return coreSpecialConditionService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public CoreSpecialConditionDto save(@RequestBody CoreSpecialConditionDto dto) {
        return coreSpecialConditionService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<CoreSpecialConditionDto> save(@RequestBody List<CoreSpecialConditionDto> dto) {
        return coreSpecialConditionService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coreSpecialConditionService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        coreSpecialConditionService.delete(id);
    }
}
