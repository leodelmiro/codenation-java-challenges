package com.challenge.entity;

import com.challenge.entity.listeners.ChallengeListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(ChallengeListener.class)
public class Challenge implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @OneToMany(mappedBy = "challenge")
    private Collection<Acceleration> accelerations;

    @OneToMany(mappedBy = "id.challenge")
    private Collection<Submission> submissions;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
