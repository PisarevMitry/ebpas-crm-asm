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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category")
@EntityListeners(AuditingEntityListener.class)
public class ProductCategoryEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "product_category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_seq_gen")
    @SequenceGenerator(name = "product_category_seq_gen", sequenceName = "product_category_seq", allocationSize = 1)
    private Long id;

    @Column(name = "product_category_name")
    private String name;

    //ToDo описание категории

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "product_category_id")
    private ProductCategoryEntity parentProductCategory;

    @ElementCollection
    @CollectionTable(name = "category_special_condition", joinColumns = @JoinColumn(name = "product_category_id"))
    @Column(name = "special_condition_details_id")
    private Set<Long> specialConditions;

    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products;

    @OneToMany(mappedBy = "parentProductCategory")
    private Set<ProductCategoryEntity> childProductCategories;

    public void addChildProductCategory(ProductCategoryEntity productCategory) {
        if (this.childProductCategories == null) {
            this.childProductCategories = new HashSet<>();
        }
        productCategory.setParentProductCategory(this);
        this.childProductCategories.add(productCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ProductCategoryEntity that = (ProductCategoryEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
