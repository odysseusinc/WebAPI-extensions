package org.ohdsi.webapi.extensions.criteria.locationdistance;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.ohdsi.circe.cohortdefinition.IGetCriteriaSqlDispatcher;
import org.ohdsi.circe.cohortdefinition.NumericRange;

public class VisitOccurrence extends org.ohdsi.circe.cohortdefinition.VisitOccurrence {

    @JsonProperty("PlaceOfServiceDistance")
    public NumericRange placeOfServiceDistance;

    @Override
    public String accept(IGetCriteriaSqlDispatcher dispatcher) {

        return new VisitOccurrenceSqlBuilderExperimental().getCriteriaSql(this);
    }
}