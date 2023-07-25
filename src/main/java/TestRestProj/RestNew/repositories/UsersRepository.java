package TestRestProj.RestNew.repositories;

import TestRestProj.RestNew.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findAllByEmail(String email);
}
