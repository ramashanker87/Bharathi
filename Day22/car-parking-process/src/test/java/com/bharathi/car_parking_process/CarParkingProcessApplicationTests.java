package com.bharathi.car_parking_process;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;

@Service
public class ParkingService {
	private final AmazonSQS amazonSQS;
	private final String startQueueUrl;
	private final String endQueueUrl;

	public ParkingService(AmazonSQS amazonSQS) {
		this.amazonSQS = amazonSQS;
		this.startQueueUrl = "your-start-queue-url";
		this.endQueueUrl = "your-end-queue-url";
	}

	// Method to listen to the start request
	public void handleParkingStart(ParkingStart parkingStart) {
		// Send message to the parking start request queue
		SendMessageRequest startMessage = new SendMessageRequest()
				.withQueueUrl(startQueueUrl)
				.withMessageBody(new Gson().toJson(parkingStart));
		amazonSQS.sendMessage(startMessage);
	}

	// Method to handle parking end
	public void handleParkingEnd(String regNo) {
		// Fetch start data from DynamoDB, calculate price, and send to parking-end-response queue
		// Logic to calculate price and prepare parking end response

		ParkingEnd parkingEnd = new ParkingEnd();
		parkingEnd.setRegNo(regNo);
		parkingEnd.setPrice(100);  // Example price
		parkingEnd.setStatus("End");

		// Send to the response queue
		SendMessageRequest endMessage = new SendMessageRequest()
				.withQueueUrl(endQueueUrl)
				.withMessageBody(new Gson().toJson(parkingEnd));
		amazonSQS.sendMessage(endMessage);
	}
}
