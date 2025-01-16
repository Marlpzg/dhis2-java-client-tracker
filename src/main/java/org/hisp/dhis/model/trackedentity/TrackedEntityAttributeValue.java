package org.hisp.dhis.model.trackedentity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class TrackedEntityAttributeValue implements Serializable {

    @ToString.Include @JsonProperty private String attribute;

    @ToString.Include @JsonProperty private String value;

    @JsonProperty private Date createdAt;

    @JsonProperty private Date updatedAt;

    @JsonProperty private String storedBy;
}
