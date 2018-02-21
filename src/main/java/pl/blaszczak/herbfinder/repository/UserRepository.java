package pl.blaszczak.herbfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.blaszczak.herbfinder.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);                   //select * from users where name like name;
    User findByName(String name);
}
