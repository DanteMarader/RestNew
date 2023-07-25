package TestRestProj.RestNew.repositories;

import TestRestProj.RestNew.entity.Animal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findAllById(Long id);
}
