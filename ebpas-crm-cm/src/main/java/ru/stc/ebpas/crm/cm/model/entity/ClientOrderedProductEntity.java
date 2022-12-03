package ru.stc.ebpas.crm.cm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.ComplexDatabaseEntity;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_ordered_product")
@EntityListeners(AuditingEntityListener.class)
public class ClientOrderedProductEntity extends DefaultSystemAttributes implements Serializable, ComplexDatabaseEntity {

    @EmbeddedId
    private ClientOrderedProductKey id;

    @Column(name = "amount_total")
    private Integer amountTotal;

    @Column(name = "price_unit")
    private Long priceUnit;

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
