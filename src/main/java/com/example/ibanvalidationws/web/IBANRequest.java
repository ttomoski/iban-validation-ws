package com.example.ibanvalidationws.web;

import lombok.Getter;

/**
 * API request containing the IBAN number.
 */
@Getter
public class IBANRequest {

  private String iban;

}
