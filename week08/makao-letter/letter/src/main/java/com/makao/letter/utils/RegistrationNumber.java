package com.makao.letter.utils;

public class RegistrationNumber {
  public static int RegistrationNumber = 0;

  public static int giveRegistrationNumber() {
    RegistrationNumber += 1;
    return RegistrationNumber;
  }
}
