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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "available_product")
@EntityListeners(AuditingEntityListener.class)
public class AvailableProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "available_product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "available_product_seq_gen")
    @SequenceGenerator(name = "available_product_seq_gen", sequenceName = "available_product_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private StoreEntity store;

    @Column(name = "amount_total")
    private Integer amountTotal;

    @Column(name = "blocked_total")
    private Integer blockedTotal;

    @Column(name = "price_unit")
    private Long priceUnit;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = CoreSpecialConditionEntity.class)
    @JoinTable(name = "available_product_special_condition", joinColumns = @JoinColumn(name = "available_product_id"),
            inverseJoinColumns = @JoinColumn(name = "special_condition_details_id"))
    private Set<CoreSpecialConditionEntity> specialConditions;

    @OneToMany(mappedBy = "availableProduct")
    private Set<ClientDeferredProductEntity> clientDeferredProducts;

    @OneToMany(mappedBy = "availableProduct")
    private Set<ClientOrderedProductEntity> clientOrderedProducts;

    @OneToMany(mappedBy = "availableProduct")
    private Set<ClientShoppedProductEntity> clientShoppedProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        AvailableProductEntity that = (AvailableProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
