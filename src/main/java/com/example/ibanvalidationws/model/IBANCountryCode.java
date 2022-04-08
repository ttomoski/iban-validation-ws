package com.example.ibanvalidationws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Country code and IBAN length for it.
 */
@Entity(name = "iban_country_code")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IBANCountryCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private Integer length;

}
