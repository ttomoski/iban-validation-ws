package com.example.ibanvalidationws.service;

/**
 * Service containing logic for validating an IBAN number.
 */
public interface IBANValidationService {

  /**
   * Validates the IBAN number.
   *
   * @param iban the IBAN
   * @return whether the IBAN is valid
   */
  boolean validateIBAN(String iban);

}
