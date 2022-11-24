package ru.stc.ebpas.crm.scm.mapper.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;

@Component
public class DateTimeMapper {

    public String toString(@NotNull LocalDate date) {
        return date.format(ISO_ZONED_DATE_TIME);
    }

    public LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, ISO_ZONED_DATE_TIME);
    }
}
