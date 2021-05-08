package ar.com.learning.University.Entity;

import ar.com.learning.University.Entity.Registration;
import ar.com.learning.University.Entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "User")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long user_id;
    private String username;
    private String password;

    @Column(name = "type_user_id")
    private TypeUserEnum typeUserId;

    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "adminPlace_id", referencedColumnName = "adminPlace_id")
    private AdminPlace.admin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Registration> inscriptions;

    public enum TypeUserEnum {
        Admin(1), Student(2);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private TypeUserEnum(Integer value) {
            this.value = value;
        }

    }
}
