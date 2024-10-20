package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {//jpa가 관리하는 엔티티가 됨

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK설정하고, Generate는 쿼리에 id 안넣어도 자동으로 생성되는거 아이덴티티 전략.
    private Long id;//데이터를 구분하기 위해서 시스템이 정하는 id

    //@Column(name = "username") //만약 db컬럼명이 username이면 이런식으로 설정
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
