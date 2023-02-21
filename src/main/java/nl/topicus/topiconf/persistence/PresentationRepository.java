package nl.topicus.topiconf.persistence;

import nl.topicus.topiconf.model.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long> {

}
