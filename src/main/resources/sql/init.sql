insert into owners (owner_id, first_name, middle_name, last_name)
values (1, "Батюков", "Дмитрий", "Александрович"),
       (2, "-", "-", "-");

insert into locations (location_id, index, region, district, location_name, coordinates, street_name, house_number,
                       corpus_number, phone_number, fax_number, email)
values (1, "211003", "Витебская", "Оршанская", "аг. Устье", "54.435432 30.381196", "Централная", "18", "-", "375216272381", "375216272442", "gbuste@mail.ru"),
       (2, "211003", "Витебская", "Оршанская", "аг. Устье", "-", "-", "-", "-", "375216272381", "375216272442", "gbuste@mail.ru");

insert into organizations (organization_id, owner_id, location_id, gln, registration_date, name, short_name, unp, okpo,
                           egr, created_date, bank_code, payment_account)
values (1, 1, 1, "4818001111009", 2016:05:18 00:00:00, "Республиканское производственное унитарное предприятие Устье Национальная Академия Наук Беларусь", "РПУП Устье НАН Беларуст", "300072707"
, "00751077", "-", 2020:11:26 8:51:09, "BAPBBY2X", "BY65BAP301240014009200000");

insert into farms (farm_id, organization_id, location_id, owner_id, gln, registration_date, name, forming_date)
values (1, 1, 2, 2, "4818001111030", 2016:05:18 00:00:00 ,"Ферма Горбацевичи", 2017:12:07 12:07:09);



