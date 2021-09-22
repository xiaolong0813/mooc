package Observer;

// 需要
public abstract class Observer {
    // 观察者类需要有一个subject，即被观察者，用于注册自身
    protected Subject subject;
    // 被通知的时候所进行的操作
    public abstract void update();
}
