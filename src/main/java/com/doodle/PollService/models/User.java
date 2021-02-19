package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
@JsonInclude(Include.NON_NULL)
@Table(name = "users")
public class User {

    private String name;
    private String email;
    private Boolean notify;
    private String timeZone;

}
