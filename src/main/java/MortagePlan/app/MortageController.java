package MortagePlan.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value= "Gets all mortages",notes = "Call this endpoint to get all the mortages",response = Mortage.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Mortage> getAllMortages() {
        return repository.findAll();
    }

    @ApiOperation(value= "Finds mortage by id",notes = "Provide an id to lookup a specific mortage",response = Mortage.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mortage getMortageById(@ApiParam(value= "ID value for the mortage you need to retrieve", required = true)
     @PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @ApiOperation(value= "Finds mortage by id",notes = "Provide an id to lookup a mortages monthly payment")
    @RequestMapping(value = "monthly_payment/{id}", method = RequestMethod.GET)
    public double getMonthlyPayment(@ApiParam(value = "ID for the mortage you want the monthy payment of", required = true)
    @PathVariable("id") ObjectId id){
        Mortage mortage =  repository.findById(id);
        return mortage.monthlyPayment();
    }

    @ApiOperation(value= "Edit mortage by id",notes = "Provide id and body specifying the change to change a mortage")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Mortage modifyMortageById(@ApiParam(value= "ID value for the mortage you need to edit", required = true)
    @PathVariable("id") ObjectId id, @Valid @RequestBody Mortage mortage) {
        mortage.setId(id);
        mortage.setMonthlyPayment();
        repository.save(mortage);
        return mortage;
    }

    @ApiOperation(value= "Create a mortage",notes = "Create a Post request to this endpoint to create a mortage",response = Mortage.class)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Mortage createMortage(@Valid @RequestBody Mortage mortage) {
        mortage.setId(ObjectId.get());
        mortage.setMonthlyPayment();
        repository.save(mortage);
        return mortage;
    }
    @ApiOperation(value= "Delete mortage by id",notes = "Provide id to delete a specific mortage ")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMortage(@ApiParam(value= "ID value for the mortage you need to delete", required = true)
    @PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }

}
