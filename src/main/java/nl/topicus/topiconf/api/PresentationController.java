package nl.topicus.topiconf.api;

import nl.topicus.topiconf.model.Presentation;
import nl.topicus.topiconf.persistence.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presentations")
public class PresentationController {

    @Autowired
    private PresentationRepository repository;

    @PostMapping
    public ResponseEntity<Presentation> save(@RequestBody Presentation presentation) {

        return ResponseEntity.ok(this.repository.save(presentation));

    }

    @GetMapping()
    public ResponseEntity<Iterable<Presentation>> list() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Presentation> findById(@PathVariable long id) {
        return ResponseEntity.ok(this.repository.findById(id).get());
    }
}
