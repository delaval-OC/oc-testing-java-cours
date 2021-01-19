package com.openclassrooms.testing.calcul.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;

public class BatchCalculatorTest {

  @Test
  public void givenOperationsList_whenbatchCalculate_thenReturnsCorrectAnswerList()
      throws IOException, URISyntaxException {
    // GIVEN
    Stream<String> operations;

    // Aller chercher la donnée fournie par un collaborateur sur Internet

    operations = Arrays.asList("2 + 2", "5 * 4", "6 + 8", "10 * 3").stream();
    BatchCalculator batchCalculator = new BatchCalculator(new Calculator());

    // WHEN
    List<CalculationModel> resultats = batchCalculator.batchCalculate(operations);

    // THEN
    assertThat(resultats).extracting("solution").containsExactly(4, 20, 14, 30);
  }
}

