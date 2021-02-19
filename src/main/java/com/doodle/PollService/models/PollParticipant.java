package com.doodle.PollService.models;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@Embeddable
@Table(name = "poll_participants")
public class PollParticipant {

    private Long id;
    private String name;
    private Integer[] preferences;

}
