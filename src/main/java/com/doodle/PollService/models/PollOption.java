package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Embeddable
@JsonInclude(Include.NON_NULL)
public class PollOption {

    private String text;
    private Timestamp start;
    @Column(name = "option_end")
    private Timestamp end;
    private Boolean allday;
    private Timestamp date;
    private Timestamp dateTime;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Boolean available;

}
