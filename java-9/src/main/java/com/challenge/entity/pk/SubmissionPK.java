package com.challenge.entity.pk;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubmissionPK implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
}
