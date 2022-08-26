package ru.stc.ebpas.crm.asm.model.entity;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
@EntityListeners(AuditingEntityListener.class)
public class ClientEntity extends DefaultSystemAttributes implements Serializable {

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

    @OneToMany(mappedBy = "client")
    private Set<CoreOrderEntity> coreOrders;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = CoreSpecialConditionEntity.class)
    @JoinTable(name = "client_special_condition", joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "special_condition_id"))
    private Set<CoreSpecialConditionEntity> specialConditions;

    @OneToMany(mappedBy = "clientByClientId")
    private Set<ProductFeedbackEntity> productFeedbacks;

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
