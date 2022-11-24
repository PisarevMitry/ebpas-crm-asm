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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ElementCollection
    @CollectionTable(name = "available_product_special_condition", joinColumns = @JoinColumn(name = "available_product_id"))
    @Column(name = "special_condition_details_id")
    private Set<Long> specialConditions;

    @ElementCollection
    @CollectionTable(name = "client_deferred_product", joinColumns = @JoinColumn(name = "available_product_id"))
    @Column(name = "client_id")
    private Set<Long> clientDeferredProducts;

    //ToDo
//    @Formula(value = "select c.client_id from client c left join client_deferred_product cdp on c.client_id = cdp.client_id where cdp.available_product_id = id")
    @ElementCollection
    @CollectionTable(name = "client_deferred_product", joinColumns = @JoinColumn(name = "available_product_id"))
    @Column(name = "client_id")
    private Set<Long> clientOrderedProducts;

    @ElementCollection
    @CollectionTable(name = "client_shopped_product", joinColumns = @JoinColumn(name = "available_product_id"))
    @Column(name = "client_id")
    private Set<Long> clientShoppedProducts;

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
