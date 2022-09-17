package ru.stc.ebpas.crm.asm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.stc.ebpas.common.core.model.entity.DatabaseEntity;
import ru.stc.ebpas.common.core.model.entity.DefaultSystemAttributes;

import javax.persistence.Column;
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

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "defective_product_photo")
@EntityListeners(AuditingEntityListener.class)
public class DefectiveProductPhotoEntity extends DefaultSystemAttributes implements Serializable, DatabaseEntity {

    @Id
    @Column(name = "defective_product_photo_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defective_product_photo_seq_gen")
    @SequenceGenerator(name = "defective_product_photo_seq_gen", sequenceName = "defective_product_photo_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "defective_product_id", referencedColumnName = "defective_product_id", nullable = false)
    private DefectiveProductEntity defectiveProduct;

    @Column(name = "nsi_media_id")
    private Long nsiMediaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        DefectiveProductPhotoEntity that = (DefectiveProductPhotoEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
