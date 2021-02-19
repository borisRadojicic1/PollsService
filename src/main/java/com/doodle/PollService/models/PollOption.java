package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Embeddable
@JsonInclude(Include.NON_NULL)
@Table(name = "poll_options")
public class PollOption {

    private String text;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp start;

    @Column(name = "option_end")
    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp end;

    @Column(name = "all_day")
    private Boolean allday;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp date;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp dateTime;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp startDate;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp endDate;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp startDateTime;

    @JsonFormat(shape = Shape.NUMBER_INT, pattern = "ms")
    private Timestamp endDateTime;

    private Boolean available;

}
