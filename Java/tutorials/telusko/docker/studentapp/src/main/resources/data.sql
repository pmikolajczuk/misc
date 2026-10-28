INSERT INTO student (id, name, age) VALUES
    (1, 'John', 20),
    (2, 'Jane', 22),
    (3, 'Jack', 23)
ON CONFLICT (id) DO NOTHING;

