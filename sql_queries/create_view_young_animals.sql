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
SELECT pets.id, pets.name, pets.birth_date, getAgeInYearsAndMonths(pets.birth_date) AS age,
	gender_identities.gender, animal_types.type FROM pets
JOIN animal_types ON pets.animal_type_id = animal_types.id
JOIN gender_identities ON pets.gender_id = gender_identities.id
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3
UNION
SELECT pack_animals.id, pack_animals.name, pack_animals.birth_date,
	getAgeInYearsAndMonths(pack_animals.birth_date) AS age, gender_identities.gender, animal_types.type FROM pack_animals
JOIN animal_types ON pack_animals.animal_type_id = animal_types.id
JOIN gender_identities ON pack_animals.gender_id = gender_identities.id
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;

SELECT * FROM young_animals;