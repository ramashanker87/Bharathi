package com.rama.app;

import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result=calculator.add(3,4);
    assert result==7;
  }
  @Test
  public void testSubtract() {
    Calculator calculator = new Calculator();mvn archetype:generate -DgroupId=com.rama.Bharathi -DartifactId=simple-calculator-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

    double result = calculator.subtract(9,5);
    assert result==4;
  }
  @Test
  public void testMultiply() {
    Calculator calculator = new Calculator();
    double result= calculator.multiply(5,6);
    assert result==30;
  }

}
