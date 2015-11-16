package annakr;

public class User {

    private String name;

    private Integer age;

    private Integer sequenceNumber;

    public User(String name, Integer age, Integer sequenceNumber) {
        this.name = name;
        this.age = age;
        this.sequenceNumber = sequenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
