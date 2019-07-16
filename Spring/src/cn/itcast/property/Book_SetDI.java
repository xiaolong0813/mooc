package cn.itcast.property;

public class Book_SetDI {

    private String bookname;

    // 这里用set方法进行属性的注入
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    // 测试
    public void demobook() {
        System.out.println("book with set DI " + bookname);
    }
}
