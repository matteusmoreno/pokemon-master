CREATE TABLE pokemons (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    type VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL UNIQUE,
    pokemon_master_id BIGINT,
    description TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    active BOOLEAN,

    FOREIGN KEY (pokemon_master_id) REFERENCES pokemon_master(id)
);
