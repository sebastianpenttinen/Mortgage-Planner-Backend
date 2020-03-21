package MortagePlan.app.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Mortage {
    @Id
    private ObjectId _id;
    private String name;
    private double amount;
    private double interest;
    private double years;

    public Mortage() {
    }

    public Mortage(ObjectId _id, String name, double amount, double interest, double years) {
        this._id = _id;
        this.name = name;
        this.amount = amount;
        this.interest = interest;
        this.years = years;
    }

    /**
     * @return the id
     */
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId _id) {
        this._id = _id;
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
    //     return String.format("Mortage[id=%s, name='%s', amount='%s', interest='%s', years='%s']", _id, name, amount,
    //             interest, years);
    // }

    public double monthlyPayment() {
        return 1000.00;
    }
}