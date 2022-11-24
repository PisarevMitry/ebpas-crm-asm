package ru.stc.ebpas.crm.core.controller.provision.maker;

import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;
import ru.stc.ebpas.crm.core.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.core.model.dto.CoreOrderDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Справочник тестовых значений.
 */
@NoArgsConstructor
public final class StubValues {

    public static final String STUB_STRING = "N/D";

    public static final Long STUB_LONG = 0L;

    public static final Double STUB_DOUBLE = 0.0;

    public static final OffsetDateTime STUB_OFFSET_DATE_TIME = OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC);

    public static final LocalDate STUB_LOCAL_DATE = LocalDate.now();

    public static final LocalDateTime STUB_LOCAL_DATE_TIME = LocalDateTime.now();

    public static final Short STUB_YEAR = 2022;

    public static final Map<String, String> STUB_MAP = new HashMap<>();

    public static final NsiStatusDto STUB_NSI_STATUS_DTO = new NsiStatusDto();

    public static final Set<ClientOrderedProductDto> STUB_LIST_CLIENT_ORDERED_PRODUCT_DTO = new HashSet<>();

    public static final CoreOrderDto STUB_CORE_ORDER_DTO = new CoreOrderDto();
}
