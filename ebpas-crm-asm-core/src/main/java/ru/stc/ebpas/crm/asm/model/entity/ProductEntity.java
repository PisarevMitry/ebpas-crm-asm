package ru.stc.ebpas.crm.asm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;
import ru.stc.ebpas.common.core.model.entity.SimpleDatabaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class ProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "core_product_id", referencedColumnName = "core_product_id", nullable = false)
    private CoreProductEntity coreProduct;

    @Column(name = "description")
    private String description;

    @Column(name = "option")
    private String options;

    @Column(name = "blocked_status")
    private Boolean blocked;

    @OneToMany(mappedBy = "product")
    private Set<AvailableProductEntity> availableProducts;

    @OneToMany(mappedBy = "product")
    private Set<DefectiveProductEntity> defectiveProducts;

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

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = CoreSpecialConditionEntity.class)
    @JoinTable(name = "product_special_condition", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "special_condition_details_id"))
    private Set<CoreSpecialConditionEntity> specialConditions;

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
