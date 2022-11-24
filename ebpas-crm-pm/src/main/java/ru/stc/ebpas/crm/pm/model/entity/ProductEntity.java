package ru.stc.ebpas.crm.pm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Formula;
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
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @Column(name = "product_nomenclature")
    private String nomenclature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "core_product_id", referencedColumnName = "core_product_id", nullable = false)
    private CoreProductEntity coreProduct;

    @Column(name = "description")
    private String description;

//    @Column(name = "option")
//    @JdbcTypeCode(SqlTypes.JSON)
//    private Map<String, String> options;

    @Column(name = "blocked_status")
    private Boolean blocked;

    @OneToMany(mappedBy = "product")
    private Set<AvailableProductEntity> availableProducts;

    @Formula(value = "select csc.special_condition_id from client_special_condition csc where csc.product_id = id")
    private Set<Long> defectiveProducts;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = ProductCategoryEntity.class)
    @JoinTable(name = "product_by_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_category_id"))
    private Set<ProductCategoryEntity> categories;

    @OneToMany(mappedBy = "product")
    private Set<ProductFeedbackEntity> feedbacks;

    @OneToMany(mappedBy = "product")
    private Set<ProductPhotoEntity> photos;

    @Formula(value = "select psc.special_condition_details_id from product_special_condition psc where psc.product_id = id")
    private Set<Long> specialConditions;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ProductEntity that = (ProductEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
