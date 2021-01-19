package com.openclassrooms.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.openclassrooms.testing.calcul.domain.Calculator;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;
import com.openclassrooms.testing.calcul.domain.model.CalculationType;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

  @Mock
  Calculator calculator;

  @Mock
  FormattedService solutionFormatter;

  CalculatorService classUnderTest;

  @BeforeEach
  public void init() {
    classUnderTest = new CalculatorServiceImpl(calculator, solutionFormatter);
  }

  @Test
  public void calculate_shouldUseCalculator_ForAddition() {
    // GIVEN
    when(calculator.add(1, 2)).thenReturn(3);

    // WHEN
    final int result = classUnderTest
        .calculate(new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

    // THEN
    verify(calculator).add(1, 2);
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void calulate_shouldUseCalculator_forMultiply() {
    // GIVEN
    when(calculator.multiply(1, 2)).thenReturn(2);

    // WHEN
    int result = classUnderTest
        .calculate(new CalculationModel(CalculationType.MULTIPLICATION, 1, 2)).getSolution();

    // THEN
    verify(calculator).multiply(1, 2);
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void calculate_shouldUseCalculator_forDivide() {
    // GIVEN
    when(calculator.divide(6, 2)).thenReturn(3);

    // WHEN

    int result = classUnderTest.calculate(new CalculationModel(CalculationType.DIVISION, 6, 2))
        .getSolution();

    // THEN

    verify(calculator).divide(6, 2);
    assertThat(result).isEqualTo(3);

  }

  @Test
  public void calculate_shouldFormatSolution_forAnAddition() {
    // GIVEN
    when(calculator.add(10000, 3000)).thenReturn(13000);
    when(solutionFormatter.format(13000)).thenReturn("13 000");

    // WHEN
    final String formatterResult =
        classUnderTest.calculate(new CalculationModel(CalculationType.ADDITION, 10000, 3000))
            .getFormattedSolution();

    // THEN
    assertThat(formatterResult).isEqualTo("13 000");
  }

}
