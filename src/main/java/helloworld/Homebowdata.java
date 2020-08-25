package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "homebowdata")
public class Homebowdata {

    private String mlsId;
    private String name;
    private Address address;

    //primary key is propertyId
    @DynamoDBHashKey(attributeName = "mlsId")
    public String getMlsId() { return mlsId;}

    @DynamoDBAttribute(attributeName = "name")
    public String getName() { return name;}

    @DynamoDBAttribute(attributeName = "address")
    public Address getAddress() {return address;}

}
