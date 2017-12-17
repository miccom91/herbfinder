package pl.blaszczak.herbfinder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.blaszczak.herbfinder.domain.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
}
