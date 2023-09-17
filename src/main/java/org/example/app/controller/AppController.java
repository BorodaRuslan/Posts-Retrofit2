package org.example.app.controller;

import org.example.app.model.AllPostsModel;
import org.example.app.model.PostByIdModel;
import org.example.app.utils.Constants;
import org.example.app.view.AppView;
import org.example.app.view.UserIdView;

public class AppController {
    private final AllPostsModel modelAll;
    private final PostByIdModel modelID;
    private final AppView appView;
    private final UserIdView idView;

    public AppController(AllPostsModel modelAll, PostByIdModel modelID, AppView appView, UserIdView idView) {
        this.modelAll = modelAll;
        this.modelID = modelID;
        this.appView = appView;
        this.idView = idView;
    }
    public static void runApp(){
        AllPostsModel modelAll = new AllPostsModel();
        PostByIdModel modelID = new PostByIdModel();
        AppView appView1 = new AppView();
        UserIdView byIdView = new UserIdView();

        AppController appController = new AppController(modelAll, modelID, appView1, byIdView);

        appController.filterOptions(appView1.getMenu());
    }

    public void filterOptions(int choice){
        switch (choice){
            case 1 -> appView.getOutput(modelAll.showAllPosts());
            case 2 -> appView.getOutput(modelID.showPostForId(idView.getData()));
            case 0 -> appView.getOutput(Constants.APP_CLOSED);
            default -> appView.getOutput("Unexpected value:" + choice);
        }
    }
}
