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

import javax.persistence.CascadeType;
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
import javax.persistence.JoinTable;
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
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @Column(name = "product_nomenclature", nullable = false)
    private String nomenclature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "core_product_id", referencedColumnName = "core_product_id", nullable = false)
    private CoreProductEntity coreProduct;

    @Column(name = "description")
    private String description;

//    @Column(name = "option")
//    @JdbcTypeCode(SqlTypes.JSON)
//    private Map<String, String> options;

    @Column(name = "blocked_status", nullable = false)
    private Boolean blocked = false;

    @OneToMany(mappedBy = "product")
    private Set<AvailableProductEntity> availableProducts;

    @ElementCollection
    @CollectionTable(name = "defective_product", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "defective_product_id")
    private Set<Long> defectiveProducts;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = ProductCategoryEntity.class)
    @JoinTable(name = "product_by_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_category_id"))
    private Set<ProductCategoryEntity> categories;

    @OneToMany(mappedBy = "product")
    private Set<FeedbackEntity> feedbacks;

    @OneToMany(mappedBy = "product")
    private Set<ProductPhotoEntity> photos;

    @ElementCollection
    @CollectionTable(name = "product_special_condition", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "special_condition_details_id")
    private Set<Long> specialConditions;

    public void addAvailableProduct(AvailableProductEntity availableProduct) {
        if (this.availableProducts == null) {
            this.availableProducts = new HashSet<>();
        }
        availableProduct.setProduct(this);
        this.availableProducts.add(availableProduct);
    }

    public void addFeedback(FeedbackEntity feedback) {
        if (this.feedbacks == null) {
            this.feedbacks = new HashSet<>();
        }
        feedback.setProduct(this);
        this.feedbacks.add(feedback);
    }

    public void addPhoto(ProductPhotoEntity productPhoto) {
        if (this.photos == null) {
            this.photos = new HashSet<>();
        }
        productPhoto.setProduct(this);
        this.photos.add(productPhoto);
    }

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
