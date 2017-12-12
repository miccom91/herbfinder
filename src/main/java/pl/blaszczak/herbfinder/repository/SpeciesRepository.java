package pl.blaszczak.herbfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.blaszczak.herbfinder.domain.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

}
