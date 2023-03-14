import java.util.Date;

public class Person {
    private String firstname;
    private String secondname;
    private String lastname;
    private Date birthday;

    public Person(String firstname, String secondname, String lastname,Date birthday) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s год рождения",this.firstname,this.secondname,this.lastname,this.birthday.toString());
    }
}
