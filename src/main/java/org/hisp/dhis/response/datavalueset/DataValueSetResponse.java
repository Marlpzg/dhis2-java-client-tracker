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
package org.hisp.dhis.response.datavalueset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hisp.dhis.response.BaseHttpResponse;

@Getter
@Setter
@NoArgsConstructor
public class DataValueSetResponse extends BaseHttpResponse {
  @JsonProperty private Status status;

  @JsonProperty private String description;

  @JsonProperty private ImportCount importCount;

  @JsonProperty private List<Conflict> conflicts = new ArrayList<>();

  @JsonProperty private String dataSetComplete;

  /** Indicates whether an import count exists. */
  @JsonIgnore
  public boolean hasImportCount() {
    return importCount != null;
  }

  /**
   * Returns the total count including imported, updated, deleted and ignored data values.
   *
   * @return a total count.
   */
  @JsonIgnore
  private long getTotalCount() {
    return hasImportCount()
        ? (importCount.getImported()
            + importCount.getUpdated()
            + importCount.getDeleted()
            + importCount.getIgnored())
        : 0;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("status: ")
        .append(status)
        .append(", ")
        .append("description: ")
        .append(description)
        .append(", ")
        .append("importCount: ")
        .append(importCount)
        .append(", ")
        .append("conflicts: ")
        .append(conflicts)
        .append(", ")
        .append("dataSetComplete: ")
        .append(dataSetComplete)
        .append(", ")
        .append("httpStatusCode: ")
        .append(httpStatusCode)
        .toString();
  }
}
