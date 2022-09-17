package ru.stc.ebpas.crm.asm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DatabaseEntity;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_payment_method")
@EntityListeners(AuditingEntityListener.class)
public class ClientPaymentMethodEntity extends DefaultSystemAttributes implements Serializable, DatabaseEntity {

    @Id
    @Column(name = "client_payment_method_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_payment_method_seq_gen")
    @SequenceGenerator(name = "client_payment_method_seq_gen", sequenceName = "client_payment_method_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "system_details_value")
    private String systemDetailsValue;

    @Column(name = "display_status")
    private Boolean displayed;

    @Column(name = "using_default_status")
    private Boolean defaultUsed;

    @Column(name = "blocked_status")
    private Boolean blocked;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ClientPaymentMethodEntity that = (ClientPaymentMethodEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
