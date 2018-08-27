-- tables
CREATE TABLE card (id INTEGER NOT NULL, name VARCHAR(255) NOT NULL, number INTEGER NOT NULL, affiliation VARCHAR(255), cost INTEGER, faction VARCHAR(255), health INTEGER, points VARCHAR(255), quote VARCHAR(255), rarity VARCHAR(255), text VARCHAR(255), title VARCHAR(255), type VARCHAR(255), set_id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE card_set (id INTEGER NOT NULL, name VARCHAR(255) NOT NULL UNIQUE, icon VARCHAR(255), PRIMARY KEY (id));

-- sequence
CREATE TABLE hibernate_sequence (next_val bigint);
INSERT INTO hibernate_sequence VALUES (1);
