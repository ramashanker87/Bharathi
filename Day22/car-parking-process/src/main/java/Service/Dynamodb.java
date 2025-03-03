@Service
public class DynamoDBService {

    // Methods to interact with DynamoDB
    public void saveParkingStart(ParkingStart parkingStart) {
        // Save ParkingStart to DynamoDB
    }

    public void saveParkingEnd(ParkingEnd parkingEnd) {
        // Save ParkingEnd to DynamoDB
    }

    public ParkingStart getParkingStartByRegNo(String regNo) {
        // Fetch ParkingStart from DynamoDB
        return new ParkingStart(); // Mock return for simplicity
    }
}
4. Custom Exceptions
java
        Copy
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}

public class ParkingNotFoundException extends RuntimeException {
    public ParkingNotFoundException(String message) {
        super(message);
    }
}