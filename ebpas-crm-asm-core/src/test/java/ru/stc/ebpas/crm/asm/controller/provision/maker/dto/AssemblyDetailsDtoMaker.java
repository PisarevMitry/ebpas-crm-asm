package ru.stc.ebpas.crm.asm.controller.provision.maker.dto;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import ru.stc.ebpas.common.core.model.entity.nsi.NsiStatusDto;
import ru.stc.ebpas.crm.asm.controller.provision.maker.StubValues;
import ru.stc.ebpas.crm.asm.model.dto.AssemblyDetailsDto;
import ru.stc.ebpas.crm.asm.model.dto.ClientOrderedProductDto;
import ru.stc.ebpas.crm.asm.model.dto.CoreOrderDto;

import java.util.Set;

import static com.natpryce.makeiteasy.Property.newProperty;

public final class AssemblyDetailsDtoMaker {

    public static final Property<AssemblyDetailsDto, Long> ID = newProperty();
    public static final Property<AssemblyDetailsDto, NsiStatusDto> NSI_ASSEMBLY_STATUS = newProperty();
    public static final Property<AssemblyDetailsDto, Set<ClientOrderedProductDto>> ORDERED_PRODUCTS = newProperty();
    public static final Property<AssemblyDetailsDto, CoreOrderDto> CORE_ORDER = newProperty();

    public static final Instantiator<AssemblyDetailsDto> ASSEMBLY_DETAILS_DTO = propertyLookup -> {
        AssemblyDetailsDto dto = new AssemblyDetailsDto();
        dto.setId(propertyLookup.valueOf(ID, StubValues.STUB_LONG));
        dto.setNsiAssemblyStatus(propertyLookup.valueOf(NSI_ASSEMBLY_STATUS, StubValues.STUB_NSI_STATUS_DTO));
        dto.setOrderedProducts(propertyLookup.valueOf(ORDERED_PRODUCTS, StubValues.STUB_LIST_CLIENT_ORDERED_PRODUCT_DTO));
        dto.setCoreOrder(propertyLookup.valueOf(CORE_ORDER, StubValues.STUB_CORE_ORDER_DTO));

        return dto;
    };

    private AssemblyDetailsDtoMaker() {

    }
}
