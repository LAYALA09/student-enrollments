package ar.com.learning.University.component;

import ar.com.learning.University.exception.BusinessLogicException;
import ar.com.learning.University.exception.EntityError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogicExceptionComponent {

    public RuntimeException getExceptionEntityNotFound(String entity, Long id) {

        EntityError entityError = new EntityError(
                entity,
                "The " + entity + " with id '" + id + "' does not exist"
        );

        return new BusinessLogicException(
                "Entity does not exist",
                HttpStatus.NOT_FOUND,
                entityError
        );
    }

    public RuntimeException getExceptionEntityEmptyValues(String entity) {

        EntityError entityError = new EntityError(
                entity,
                "cannot update the entity with null or empty values"
        );

        return new BusinessLogicException(
                "Entity with invalid data",
                HttpStatus.BAD_REQUEST,
                entityError
        );
    }
}
