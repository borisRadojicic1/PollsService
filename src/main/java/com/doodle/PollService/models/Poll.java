package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "ms")
    private Timestamp latestChange;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "ms")
    private Timestamp initiated;

    private Integer participantsCount;
    private Integer inviteesCount;
    private String type;
    private Integer columnConstraint;

    @Column(name = "time_zone_flag")
    private Boolean timeZone;

    private Integer rowConstraint;
    private Boolean hidden;
    private String preferencesType;
    private String state;
    private String locale;
    private String title;

    @Embedded
    private User initiator;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Embedded
    private Location location;

    @ElementCollection
    private List<PollOption> options;

    private String optionsHash;

    @ElementCollection
    private List<PollParticipant> participants;

    private Object[] invitees;
    private Boolean dateText;
    private Boolean multiDay;
    private String device;
    private String levels;

}
