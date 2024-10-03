SELECT * FROM horses
JOIN pack_animals USING (id)
JOIN animal_types ON pack_animals.animal_type_id = animal_types.id
UNION
SELECT * FROM donkeys
JOIN pack_animals USING (id)
JOIN animal_types ON pack_animals.animal_type_id = animal_types.id;