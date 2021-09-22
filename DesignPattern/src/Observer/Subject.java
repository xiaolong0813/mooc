package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }
    // 设置state，并通知观察者获取此state
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    // 注册观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }
    // 通知所有观察者调用update
    public void notifyAllObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
