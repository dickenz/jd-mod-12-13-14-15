CREATE TABLE note (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT
);

INSERT INTO note (title, content) VALUES
    ('Sample Note 1', 'This is the content of note 1.'),
    ('Sample Note 2', 'This is the content of note 2.');
