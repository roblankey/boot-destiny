CREATE TABLE die (card_id INTEGER NOT NULL, PRIMARY KEY (card_id));
CREATE TABLE die_face (die_id INTEGER NOT NULL, face_id INTEGER NOT NULL);
CREATE TABLE face (id INTEGER NOT NULL, cost INTEGER, type VARCHAR(255) NOT NULL, value INTEGER, PRIMARY KEY (id));

-- captain phasma die
INSERT INTO die (card_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'));
INSERT INTO face (cost, type, value) VALUES (null, 'RANGED', 1);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
INSERT INTO face (cost, type, value) VALUES (null, 'RANGED', 2);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
INSERT INTO face (cost, type, value) VALUES (null, 'FOCUS', 1);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
INSERT INTO face (cost, type, value) VALUES (null, 'DISCARD', 1);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
INSERT INTO face (cost, type, value) VALUES (null, 'RESOURCE', 1);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
INSERT INTO face (cost, type, value) VALUES (null, 'BLANK', null);
INSERT INTO die_face (die_id, face_id) VALUES ((SELECT id FROM card WHERE name = 'Captain Phasma'), last_insert_rowid());
