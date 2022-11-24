package ru.stc.ebpas.crm.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.CascadeType;
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

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "core_order")
@EntityListeners(AuditingEntityListener.class)
public class CoreOrderEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "core_order_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "core_order_seq_gen")
    @SequenceGenerator(name = "core_order_seq_gen", sequenceName = "core_order_seq", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assembly_details_id", referencedColumnName = "assembly_details_id", nullable = false)
    private AssemblyDetailsEntity assemblyDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_details_id", referencedColumnName = "payment_details_id", nullable = false)
    private PaymentDetailsEntity paymentDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_details_id", referencedColumnName = "delivery_details_id", nullable = false)
    private DeliveryDetailsEntity deliveryDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_details_id", referencedColumnName = "return_details_id", nullable = false)
    private ReturnDetailsEntity returnDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private ClientEntity client;

    @Column(name = "nsi_core_order_status")
    private Long nsiCoreOrderStatus;

    @Column(name = "requirement_org_doc_status")
    private Boolean requirementOrgDocStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CoreOrderEntity that = (CoreOrderEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
