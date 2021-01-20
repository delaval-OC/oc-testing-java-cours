package com.openclassrooms.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FormattedServiceTest {


  private FormattedService classUnderTest;

  @BeforeEach
  public void init() {
    classUnderTest = new FormattedServiceImpl();
  }

  @Test
  public void format_shouldReturnFormattedSolution_forAnyBigInteger() {
    // GIVEN
    int solution = 123000;

    // WHEN
    String response = classUnderTest.format(solution);

    // THEN

    assertThat(response).isEqualTo("123 000");
  }

}
