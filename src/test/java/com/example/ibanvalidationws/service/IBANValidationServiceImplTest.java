package com.example.ibanvalidationws.service;

import com.example.ibanvalidationws.model.IBANCountryCode;
import com.example.ibanvalidationws.repository.IBANCountryCodeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link IBANValidationServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class IBANValidationServiceImplTest {

    @Mock
    private IBANCountryCodeRepository repository;

    @InjectMocks
    private IBANValidationServiceImpl ibanValidationService;


    @Test
    void validIBAN_GB() {
        when(repository.findByCode("GB"))
                .thenReturn(new IBANCountryCode(1L, "GB", 22));

        assertTrue(ibanValidationService.validateIBAN("GB98 MIDL 0700 9312 3456 78"));
    }

    @Test
    void validIBAN_PL() {
        when(repository.findByCode("PL"))
                .thenReturn(new IBANCountryCode(1L, "PL", 28));

        assertTrue(ibanValidationService.validateIBAN("PL61 1090 1014 0000 0712 1981 2874"));
    }

    @Test
    void validIBAN_MK() {
        when(repository.findByCode("MK"))
                .thenReturn(new IBANCountryCode(1L, "MK", 19));

        assertTrue(ibanValidationService.validateIBAN("MK07 2501 2000 0058 984"));
    }

    @Test
    void validIBAN_MU() {
        when(repository.findByCode("MU"))
                .thenReturn(new IBANCountryCode(1L, "MU", 30));

        assertTrue(ibanValidationService.validateIBAN("MU17 BOMM 0101 1010 3030 0200 000M UR"));
    }

    @Test
    void validIBAN_GL() {
        when(repository.findByCode("GL"))
                .thenReturn(new IBANCountryCode(1L, "GL", 18));

        assertTrue(ibanValidationService.validateIBAN("GL89 6471 0001 0002 06"));
    }

    @Test
    void invalidIBAN_invalidCountryCode() {
        when(repository.findByCode("Gq"))
                .thenReturn(null);

        assertFalse(ibanValidationService.validateIBAN("Gqwe"));
    }

    @Test
    void invalidIBAN_invalidLength() {
        when(repository.findByCode("GB"))
                .thenReturn(new IBANCountryCode(1L, "GB", 22));

        assertFalse(ibanValidationService.validateIBAN("GB98 MIDL 0700 9312 3456"));
    }

    @Test
    void invalidIBAN_GB() {
        when(repository.findByCode("GB"))
                .thenReturn(new IBANCountryCode(1L, "GB", 22));

        assertFalse(ibanValidationService.validateIBAN("GB98 MIDL 0700 9312 3456 71"));
    }

    @Test
    void invalidIBAN_PL() {
        when(repository.findByCode("PL"))
                .thenReturn(new IBANCountryCode(1L, "PL", 28));

        assertFalse(ibanValidationService.validateIBAN("PL61 1090 1014 0000 0712 1981 2871"));
    }

    @Test
    void invalidIBAN_MK() {
        when(repository.findByCode("MK"))
                .thenReturn(new IBANCountryCode(1L, "MK", 19));

        assertFalse(ibanValidationService.validateIBAN("MK07 2501 2000 0058 982"));
    }

    @Test
    void invalidIBAN_MU() {
        when(repository.findByCode("MU"))
                .thenReturn(new IBANCountryCode(1L, "MU", 30));

        assertFalse(ibanValidationService.validateIBAN("MU17 BOMM 0101 1010 3030 0200 000M SR"));
    }

    @Test
    void invalidIBAN_GL() {
        when(repository.findByCode("GL"))
                .thenReturn(new IBANCountryCode(1L, "GL", 18));

        assertFalse(ibanValidationService.validateIBAN("GL89 6471 0001 0002 26"));
    }


}