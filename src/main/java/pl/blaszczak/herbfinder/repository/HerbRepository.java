package pl.blaszczak.herbfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.blaszczak.herbfinder.domain.Herb;

@Repository
public interface HerbRepository extends JpaRepository<Herb, Integer> {
}
