package com.challenge.entity;

import com.challenge.entity.listeners.UserListener;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@EntityListeners(UserListener.class)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "full_name", length = 100)
    @Size(max = 100)
    private String fullName;

    @NotNull
    @Email
    @Column(length = 100)
    @Size(max = 100)
    private String email;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @OneToMany(mappedBy = "id.user")
    private Collection<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private Collection<Submission> submissions;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
