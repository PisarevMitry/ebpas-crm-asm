package ru.stc.ebpas.crm.om.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

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

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_method")
@EntityListeners(AuditingEntityListener.class)
public class DeliveryType extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "delivery_method_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_method_seq_gen")
    @SequenceGenerator(name = "delivery_method_seq_gen", sequenceName = "delivery_method_seq", allocationSize = 1)
    private Long id;

    @Column(name = "method_name")
    private String deliveryName;

//ToDo описание доставки

//    @Column(name = "system_details")
//    private Object systemDetails;

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
