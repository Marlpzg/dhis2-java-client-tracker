package org.hisp.dhis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GeoJson {

    @JsonProperty String type;

    @JsonProperty List<Double> coordinates;
}
