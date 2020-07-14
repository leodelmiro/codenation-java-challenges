package com.challenge.entity;

import com.challenge.entity.listeners.SubmissionListener;
import com.challenge.entity.pk.SubmissionPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(SubmissionListener.class)
public class Submission implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SubmissionPK id;

    @NotNull
    private Float score;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
