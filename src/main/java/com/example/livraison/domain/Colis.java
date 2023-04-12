package main.java.com.example.livraison;

public class Colis {
    private String originAddress;
    private String destinationAddress;
    private double weight;
    
    public Colis(String originAddress, String destinationAddress, double weight, Int trackingNumber) {
        this.trackingNumber = trackingNumber;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.weight = weight;
    }
    
    public String getOriginAddress() {
        return originAddress;
    }
    
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
    
    public String getDestinationAddress() {
        return destinationAddress;
    }
    
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public int setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

}