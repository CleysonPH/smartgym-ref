package br.com.treinaweb.smartgym.core.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

@SuppressWarnings("rawtypes")
public class HttpServletRequestUtils {

    public static Long getLongPathVariable(String pathVariable) {
        var object = getAttributesFromHttpServletRequest();
        if (object instanceof Map) {
            var attributes = (Map) object;
            if (attributes.containsKey(pathVariable)) {
                var attribute = attributes.get(pathVariable);
                return Long.parseLong(attribute.toString());
            }
        }
        return null;
    }

    private static HttpServletRequest getHttpServletRequest() {
        var attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }

    private static Object getAttributesFromHttpServletRequest() {
        return getHttpServletRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    }

}
