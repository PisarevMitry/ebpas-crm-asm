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
import ru.stc.ebpas.crm.core.model.dto.CoreUserDto;
import ru.stc.ebpas.crm.core.service.api.CoreUserService;

import java.util.List;

@Tag(name = "API работы с данными о пользователях")
@RequiredArgsConstructor
@RestController
@RequestMapping("/core-user")
public class CoreUserController {

    private final CoreUserService coreUserService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public CoreUserDto getById(@PathVariable Long id) {
        return coreUserService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<CoreUserDto> getById(@RequestBody List<Long> listId) {
        return coreUserService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<CoreUserDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return coreUserService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<CoreUserDto> getAll() {
        return coreUserService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<CoreUserDto> getAll(Pageable pageable) {
        return coreUserService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public CoreUserDto update(@RequestBody CoreUserDto dto) {
        return coreUserService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<CoreUserDto> update(@RequestBody List<CoreUserDto> dto) {
        return coreUserService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public CoreUserDto save(@RequestBody CoreUserDto dto) {
        return coreUserService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<CoreUserDto> save(@RequestBody List<CoreUserDto> dto) {
        return coreUserService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coreUserService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        coreUserService.delete(id);
    }
}
