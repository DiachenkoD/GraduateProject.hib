package com.level.controllers;

import com.level.manager.DescriptionManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class DescriptionServlet extends APIHandlerServlet.APIRequestHandler {
    public static final DescriptionServlet instance = new DescriptionServlet();


    public static DescriptionServlet getInstance() {
        return instance;
    }

    private DescriptionServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        String type = map.get("type")[0];
        // Map<String, String> dataFromDb = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        switch (type) {
            case "add_Comment": jsonObject = changeDescription(map); break;
            case "": break;

        }

        return  jsonObject;

    }

    private JSONObject changeDescription(Map<String, String[]> map){
        JSONObject jsonObject = new JSONObject();
        try {
            DescriptionManager.getDescriptionManager().changeDescription(map);
        } catch (Exception e) {
            jsonObject.put("State", "Error! Can't add comment!");
            return jsonObject;
        }
        jsonObject.put("State", "The comment was added!");
        return jsonObject;
    }

}
