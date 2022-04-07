package com.example.ibanvalidationws.controller;

import com.example.ibanvalidationws.model.IBANRequest;
import com.example.ibanvalidationws.service.IBANValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IBANValidationController {

  private IBANValidationService service;

  @PostMapping("/validate")
  public boolean validateIBAN(IBANRequest ibanRequest) {
    return service.validateIBAN(ibanRequest.getIban());
  }

}
