USE human_friends;

SELECT pet_commands.id_pet AS id, pets.name, pets.birth_date, pets.gender, pet_types.type, 
	GROUP_CONCAT(commands.name) AS commands, 'Pets' AS table_name
FROM pet_commands
JOIN commands ON pet_commands.id_command = commands.id
JOIN pets ON pet_commands.id_pet = pets.id
JOIN pet_types ON pets.pet_type_id = pet_types.id
GROUP BY id_pet
UNION
SELECT pack_animal_commands.id_pack_animal AS id, pack_animals.name, pack_animals.birth_date, pack_animals.gender, pack_animal_types.type,
	GROUP_CONCAT(commands.name) AS commands, 'Pack animals' AS table_name
FROM pack_animal_commands
JOIN commands ON pack_animal_commands.id_command = commands.id
JOIN pack_animals ON pack_animal_commands.id_pack_animal = pack_animals.id
JOIN pack_animal_types ON pack_animals.pack_animal_type_id = pack_animal_types.id
GROUP BY id_pack_animal;
