package ru.stc.ebpas.crm.cm.controller;

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
import ru.stc.ebpas.crm.cm.model.dto.UserInfoDto;
import ru.stc.ebpas.crm.cm.service.api.UserInfoService;

import java.util.List;

@Tag(name = "API модели 11")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Operation(summary = "Получить по идентификатору")
    @GetMapping("/{id}")
    public UserInfoDto getById(@PathVariable Long id) {
        return userInfoService.getById(id);
    }

    @Operation(summary = "Получить по списку идентификаторов")
    @GetMapping("/specific-list")
    public List<UserInfoDto> getById(@RequestBody List<Long> listId) {
        return userInfoService.getById(listId);
    }

    @Operation(summary = "Получить по списку идентификаторов постранично")
    @GetMapping("/specific-list/pageble")
    public Page<UserInfoDto> getById(@RequestBody List<Long> listId, Pageable pageable) {
        return userInfoService.getById(listId, pageable);
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<UserInfoDto> getAll() {
        return userInfoService.getAll();
    }

    @Operation(summary = "Получить все постранично")
    @GetMapping("/all/pageble")
    public Page<UserInfoDto> getAll(Pageable pageable) {
        return userInfoService.getAll(pageable);
    }

    @Operation(summary = "Обновить")
    @PutMapping
    public UserInfoDto update(@RequestBody UserInfoDto dto) {
        return userInfoService.update(dto);
    }

    @Operation(summary = "Обновить список")
    @PutMapping("/specific-list")
    public List<UserInfoDto> update(@RequestBody List<UserInfoDto> dto) {
        return userInfoService.update(dto);
    }

    @Operation(summary = "Сохранить")
    @PostMapping
    public UserInfoDto save(@RequestBody UserInfoDto dto) {
        return userInfoService.save(dto);
    }

    @Operation(summary = "Сохранить список")
    @PostMapping("/specific-list")
    public List<UserInfoDto> save(@RequestBody List<UserInfoDto> dto) {
        return userInfoService.save(dto);
    }

    @Operation(summary = "Удалить по идентификатору")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userInfoService.delete(id);
    }

    @Operation(summary = "Удалить список по идентификаторам")
    @DeleteMapping("/specific-list")
    public void delete(@RequestBody List<Long> id) {
        userInfoService.delete(id);
    }
}
