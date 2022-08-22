package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payment_details")
@EntityListeners(AuditingEntityListener.class)
public class PaymentDetailsEntity extends DefaultSystemAttributes implements Serializable {

    @Id
    @Column(name = "payment_details_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_details_seq_gen")
    @SequenceGenerator(name = "payment_details_seq_gen", sequenceName = "payment_details_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "system_details_value")
    private String systemDetailsValue;

    @Column(name = "nsi_payment_status")
    private Long nsiPaymentStatus;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "paymentDetails")
    private CoreOrderEntity coreOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        PaymentDetailsEntity that = (PaymentDetailsEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
