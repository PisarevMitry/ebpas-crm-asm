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
public class ClientDeferredProductKey implements Serializable, CompositeKey {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "available_product_id")
    private Long availableProductId;

    @Override
    public Long getFirstPart() {
        return clientId;
    }

    @Override
    public Long getSecondPart() {
        return availableProductId;
    }
}
