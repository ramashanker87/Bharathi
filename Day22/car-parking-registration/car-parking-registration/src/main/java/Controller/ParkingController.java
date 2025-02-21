import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        // Logic to start parking and send to SQS
        ParkingStart parkingStart = new ParkingStart();
        parkingStart.setParkingNo(parkingNo);
        parkingStart.setStartTime(new Date());
        parkingStart.setStatus("Start");
        parkingStart.setRegNo(car.getRegNo());
        return parkingStart;
    }

    @PostMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        // Logic to fetch data from SQS and calculate the price
        ParkingEnd parkingEnd = new ParkingEnd();
        // Assuming we have fetched the parking start data from DynamoDB
        Date startTime = new Date();  // Sample StartTime
        Date endTime = new Date();  // Sample EndTime
        long diffInMillies = endTime.getTime() - startTime.getTime();
        long diffMinutes = diffInMillies / (60 * 1000);
        parkingEnd.setPrice((int)(diffMinutes * 2)); // Rs 2 per minute
        parkingEnd.setParkingNo("P1234");
        parkingEnd.setStartTime(startTime);
        parkingEnd.setEndTime(endTime);
        parkingEnd.setStatus("End");
        parkingEnd.setRegNo(regNo);
        return parkingEnd;
    }
}

