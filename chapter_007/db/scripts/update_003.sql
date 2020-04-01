CREATE TABLE IF NOT EXISTS comments
(
    id      serial PRIMARY KEY,
    comment text,
    item_id int REFERENCES items (id)
);