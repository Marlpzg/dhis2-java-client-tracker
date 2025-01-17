/*
 * Copyright (c) 2004-2024, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.hisp.dhis.model.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hisp.dhis.model.event.Events;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Enrollment implements Serializable {
  @EqualsAndHashCode.Include
  @ToString.Include
  @JsonProperty(value = "enrollment")
  private String id;

  @JsonProperty private String program;

  @ToString.Include @JsonProperty private String trackedEntity;

  @JsonProperty private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

  @ToString.Include @JsonProperty private String orgUnit;

  @ToString.Include @JsonProperty private String orgUnitName;

  @JsonProperty private Date createdAt;

  @JsonProperty private Date createdAtClient;

  @JsonProperty private Date updatedAt;

  @JsonProperty private Date updatedAtClient;

  @JsonProperty private Date enrolledAt;

  @JsonProperty private Date occurredAt;

  @JsonProperty private Date completedAt;

  @ToString.Include @JsonProperty private String completedBy;

  @JsonProperty private Boolean followUp;

  @JsonProperty private Boolean deleted;

  //TODO geometry GeoJson

  @JsonProperty private String storedBy;

  //TODO atributes List<TrackedEntityAttributeValue>

  private Events events;

  //TODO relationships List<Relationship>

  //TODO notes

  public Enrollment(String id) {
    this.id = id;
  }

  public Enrollment(
      String id,
      String program,
      String orgUnit,
      Date occurredAt) {
    this(id);
    this.program = program;
    this.orgUnit = orgUnit;
    this.occurredAt = occurredAt;
  }

}
