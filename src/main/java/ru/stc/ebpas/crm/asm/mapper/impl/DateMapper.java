package ru.stc.ebpas.crm.asm.mapper.impl;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Маппер для парса даты и строки.
 */
@Component
public class DateMapper {

    /**
     * Парс даты в строку.
     */
    public String asString(Date date) {
        return date != null ? String.valueOf(date.getTime()) : null;
    }

    /**
     * Парс строки в дату.
     */
    public Date asDate(String date) {
            return date != null ? new Date(Long.parseLong(date)) : new Date();
    }
}
