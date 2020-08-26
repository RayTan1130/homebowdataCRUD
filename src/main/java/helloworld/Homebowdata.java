package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "homebowdata-v1")
public class Homebowdata {

    private String mlsId;
    private String name;
    private String type;
//    private Address address;

    //primary key is propertyId
    @DynamoDBHashKey(attributeName = "mlsId")
    public String getMlsId() { return mlsId;}

    @DynamoDBAttribute(attributeName = "name")
    public String getName() { return name;}

    @DynamoDBAttribute(attributeName = "type")
    public String getType() { return type;}

//    @DynamoDBAttribute(attributeName = "address")
//    public Address getAddress() {return address;}

    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
//    public void setAddress(Address address) {
//        this.address = address;
//    }
}
