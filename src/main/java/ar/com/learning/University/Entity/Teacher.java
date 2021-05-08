package ar.com.learning.University.Entity;

import ar.com.learning.University.Entity.Subject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@ToString
@Entity
@Table(name="Teacher")

public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @Column(nullable = false, length = 30)
        private String fullname;

        @Column(nullable = false, length = 8)
        private Long id_Teacher;

        @ManyToMany
        @JoinTable(name = "docente_x_curso", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
        private List<Subject> cursosQueDicta;
        @OneToOne(mappedBy = "teacher")
        private AdminPlace admin;


    }

