package MortagePlan.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.bson.types.ObjectId;

import MortagePlan.app.models.Mortage;
import MortagePlan.app.repositories.MortageRepository;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/mortages")
public class MortageController {
    @Autowired
    private MortageRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Mortage> getAllMortages() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mortage getMortageById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMortageById(@PathVariable("id") ObjectId id, @Valid @RequestBody Mortage mortage) {
        mortage.setId(id);
        repository.save(mortage);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Mortage createMortage(@Valid @RequestBody Mortage mortage) {
        mortage.setId(ObjectId.get());
        repository.save(mortage);
        return mortage;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMortage(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }

}
