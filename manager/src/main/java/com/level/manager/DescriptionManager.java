package com.level.manager;

import com.level.entity.GameFull;
import com.level.factory.Factory;

import java.sql.SQLException;
import java.util.Map;

public class DescriptionManager {
    private static DescriptionManager instance = null;

    public static DescriptionManager getDescriptionManager() {
        if (instance == null) {
            instance = new DescriptionManager();
        }
        return instance;
    }
    public void changeDescription(Map<String, String[]> mapParam) throws Exception {

        int id = Integer.parseInt(mapParam.get("index")[0]);
        GameFull currentCame = null;
        Factory<GameFull> gameFullFactory = new Factory<GameFull>();
        try {
            currentCame = gameFullFactory.getInstance().getCommunDAO().getObjectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't Find user!");
            throw new Exception();
        }
        String descriptionText = mapParam.get("commentText")[0];
        String dateStr = mapParam.get("date")[0];
        GameFull descriptionGameFull = new GameFull();

       // Date date = Date.valueOf(dateStr);
        descriptionGameFull.setDescription(descriptionText);
       // comments.setDateComment(date);
    }

}
