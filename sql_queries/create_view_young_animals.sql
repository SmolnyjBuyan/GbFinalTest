USE human_friends;

DROP VIEW IF EXISTS young_animals;

DROP FUNCTION IF EXISTS getAgeInYearsAndMonths;
DELIMITER $$
CREATE FUNCTION getAgeInYearsAndMonths(birth_date DATE)
RETURNS VARCHAR(45) READS SQL DATA
BEGIN
    RETURN CONCAT(TIMESTAMPDIFF(YEAR, birth_date, CURDATE()), ' years ', MOD(TIMESTAMPDIFF(MONTH, birth_date, CURDATE()), 12), ' months');
END $$
DELIMITER ;

CREATE VIEW young_animals AS
SELECT pets.id, pets.name, pets.birth_date, getAgeInYearsAndMonths(pets.birth_date) AS age, pets.gender, pet_types.type FROM pets
JOIN pet_types ON pets.pet_type_id = pet_types.id
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3
UNION
SELECT pack_animals.id, pack_animals.name, pack_animals.birth_date, getAgeInYearsAndMonths(pack_animals.birth_date) AS age, pack_animals.gender, pack_animal_types.type FROM pack_animals
JOIN pack_animal_types ON pack_animals.pack_animal_type_id = pack_animal_types.id
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;

SELECT * FROM young_animals;