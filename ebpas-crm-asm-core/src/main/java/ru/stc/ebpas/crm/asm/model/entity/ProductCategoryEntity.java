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
@Table(name = "product_category")
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

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = CoreSpecialConditionEntity.class)
    @JoinTable(name = "category_special_condition", joinColumns = @JoinColumn(name = "product_category_id"),
            inverseJoinColumns = @JoinColumn(name = "special_condition_details_id"))
    private Set<CoreSpecialConditionEntity> specialConditions;

    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products;

    @OneToMany(mappedBy = "parentProductCategory")
    private Set<ProductCategoryEntity> childProductCategories;

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
