package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "polls")
public class Poll {

    @Id
    private String id;
    private String adminKey;
    private Timestamp latestChange;
    private Timestamp initiated;
    private Integer participantsCount;
    private Integer inviteesCount;
    private String type;
    private Boolean hidden;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;
    private String optionsHash;
    private String device;
    private String levels;

}
