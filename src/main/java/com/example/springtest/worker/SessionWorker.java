package com.example.springtest.worker;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class SessionWorker {

    public void setSessionAttr(HttpServletRequest request, String attrKey, Object attrValue) {
        Map<String, Object> sessionMap = getSessionScope(request);
        if (getSessionScope(request) == null)
            sessionMap = new HashMap<>();
        sessionMap.put(attrKey, attrValue);
        request.getSession().setAttribute("sessionScope", sessionMap);


    }

    public Map<String, Object> getSessionScope(HttpServletRequest request) {
        Object sessionScope = request.getSession().getAttribute("sessionScope");
        if (sessionScope == null)
            return null;
        if (sessionScope instanceof HashMap<?, ?>)
            return (HashMap<String, Object>) sessionScope;
        return null;
    }
}
