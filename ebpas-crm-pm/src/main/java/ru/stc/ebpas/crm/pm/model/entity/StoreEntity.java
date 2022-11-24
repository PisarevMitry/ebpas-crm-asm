package ru.stc.ebpas.crm.pm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "store")
@EntityListeners(AuditingEntityListener.class)
public class StoreEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq_gen")
    @SequenceGenerator(name = "store_seq_gen", sequenceName = "store_seq", allocationSize = 1)
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "nsi_address_id")
    private Long nsiAddressId;

    @Column(name = "pickup_status")
    private Boolean pickupAvailable;

    @Column(name = "availability_status")
    private Boolean available;

    @OneToMany(mappedBy = "store")
    private Set<AvailableProductEntity> availableProducts;

    @ElementCollection
    @CollectionTable(name = "store_special_condition", joinColumns = @JoinColumn(name = "store_id"))
    @Column(name = "special_condition_details_id")
    private Set<Long> specialConditions;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        StoreEntity that = (StoreEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
