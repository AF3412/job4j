CREATE TABLE IF NOT EXISTS items
(
    id          serial PRIMARY KEY,
    name        text,
    description text,
    dateCreate  timestamp
);