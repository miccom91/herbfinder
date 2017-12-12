package pl.blaszczak.herbfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.blaszczak.herbfinder.domain.Herb;

public interface HerbRepository extends JpaRepository<Herb, Integer> {
}
