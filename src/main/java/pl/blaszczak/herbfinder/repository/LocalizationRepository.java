package pl.blaszczak.herbfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.blaszczak.herbfinder.domain.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Integer> {
}