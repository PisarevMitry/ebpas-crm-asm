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
import ru.stc.ebpas.crm.asm.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.asm.service.api.AssemblyDetailsService;

import java.util.List;

@Tag(name = "API работы с деталями о заказе")
@RequiredArgsConstructor
@RestController
@RequestMapping("/assembly-detail")
public class AssemblyDetailsController {

    private final AssemblyDetailsService assemblyDetailsService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public AssemblyDetailsDto getById(@PathVariable Long id) {
        return assemblyDetailsService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<AssemblyDetailsDto> getById(@RequestBody List<Long> listId) {
        return assemblyDetailsService.getById(listId);
    }

    @Operation(summary = "Получить по идентификатору постранично")
    @GetMapping("/specific-list/pageble")
    public Page<AssemblyDetailsDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return assemblyDetailsService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<AssemblyDetailsDto> getAll() {
        return assemblyDetailsService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<AssemblyDetailsDto> getAll(Pageable pageable) {
        return assemblyDetailsService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public AssemblyDetailsDto update(@RequestBody AssemblyDetailsDto dto) {
        return assemblyDetailsService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<AssemblyDetailsDto> updateList(@RequestBody List<AssemblyDetailsDto> dto) {
        return assemblyDetailsService.updateList(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public AssemblyDetailsDto save(@RequestBody AssemblyDetailsDto dto) {
        return assemblyDetailsService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<AssemblyDetailsDto> save(@RequestBody List<AssemblyDetailsDto> dto) {
        return assemblyDetailsService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        assemblyDetailsService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        assemblyDetailsService.delete(id);
    }
}
