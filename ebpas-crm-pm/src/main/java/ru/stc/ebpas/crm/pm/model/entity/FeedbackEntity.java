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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "product_feedback")
@EntityListeners(AuditingEntityListener.class)
public class FeedbackEntity extends DefaultSystemAttributes implements Serializable, SimpleDatabaseEntity {

    @Id
    @Column(name = "product_feedback_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_feedback_seq_gen")
    @SequenceGenerator(name = "product_feedback_seq_gen", sequenceName = "product_feedback_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "client_id")
    private Long client;

    @Column(name = "grade")
    private Short grade;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productFeedback")
    private Set<FeedbackPhotoEntity> photos;

    public void addPhoto(FeedbackPhotoEntity feedbackPhoto) {
        if (this.photos == null) {
            this.photos = new HashSet<>();
        }
        feedbackPhoto.setProductFeedback(this);
        this.photos.add(feedbackPhoto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        FeedbackEntity that = (FeedbackEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
