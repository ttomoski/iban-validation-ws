create table iban_country_code(
    id integer primary key,
    code varchar,
    length integer
);

insert into iban_country_code(id, code, length) values (1, 'BE', 16);
insert into iban_country_code(id, code, length) values (2, 'CR', 22);
insert into iban_country_code(id, code, length) values (3, 'PT', 25);
insert into iban_country_code(id, code, length) values (4, 'SE', 24);
insert into iban_country_code(id, code, length) values (5, 'GB', 22);