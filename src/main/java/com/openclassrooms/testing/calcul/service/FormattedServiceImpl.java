package com.openclassrooms.testing.calcul.service;

import java.text.NumberFormat;

public class FormattedServiceImpl implements FormattedService {

  @Override
  public String format(Integer solution) {
    NumberFormat numberFormatter;
    String formattedsolution = null;
    numberFormatter = NumberFormat.getIntegerInstance();
    formattedsolution = numberFormatter.format(solution);


    return formattedsolution;
  }

}
