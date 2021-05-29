use db_pokemon;
CREATE TABLE pokemon (
num BIGINT(10),
name VARCHAR(255),
tipo VARCHAR(255),
pre_evolution VARCHAR(255),
next_evolution VARCHAR(255),
PRIMARY KEY (num)
);

