@Test
public void testStartParking() {
    // Send a start parking request
    Car car = new Car("XYZ123", "Honda", "Petrol");
    ParkingStart response = restTemplate.postForObject("/parking/start?parkingNo=P1234", car, ParkingStart.class);

    assertNotNull(response);
    assertEquals("Start", response.getStatus());
    assertEquals("P1234", response.getParkingNo());
}
