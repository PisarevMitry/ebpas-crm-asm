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
import ru.stc.ebpas.crm.asm.model.dto.ReturnDetailsDto;
import ru.stc.ebpas.crm.asm.service.api.ReturnDetailsService;

import java.util.List;

@Tag(name = "API модели 8")
@RequiredArgsConstructor
@RestController
@RequestMapping("/return-details")
public class ReturnDetailsController {

    private final ReturnDetailsService returnDetailsService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public ReturnDetailsDto getById(@PathVariable Long id) {
        return returnDetailsService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<ReturnDetailsDto> getById(@RequestBody List<Long> listId) {
        return returnDetailsService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<ReturnDetailsDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return returnDetailsService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<ReturnDetailsDto> getAll() {
        return returnDetailsService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<ReturnDetailsDto> getAll(Pageable pageable) {
        return returnDetailsService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public ReturnDetailsDto update(@RequestBody ReturnDetailsDto dto) {
        return returnDetailsService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<ReturnDetailsDto> update(@RequestBody List<ReturnDetailsDto> dto) {
        return returnDetailsService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public ReturnDetailsDto save(@RequestBody ReturnDetailsDto dto) {
        return returnDetailsService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<ReturnDetailsDto> save(@RequestBody List<ReturnDetailsDto> dto) {
        return returnDetailsService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        returnDetailsService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        returnDetailsService.delete(id);
    }
}
