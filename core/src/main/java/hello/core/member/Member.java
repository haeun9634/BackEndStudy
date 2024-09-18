package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grande;

    public Member(Long id, String name, Grade grande) {
        this.id = id;
        this.name = name;
        this.grande = grande;
    }

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

    public Grade getGrande() {
        return grande;
    }

    public void setGrande(Grade grande) {
        this.grande = grande;
    }
}
