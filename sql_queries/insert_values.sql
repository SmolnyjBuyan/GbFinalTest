USE human_friends;

INSERT INTO pets (name, birth_date, gender) VALUES 
	('Fido', '2019-05-15', 'Male'),
	('Whiskers', '2019-05-15', 'Male'),
    ('Hammy', '2021-03-10', 'Female'),
    ('Buddy', '2018-12-10', 'Male'),
    ('Smudge', '2020-02-20', 'Male'),
    ('Peanut', '2021-08-01', 'Male'),
    ('Bella', '2019-11-11', 'Female'),
    ('Oliver', '2020-06-30', 'Male');
    
    
INSERT INTO pack_animals (name, birth_date, gender) VALUES 
	('Thunder', '2015-07-21', 'Female'),
    ('Sandy', '2016-11-03', 'Female'),
    ('Eeyore', '2017-09-18', 'Male'),
    ('Storm', '2014-05-05', 'Female'),
    ('Dune', '2018-12-12', 'Female'),
    ('Burro', '2019-01-23', 'Male'),
    ('Blaze', '2016-02-29', 'Male'),
    ('Sahara', '2015-08-14', 'Female');
    
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
    
INSERT INTO pet_commands (id_command, id_pet) VALUES
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

INSERT INTO pack_animal_commands (id_command, id_pack_animal) VALUES
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

