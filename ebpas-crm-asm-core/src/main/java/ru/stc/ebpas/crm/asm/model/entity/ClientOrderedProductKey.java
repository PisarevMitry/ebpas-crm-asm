package ru.stc.ebpas.crm.asm.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientOrderedProductKey implements Serializable {

    @Column(name = "assembly_details_id")
    private Long assemblyDetailsId;

    @Column(name = "available_product_id")
    private Long availableProductId;
}
