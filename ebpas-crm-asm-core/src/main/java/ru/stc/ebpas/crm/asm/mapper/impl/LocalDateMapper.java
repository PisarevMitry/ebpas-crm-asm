package ru.stc.ebpas.crm.asm.mapper.impl;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;

@Mapper
public class LocalDateMapper {

    public String toString(@NotNull LocalDate date) {
        return date.format(ISO_ZONED_DATE_TIME);
    }

    public LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, ISO_ZONED_DATE_TIME);
    }
}
