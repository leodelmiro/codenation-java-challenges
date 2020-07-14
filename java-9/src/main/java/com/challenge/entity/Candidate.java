package com.challenge.entity;

import com.challenge.entity.listeners.CandidateListener;
import com.challenge.entity.pk.CandidatePK;
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
@EntityListeners(CandidateListener.class)
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CandidatePK id;

    @NotNull
    private Long status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
