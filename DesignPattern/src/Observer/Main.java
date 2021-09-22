package Observer;

public class Main {
    public static void main(String[] args) {
        // 建立被观察者对象
        Subject subject = new Subject();
        // 注册三个观察者
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        // 被观察者改动，发送事件通知所有观察者调用update方法
        System.out.println("First state change: 15");
        subject.setState(15);

        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
