package com.example.ibanvalidationws.service;

import com.example.ibanvalidationws.model.IBANCountryCode;
import com.example.ibanvalidationws.repository.IBANCountryCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Implementation of {@link IBANValidationService}.
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class IBANValidationServiceImpl implements IBANValidationService {

  private final IBANCountryCodeRepository ibanCountryCodeRepository;

  @Override
  public boolean validateIBAN(String iban) {
    String formattedIban = iban.replaceAll(" ", "");
    String code = formattedIban.substring(0, 2);

    IBANCountryCode ibanCountryCode = ibanCountryCodeRepository.findByCode(code);

    if (ibanCountryCode == null) {
      log.error("Invalid or unsupported country code [{}]", code);
      return false;
    }

    if (formattedIban.length() != ibanCountryCode.getLength()) {
      log.error("Invalid IBAN length");
      return false;
    }

    String rearrangedIBAN = rearrange(formattedIban);
    String numericIBAN = convertToNumeric(rearrangedIBAN);

    if (mod97(numericIBAN) != 1) {
      log.error("Invalid IBAN");
      return false;
    }

    log.info("IBAN validated successfully");
    return true;
  }

  private String rearrange(String formattedIBAN) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(formattedIBAN.substring(4));
    stringBuilder.append(formattedIBAN, 0, 4);

    return stringBuilder.toString();
  }

  private String convertToNumeric(String rearrangedIBAN) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < rearrangedIBAN.length(); i++) {
      char element = rearrangedIBAN.charAt(i);

      if (Character.isLetter(element)) {
        int number = element - 55;
        stringBuilder.append(number);
      } else {
        stringBuilder.append(element);
      }
    }

    return stringBuilder.toString();
  }

  private int mod97(String numericIban) {
    return new BigInteger(numericIban).divideAndRemainder(BigInteger.valueOf(97))[1].intValue();
  }

}
