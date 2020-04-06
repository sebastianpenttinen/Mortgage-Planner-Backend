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

    private double monthlyPayment;

    public Mortage() {
    }

    public Mortage(ObjectId id, String name, double amount, double interest, double years) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.interest = interest;
        this.years = years;
        this.monthlyPayment = 0.0;
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

    /**
     * @return the monthlyPayment
     */
    public double getMonthlyPayment(){
        return monthlyPayment;
    }

    public void setMonthlyPayment(){
        this.monthlyPayment = monthlyPayment();
    }
    /*
      Set the monthly payment according to this formula:

     */
    public double monthlyPayment() {
        // Divide by 100 to get in decimal , then divide by 12 for the monthly interest
        double monthlyInterest = (this.interest / 100) / 12.0;
        return this.amount * ((monthlyInterest * pow(( 1 + monthlyInterest),  this.years * 12))) / (pow((1 + monthlyInterest), this.years * 12) -1);
    }

    public double pow(double base, double power){
    if(power == 0) return 1;
    return base * pow(base, --power);
    }
}