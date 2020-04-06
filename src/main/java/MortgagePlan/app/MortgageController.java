package MortgagePlan.app;

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

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/mortgages")
public class MortgageController {
    @Autowired
    private MortgagePlan.app.repositories.MortgageRepository repository;

    @ApiOperation(value= "Gets all mortgages",notes = "Call this endpoint to get all the mortgages",response = MortgagePlan.app.models.Mortgage.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<MortgagePlan.app.models.Mortgage> getAllMortgages() {
        return repository.findAll();
    }

    @ApiOperation(value= "Finds mortgage by id",notes = "Provide an id to lookup a specific mortgage",response = MortgagePlan.app.models.Mortgage.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MortgagePlan.app.models.Mortgage getMortgageById(@ApiParam(value= "ID value for the mortgage you need to retrieve", required = true)
     @PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @ApiOperation(value= "Finds mortgage by id",notes = "Provide an id to lookup a mortgages monthly payment")
    @RequestMapping(value = "monthly_payment/{id}", method = RequestMethod.GET)
    public double getMonthlyPayment(@ApiParam(value = "ID for the mortgage you want the monthy payment of", required = true)
    @PathVariable("id") ObjectId id){
        MortgagePlan.app.models.Mortgage mortgage =  repository.findById(id);
        return mortgage.monthlyPayment();
    }

    @ApiOperation(value= "Edit mortgage by id",notes = "Provide id and body specifying the change to change a mortgage")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MortgagePlan.app.models.Mortgage modifyMortgageById(@ApiParam(value= "ID value for the mortgage you need to edit", required = true)
    @PathVariable("id") ObjectId id, @Valid @RequestBody MortgagePlan.app.models.Mortgage mortgage) {
        mortgage.setId(id);
        mortgage.setMonthlyPayment();
        repository.save(mortgage);
        return mortgage;
    }

    @ApiOperation(value= "Create a mortgage",notes = "Create a Post request to this endpoint to create a mortgage",response = MortgagePlan.app.models.Mortgage.class)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public MortgagePlan.app.models.Mortgage createMortgage(@Valid @RequestBody MortgagePlan.app.models.Mortgage mortgage) {
        mortgage.setId(ObjectId.get());
        mortgage.setMonthlyPayment();
        repository.save(mortgage);
        return mortgage;
    }
    @ApiOperation(value= "Delete mortgage by id",notes = "Provide id to delete a specific mortgage ")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMortgage(@ApiParam(value= "ID value for the mortgage you need to delete", required = true)
    @PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }

}
