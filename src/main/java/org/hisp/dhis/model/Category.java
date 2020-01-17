package org.hisp.dhis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Category
    extends NameableObject
{
    @JsonProperty
    private DataDimensionType dataDimensionType;

    @JsonProperty
    private Boolean dataDimension;

    @JsonIgnore
    public boolean isDataDimension()
    {
        return dataDimension;
    }

    public DataDimensionType getDataDimensionType()
    {
        return dataDimensionType;
    }

    public void setDataDimensionType( DataDimensionType dataDimensionType )
    {
        this.dataDimensionType = dataDimensionType;
    }

    public Boolean getDataDimension()
    {
        return dataDimension;
    }

    public void setDataDimension( Boolean dataDimension )
    {
        this.dataDimension = dataDimension;
    }
}