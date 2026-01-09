package utils;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class Utils
{
    private static final ObjectMapper objMapper = new ObjectMapper();

    public static <T> T convertObject(Object from, Class<T> to)
    {
        return objMapper.convertValue(from, to);
    }

    public static String toJson(Object from)
    {
        try {
            return objMapper.writeValueAsString(from);
        } catch (JacksonException e) {
            return "";
        }
    }
}
