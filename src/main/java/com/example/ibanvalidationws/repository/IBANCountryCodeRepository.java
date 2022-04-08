package com.example.ibanvalidationws.repository;

import com.example.ibanvalidationws.model.IBANCountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for the country codes.
 */
public interface IBANCountryCodeRepository extends JpaRepository<IBANCountryCode, Long> {

    IBANCountryCode findByCode(String code);

}
