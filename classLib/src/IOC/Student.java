package IOC;

public class Student {
    private String name;
    private Integer score;

    private Integer getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

