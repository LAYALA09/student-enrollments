package ar.com.learning.University.service;

import ar.com.learning.University.Entity.Subject;
import ar.com.learning.University.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    CategoryService categoryService;


    public boolean cargarmateria(Subject subject) {
        if (subjectRepository.existsByNombre(subject.getSubject()))
            return false;
        subjectRepository.save(subject);
        return true;
    }

    public Subject cargarmateria(String subject, List<Long> categoryId) {
        Subject subject=new Subject();
        subject.setSubject(subject);
        subject.agregarCategory(categoryService.buscarPorIds(categoryId));
        subject.setDuracionHoras(duracionHoras);
        // llamo al metodo
        boolean subCreado = crearCurso(curso);
        if (cursoCreado)
            return curso;
        else
            return null;
    }
    }
