package MortagePlan.app.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about a mortage")
public class Mortage {
    
    @Id
    @ApiModelProperty(notes="The unique id of the mortage")
    private ObjectId id;

    @ApiModelProperty(notes="Name of the mortage holder")
    private String name;

    @ApiModelProperty(notes="The amount of the mortage")
    private double amount;

    @ApiModelProperty(notes="The interest on the mortage")
    private double interest;

    @ApiModelProperty(notes="How many years the mortage is for")
    private double years;

    public Mortage() {
    }

    public Mortage(ObjectId id, String name, double amount, double interest, double years) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.interest = interest;
        this.years = years;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the years
     */
    public double getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(double years) {
        this.years = years;
    }

    // @Override
    // public String toString() {
    //     return String.format("Mortage[id=%s, name='%s', amount='%s', interest='%s', years='%s']", id, name, amount,
    //             interest, years);
    // }

    public double monthlyPayment() {
        return 1000.00;
    }
}