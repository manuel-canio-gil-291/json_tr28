package es.mcg.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {
    private static ObjectMapper MAPPER;

    public static ObjectMapper mapper()
    {
        if(Json.MAPPER == null)
        {
            Json.MAPPER = Json.createJson();
        }

        return Json.MAPPER;
    }

    private static ObjectMapper createJson()
    {
        final ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

        return mapper;
    }
}
