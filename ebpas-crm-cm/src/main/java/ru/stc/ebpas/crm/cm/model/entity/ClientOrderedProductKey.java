package ru.stc.ebpas.crm.cm.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.stc.ebpas.common.core.model.entity.CompositeKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClientOrderedProductKey implements Serializable, CompositeKey {

    @Column(name = "assembly_details_id")
    private Long assemblyDetailsId;

    @Column(name = "available_product_id")
    private Long availableProductId;

    @Override
    public Long getFirstPart() {
        return assemblyDetailsId;
    }

    @Override
    public Long getSecondPart() {
        return availableProductId;
    }
}
