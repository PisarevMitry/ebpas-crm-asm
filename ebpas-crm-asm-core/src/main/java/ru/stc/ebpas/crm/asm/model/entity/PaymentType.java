package ru.stc.ebpas.crm.asm.model.entity;

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
@Table(name = "payment_method")
@EntityListeners(AuditingEntityListener.class)
public class PaymentType extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "payment_method_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_seq_gen")
    @SequenceGenerator(name = "available_product_seq_gen", sequenceName = "payment_method_seq", allocationSize = 1)
    private Long id;

    @Column(name = "method_name")
    private String payment_name;

//    @Column(name = "system_details")
//    private Object systemDetails;

    @OneToMany(mappedBy = "paymentType")
    private Set<ClientPaymentMethodEntity> clientPaymentMethods;

    @OneToMany(mappedBy = "paymentType")
    private Set<PaymentDetailsEntity> paymentDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        PaymentType that = (PaymentType) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
