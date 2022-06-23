package ui.UIOperations;

import ui.status.UIStatusController;

public class UIOperations implements UIOPerationsInterface{
    private final UIStatusController uiStatus = new UIStatusController();
    public final UIStatusController getStatusController(){
        return uiStatus;
    }

    public void init(){};
    public void userInput(){};
    public void recall(){};
}
