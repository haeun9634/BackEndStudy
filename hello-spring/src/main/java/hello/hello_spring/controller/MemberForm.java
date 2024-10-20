package hello.hello_spring.controller;

public class MemberForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }//private라 바로 접근 못해서 setName을 통해 값을 넣어주고
    // 그 name을 getName으로 꺼냄


}
