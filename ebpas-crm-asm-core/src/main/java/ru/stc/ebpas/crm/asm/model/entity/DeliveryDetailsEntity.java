package ru.stc.ebpas.crm.asm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_details")
public class DeliveryDetailsEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "delivery_details_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_details_seq_gen")
    @SequenceGenerator(name = "delivery_details_seq_gen", sequenceName = "delivery_details_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_method_id", referencedColumnName = "delivery_method_id", nullable = false)
    private DeliveryType deliveryType;

    @Column(name = "nsi_address_id")
    private Long nsiAddressId;

    @Column(name = "start_delivery_dttm")
    private LocalDateTime startDeliveryDttm;

    @Column(name = "end_delivery_dttm")
    private LocalDateTime endDeliveryDttm;

    @Column(name = "delivery_notes")
    private String deliveryNotes;

    @Column(name = "nsi_delivery_status")
    private Long nsiDeliveryStatus;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "deliveryDetails")
    private CoreOrderEntity coreOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        DeliveryDetailsEntity that = (DeliveryDetailsEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
