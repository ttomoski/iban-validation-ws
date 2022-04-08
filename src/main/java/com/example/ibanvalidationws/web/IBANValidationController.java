package com.example.ibanvalidationws.web;

import com.example.ibanvalidationws.service.IBANValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for IBAN validation.
 */
@RestController
@RequiredArgsConstructor
public class IBANValidationController {

  private final IBANValidationService service;

  /**
   * Endpoint for validating an IBAN number.
   *
   * @param ibanRequest the IBAN
   * @return whether the IBAN is valid
   */
  @PostMapping("/validate")
  public boolean validateIBAN(@RequestBody IBANRequest ibanRequest) {
    return service.validateIBAN(ibanRequest.getIban());
  }

}
