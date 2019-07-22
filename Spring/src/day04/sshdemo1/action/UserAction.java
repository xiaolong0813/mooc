package day04.sshdemo1.action;

import com.opensymphony.xwork2.ActionSupport;
import day04.sshdemo1.service.UserService;

public class UserAction extends ActionSupport {

    private UserService service;

    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("action.....");
        // 调用service方法
//        service.add();
        service.find();
        // 这里没有返回值，即不给前端页面发送响应
        return NONE;
    }


}
