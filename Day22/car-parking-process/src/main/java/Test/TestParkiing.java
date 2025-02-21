@Test
public void testEndParking() {
    ParkingEnd response = restTemplate.postForObject("/parking/end?regNo=XYZ123", null, ParkingEnd.class);

    assertNotNull(response);
    assertEquals("End", response.getStatus());
    assertEquals(100, response.getPrice());
}
