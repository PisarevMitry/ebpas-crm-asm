package ru.stc.ebpas.crm.cm.model.entity;

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "client")
@EntityListeners(AuditingEntityListener.class)
public class ClientEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_gen")
    @SequenceGenerator(name = "client_seq_gen", sequenceName = "client_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "core_user_id", referencedColumnName = "core_user_id", nullable = false)
    private CoreUserEntity coreUser;

    @OneToMany(mappedBy = "client")
    private Set<ClientAddressEntity> addresses;

    @OneToMany(mappedBy = "client")
    private Set<ClientPaymentMethodEntity> paymentMethods;

    @OneToMany(mappedBy = "client")
    private Set<ClientDeferredProductEntity> deferredProducts;

    @OneToMany(mappedBy = "client")
    private Set<ClientShoppedProductEntity> shoppedProducts;
//
//    @Formula(value = "select co.core_order_id from core_order co where co.client_id = id")
//    private Set<Long> coreOrders;
//
//    @Formula(value = "select csc.special_condition_id from client_special_condition csc where csc.client_id = id")
//    private Set<Long> specialConditions;
//
//    @Formula(value = "select pf.product_feedback_id from product_feedback pf where pf.client_id = id")
//    private Set<Long> productFeedbacks;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ClientEntity that = (ClientEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
