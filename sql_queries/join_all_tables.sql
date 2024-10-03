USE human_friends;

SELECT pet_commands.id_pet AS id, pets.name, pets.birth_date, gender_identities.gender, animal_types.type, 
	GROUP_CONCAT(commands.name) AS commands, 'Pets' AS table_name
FROM pet_commands
JOIN commands ON pet_commands.id_command = commands.id
JOIN pets ON pet_commands.id_pet = pets.id
JOIN animal_types ON pets.animal_type_id = animal_types.id
JOIN gender_identities ON pets.gender_id = gender_identities.id
GROUP BY id_pet
UNION
SELECT pack_animal_commands.id_pack_animal AS id, pack_animals.name, pack_animals.birth_date, gender_identities.gender, animal_types.type,
	GROUP_CONCAT(commands.name) AS commands, 'Pack animals' AS table_name
FROM pack_animal_commands
JOIN commands ON pack_animal_commands.id_command = commands.id
JOIN pack_animals ON pack_animal_commands.id_pack_animal = pack_animals.id
JOIN animal_types ON pack_animals.animal_type_id = animal_types.id
JOIN gender_identities ON pack_animals.gender_id = gender_identities.id
GROUP BY id_pack_animal;
