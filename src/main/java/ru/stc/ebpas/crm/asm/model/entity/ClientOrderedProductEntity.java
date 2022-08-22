package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "client_ordered_product")
@EntityListeners(AuditingEntityListener.class)
public class ClientOrderedProductEntity extends DefaultSystemAttributes implements Serializable {

    @EmbeddedId
    private ClientOrderedProductKey id;

    @Column(name = "amount_total")
    private Integer amountTotal;

    @Column(name = "price_unit")
    private Long priceUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("assemblyDetailsId")
    @JoinColumn(name = "assembly_details_id", referencedColumnName = "assembly_details_id", nullable = false)
    private AssemblyDetailsEntity assemblyDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("availableProductId")
    @JoinColumn(name = "available_product_id", referencedColumnName = "available_product_id", nullable = false)
    private AvailableProductEntity availableProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ClientOrderedProductEntity that = (ClientOrderedProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
