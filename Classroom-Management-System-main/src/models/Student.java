package models;

public class Student {
    private String id;
    private String name;
    private String dob;
    private String age;
    private String address;
    private String bloodGroup;

    public Student(String id, String name, String dob, String age, String address, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
