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
import ru.stc.ebpas.crm.core.model.dto.OrganizationInfoDto;
import ru.stc.ebpas.crm.core.service.api.OrganizationInfoService;

import java.util.List;

@Tag(name = "API сущности 2")
@RequiredArgsConstructor
@RestController
@RequestMapping("/organization-info")
public class OrganizationInfoController {

    private final OrganizationInfoService organizationInfoService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public OrganizationInfoDto getById(@PathVariable Long id) {
        return organizationInfoService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<OrganizationInfoDto> getById(@RequestBody List<Long> listId) {
        return organizationInfoService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<OrganizationInfoDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return organizationInfoService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<OrganizationInfoDto> getAll() {
        return organizationInfoService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<OrganizationInfoDto> getAll(Pageable pageable) {
        return organizationInfoService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public OrganizationInfoDto update(@RequestBody OrganizationInfoDto dto) {
        return organizationInfoService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<OrganizationInfoDto> update(@RequestBody List<OrganizationInfoDto> dto) {
        return organizationInfoService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public OrganizationInfoDto save(@RequestBody OrganizationInfoDto dto) {
        return organizationInfoService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<OrganizationInfoDto> save(@RequestBody List<OrganizationInfoDto> dto) {
        return organizationInfoService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationInfoService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        organizationInfoService.delete(id);
    }
}
