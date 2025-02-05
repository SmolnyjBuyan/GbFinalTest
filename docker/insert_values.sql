USE human_friends;

INSERT INTO animal_types (id, type) VALUES
	(1, "Cat"),
    (2, "Dog"),
    (3, "Hamster"),
    (4, "Camel"),
    (5, "Horse"),
    (6, "Donkey");
    
INSERT INTO gender_identities (id, gender) VALUES
	(1, "Male"),
    (2, "Female");

INSERT INTO pets (name, birth_date, gender_id, animal_type_id) VALUES 
	('Fido', '2019-05-15', 1, 2),
	('Whiskers', '2019-05-15', 1, 1),
    ('Hammy', '2021-03-10', 2, 3),
    ('Buddy', '2018-12-10', 1, 2),
    ('Smudge', '2020-02-20', 1, 1),
    ('Peanut', '2021-08-01', 1, 3),
    ('Bella', '2019-11-11', 2, 2),
    ('Oliver', '2020-06-30', 1, 1);
    
    
INSERT INTO pack_animals (name, birth_date, gender_id, animal_type_id) VALUES 
	('Thunder', '2015-07-21', 2, 5),
    ('Sandy', '2016-11-03', 2, 4),
    ('Eeyore', '2017-09-18', 1, 6),
    ('Storm', '2014-05-05', 2, 5),
    ('Dune', '2018-12-12', 2, 4),
    ('Burro', '2019-01-23', 1, 6),
    ('Blaze', '2016-02-29', 1, 5),
    ('Sahara', '2015-08-14', 2, 4);
    
INSERT INTO commands (name) VALUES 
	('Sit'),
    ('Stay'),
    ('Fetch'),
    ('Pounce'),
    ('Roll'),
    ('Hide'),
    ('Paw'),
    ('Bark'),
    ('Scratch'),
    ('Spin'),
    ('Meow'),
    ('Jump'),
	('Trot'),
    ('Canter'),
    ('Gallop'),
    ('Walk'),
    ('Carry Load'),
    ('Bray'),
    ('Kick'),
    ('Run');
    
INSERT INTO pet_commands (command_id, pet_id) VALUES
	((SELECT id FROM commands WHERE name = 'Sit'), 1),
    ((SELECT id FROM commands WHERE name = 'Stay'), 1),
    ((SELECT id FROM commands WHERE name = 'Fetch'), 1),
    ((SELECT id FROM commands WHERE name = 'Sit'), 2),
    ((SELECT id FROM commands WHERE name = 'Pounce'), 2),
    ((SELECT id FROM commands WHERE name = 'Roll'), 3),
    ((SELECT id FROM commands WHERE name = 'Hide'), 3),
    ((SELECT id FROM commands WHERE name = 'Sit'), 4),
    ((SELECT id FROM commands WHERE name = 'Paw'), 4),
    ((SELECT id FROM commands WHERE name = 'Bark'), 4),
    ((SELECT id FROM commands WHERE name = 'Sit'), 5),
    ((SELECT id FROM commands WHERE name = 'Pounce'), 5),
    ((SELECT id FROM commands WHERE name = 'Scratch'), 5),
    ((SELECT id FROM commands WHERE name = 'Roll'), 6),
    ((SELECT id FROM commands WHERE name = 'Spin'), 6),
    ((SELECT id FROM commands WHERE name = 'Sit'), 7),
    ((SELECT id FROM commands WHERE name = 'Stay'), 7),
    ((SELECT id FROM commands WHERE name = 'Roll'), 7),
    ((SELECT id FROM commands WHERE name = 'Meow'), 8),
    ((SELECT id FROM commands WHERE name = 'Scratch'), 8),
    ((SELECT id FROM commands WHERE name = 'Jump'), 8);

INSERT INTO pack_animal_commands (command_id, pack_animal_id) VALUES
	((SELECT id FROM commands WHERE name = 'Trot'), 1),
    ((SELECT id FROM commands WHERE name = 'Canter'), 1),
    ((SELECT id FROM commands WHERE name = 'Gallop'), 1),
    ((SELECT id FROM commands WHERE name = 'Walk'), 2),
    ((SELECT id FROM commands WHERE name = 'Carry Load'), 2),
    ((SELECT id FROM commands WHERE name = 'Walk'), 3),
    ((SELECT id FROM commands WHERE name = 'Carry Load'), 3),
    ((SELECT id FROM commands WHERE name = 'Bray'), 3),
    ((SELECT id FROM commands WHERE name = 'Trot'), 4),
    ((SELECT id FROM commands WHERE name = 'Canter'), 4),
    ((SELECT id FROM commands WHERE name = 'Walk'), 5),
    ((SELECT id FROM commands WHERE name = 'Sit'), 5),
    ((SELECT id FROM commands WHERE name = 'Walk'), 6),
    ((SELECT id FROM commands WHERE name = 'Bray'), 6),
    ((SELECT id FROM commands WHERE name = 'Kick'), 6),
    ((SELECT id FROM commands WHERE name = 'Trot'), 7),
    ((SELECT id FROM commands WHERE name = 'Jump'), 7),
    ((SELECT id FROM commands WHERE name = 'Gallop'), 7),
    ((SELECT id FROM commands WHERE name = 'Walk'), 8),
    ((SELECT id FROM commands WHERE name = 'Run'), 8);

INSERT INTO dogs(id) VALUES
	(1), (4), (7);
    
INSERT INTO cats(id) VALUES
	(2), (5), (8);
    
INSERT INTO hamsters(id) VALUES
	(3), (6);

INSERT INTO horses (id) VALUES
	(1), (4), (7);

INSERT INTO camels (id) VALUES
	(2), (5), (8);
    
INSERT INTO donkeys (id) VALUES
	(3), (6);



