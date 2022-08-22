package ru.stc.ebpas.crm.asm.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientShoppedProductKey implements Serializable {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "available_product_id")
    private Long availableProductId;
}
