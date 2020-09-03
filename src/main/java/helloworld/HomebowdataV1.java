package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomebowdataV1 {

    private String mlsId;
    private Object showingContactPhone;
    private Object terms;
    private Object showingInstructions;
    private Object leaseTerm;

    private Object disclaimer;
    private Integer originalListPrice;
    private Object agreement;
    private Date listDate;
    private Date modified;
    private Object[] photos;
    private Integer listPrice;
    private Object internetAddressDisplay;
    private String listingId;
    private Object internetEntireListingDisplay;
    private String leaseType;
    private URL virtualTourUrl;
    private String remarks;

    private List<Map<String, Object>> parking;


    @DynamoDBHashKey(attributeName = "mlsId")
    public String getMlsId() {
        return this.mlsId;
    }

    @DynamoDBAttribute(attributeName = "getShowingContactPhone")
    public Object getShowingContactPhone () {
        return this.showingContactPhone;
    }

    @DynamoDBAttribute(attributeName = "terms")
    public Object getTerms () {
        return this.terms;
    }

    @DynamoDBAttribute(attributeName = "showingInstructions")
    public Object getShowingInstructions () {
        return this.showingInstructions;
    }

    @DynamoDBAttribute(attributeName = "leaseTerm")
    public Object getLeaseTerm() {
        return leaseTerm;
    }

    @DynamoDBAttribute(attributeName = " ")
    public Object getDisclaimer() {
        return disclaimer;
    }

    @DynamoDBAttribute(attributeName = "originalListPrice")
    public Integer getOriginalListPrice() {
        return originalListPrice;
    }

    @DynamoDBAttribute(attributeName = "agreement")
    public Object getAgreement() {
        return agreement;
    }

    @DynamoDBAttribute(attributeName = "listDate")
    public Date getListDate() {
        return listDate;
    }

    @DynamoDBAttribute(attributeName = "modified")
    public Date getModified() {
        return modified;
    }

    @DynamoDBAttribute(attributeName = "photos")
    public Object[] getPhotos() {
        return photos;
    }

    @DynamoDBAttribute(attributeName = "listPrice")
    public Integer getListPrice() {
        return listPrice;
    }

    @DynamoDBAttribute(attributeName = "internetAddressDisplay")
    public Object getInternetAddressDisplay() {
        return internetAddressDisplay;
    }

    @DynamoDBAttribute(attributeName = "listingId")
    public String getListingId() {
        return listingId;
    }

    @DynamoDBAttribute(attributeName = "internetEntireListingDisplay")
    public Object getInternetEntireListingDisplay() {
        return internetEntireListingDisplay;
    }

    @DynamoDBAttribute(attributeName = "leaseType")
    public String getLeaseType() {
        return leaseType;
    }

    @DynamoDBAttribute(attributeName = "virtualTourUrl")
    public URL getVirtualTourUrl() {
        return virtualTourUrl;
    }

    @DynamoDBAttribute(attributeName = "remarks")
    public String getRemarks() {
        return remarks;
    }

    @DynamoDBAttribute(attributeName = "parking")
    @DynamoDBTypeConvertedJson
    public List<Map<String, Object>> getParking() {
        return parking;
    }






    //setters
    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }

    public void setShowingContactPhone(Object showingContactPhone) {
        this.showingContactPhone = showingContactPhone;
    }

    public void setTerms(Object terms) {
        this.terms = terms;
    }

    public void setShowingInstructions(Object showingInstructions) {
        this.showingInstructions = showingInstructions;
    }

    public void setLeaseTerm(Object leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public void setDisclaimer(Object disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setOriginalListPrice(Integer originalListPrice) {
        this.originalListPrice = originalListPrice;
    }

    public void setAgreement(Object agreement) {
        this.agreement = agreement;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setPhotos(Object[] photos) {
        this.photos = photos;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public void setInternetAddressDisplay(Object internetAddressDisplay) {
        this.internetAddressDisplay = internetAddressDisplay;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public void setInternetEntireListingDisplay(Object internetEntireListingDisplay) {
        this.internetEntireListingDisplay = internetEntireListingDisplay;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public void setVirtualTourUrl(URL virtualTourUrl) {
        this.virtualTourUrl = virtualTourUrl;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
