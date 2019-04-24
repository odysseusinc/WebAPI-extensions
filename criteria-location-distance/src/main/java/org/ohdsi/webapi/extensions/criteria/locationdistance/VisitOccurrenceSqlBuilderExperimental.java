package org.ohdsi.webapi.extensions.criteria.locationdistance;

import org.ohdsi.circe.cohortdefinition.builders.BuilderUtils;
import org.ohdsi.circe.cohortdefinition.builders.VisitOccurrenceSqlBuilder;

import java.util.List;

public class VisitOccurrenceSqlBuilderExperimental extends VisitOccurrenceSqlBuilder<VisitOccurrence> {

    @Override
    protected List<String> resolveJoinClauses(VisitOccurrence criteria) {

        List<String> joinClauses = super.resolveJoinClauses(criteria);

        if (criteria.placeOfServiceDistance != null) {
            if (criteria.placeOfServiceLocation == null) {
                joinClauses.add(getLocationHistoryJoin("LH", "CARE_SITE", "C.care_site_id"));
            }
            joinClauses.add(getLocationHistoryJoin("personLH", "PERSON", "C.person_id"));
            joinClauses.add(
                    "JOIN @cdm_database_schema.LOCATION_DISTANCE LD on LD.person_location_id = personLH.location_id " +
                            "AND LD.care_site_location_id = LH.location_id " +
                            "AND " + BuilderUtils.buildNumericRangeClause("LD.distance", criteria.placeOfServiceDistance) + " "
            );
        }

        return joinClauses;
    }
}
