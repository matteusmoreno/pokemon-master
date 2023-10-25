CREATE TABLE pokemons (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    type VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    pokemon_master_id BIGINT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    active BOOLEAN,

    FOREIGN KEY (pokemon_master_id) REFERENCES pokemon_master(id)
);
