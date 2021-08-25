package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Pattern(regexp = "^[a-zA-Z]+$" , message = "ten khong dc co so")
    private String name;
    private Date DoB;
    @Pattern(regexp = "^[0-9]{0,10}+$" , message = "phone phai co 10 so")
    private String phone;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$",message = "sai pattern")
    private String email;
    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(long id, String name, Date doB, String phone, String email, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        DoB = doB;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DoB=" + DoB +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", classRoom=" + classRoom +
                '}';
    }
}
