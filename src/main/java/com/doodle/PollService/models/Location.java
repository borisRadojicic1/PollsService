package com.doodle.PollService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "locations")
public class Location {

    @Column(name = "location_name")
    private String name;

    @Column(name = "location_address")
    private String address;

    private String countryCode;
    private String locationId;

}
