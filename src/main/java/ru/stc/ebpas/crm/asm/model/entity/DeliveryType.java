package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "delivery_method")
@EntityListeners(AuditingEntityListener.class)
public class DeliveryType extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "delivery_method_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_method_seq_gen")
    @SequenceGenerator(name = "delivery_method_seq_gen", sequenceName = "delivery_method_seq", allocationSize = 1)
    private Long id;

    @Column(name = "method_name")
    private String deliveryName;

//ToDo описание доставки

    @Column(name = "system_details")
    private String systemDetails;

    @OneToMany(mappedBy = "deliveryType")
    private Set<DeliveryDetailsEntity> deliveryDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        DeliveryType that = (DeliveryType) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
