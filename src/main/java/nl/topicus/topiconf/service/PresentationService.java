package nl.topicus.topiconf.service;

import nl.topicus.topiconf.model.Presentation;
import nl.topicus.topiconf.persistence.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    public Presentation findById(long id) {
        return this.presentationRepository.findById(id).get();
    }
}
