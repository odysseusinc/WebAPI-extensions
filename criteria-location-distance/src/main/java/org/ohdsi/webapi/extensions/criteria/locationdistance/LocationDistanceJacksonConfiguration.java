package org.ohdsi.webapi.extensions.criteria.locationdistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.ohdsi.analysis.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationDistanceJacksonConfiguration {

    @Autowired
    public void extendObjectMapper(ObjectMapper objectMapper) {

        SimpleModule module = new SimpleModule();
        module.registerSubtypes(new NamedType(VisitOccurrence.class, "VisitOccurrence"));
        objectMapper.registerModule(module);

        Utils.registerObjectMapperModule(module);
    }

}
