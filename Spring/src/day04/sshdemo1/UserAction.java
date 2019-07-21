package day04.sshdemo1;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("action.....");
        // 这里没有返回值，前端页面收不到响应
        return super.execute();
    }
}
