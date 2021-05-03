package ar.com.learning.University.repository;

import ar.com.learning.University.model.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career,Long> {

}
