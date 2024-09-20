SELECT * FROM horses
JOIN pack_animals USING (id)
JOIN pack_animal_types ON pack_animals.pack_animal_type_id = pack_animal_types.id
UNION
SELECT * FROM donkeys
JOIN pack_animals USING (id)
JOIN pack_animal_types ON pack_animals.pack_animal_type_id = pack_animal_types.id;