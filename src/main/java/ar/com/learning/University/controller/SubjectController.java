package ar.com.learning.University.controller;

import ar.com.learning.University.model.entity.Subject;
import ar.com.learning.University.service.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SubjectController {
    @Autowired
    SubjectServices subjectService;

    @PostMapping("/api/subject")
    public ResponseEntity<GenericResponse> ingresarsubject(@RequestBody SubjectRequest subjectReq) {
        Subject subject= new Subject();
        subject  = subjectService.ingresarsubject(subjectReq.nombre, subjectReq.categoriasId, cursoReq.duracionHoras);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.message = "Curso creado con éxito";
        gR.id = curso.getCursoId();
        return ResponseEntity.ok(gR);
    }
}
