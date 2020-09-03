package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;
import java.util.Map;

@DynamoDBTable(tableName = "homebowdata-v2")
public class Homebowdata {

    private String mlsId;
    private String type;
    private String parking;
    private String yearBuilt;
    private double hoa;
    private String heating;
    private String cooling;
    private double priceSqft;

    @DynamoDBHashKey(attributeName = "mlsId")
    public String getMlsId() { return mlsId; }

    @DynamoDBAttribute(attributeName = "type")
    public String getType() {
        return type;
    }

    @DynamoDBAttribute(attributeName = "parking")
    public String getParking() {
        return parking;
    }

    @DynamoDBAttribute(attributeName = "yearBuilt")
    public String getYearBuilt() {
        return yearBuilt;
    }

    @DynamoDBAttribute(attributeName = "hoa")
    public double getHoa() {
        return hoa;
    }

    @DynamoDBAttribute(attributeName = "heating")
    public String getHeating() {
        return heating;
    }

    @DynamoDBAttribute(attributeName = "cooling")
    public String getCooling() {
        return cooling;
    }

    @DynamoDBAttribute(attributeName = "priceSqft")
    public double getPriceSqft() {
        return priceSqft;
    }

    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }

    public void setType(String type) { this.type = type; }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public void setPriceSqft(double priceSqft) {
        this.priceSqft = priceSqft;
    }

}

