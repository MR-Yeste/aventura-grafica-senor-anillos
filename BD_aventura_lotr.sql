CREATE TABLE escenas (
    id NUMBER PRIMARY KEY,
    texto TEXT,
    imagen VARCHAR2(255)
);

CREATE TABLE opciones (
    id NUMBER PRIMARY KEY,
    texto VARCHAR2(255),
    escena_origen_id NUMBER,
    escena_destino_id NUMBER,
    FOREIGN KEY (escena_origen_id) REFERENCES escenas(id),
    FOREIGN KEY (escena_destino_id) REFERENCES escenas(id)
);

INSERT INTO escenas (id, texto, imagen) VALUES (1, 'Te despiertas en tu casa porque han llamado a la puerta. ¿Qué haces?', 'cabaña.jpg');
INSERT INTO escenas (id, texto, imagen) VALUES (2, 'Abres la puerta. Es tu amigo Gandalf. Quiere pasar. ¿Le dejas entrar?', 'gandalf.jpg');
INSERT INTO escenas (id, texto, imagen) VALUES (3, 'Te quedas dentro y dejan de llamar.', 'interior.jpg');
INSERT INTO escenas (id, texto, imagen) VALUES (4, 'Gandalf entra preocupado y te dice que tiene malas noticias. ', 'anillo.jpg');
INSERT INTO escenas (id, texto, imagen) VALUES (5, 'Gandalf se enfada. Te lanza un hechizo y mueres. ', 'youdied.jpg');

INSERT INTO opciones (id, texto, escena_origen_id, escena_destino_id)
VALUES (1, 'Abrir la puerta', 1, 2);

INSERT INTO opciones (id, texto, escena_origen_id, escena_destino_id)
VALUES (2, 'Ignoras la llamada', 1, 3);

INSERT INTO opciones (id, texto, escena_origen_id, escena_destino_id)
VALUES (1, 'Le dejas pasar', 2, 4);

INSERT INTO opciones (id, texto, escena_origen_id, escena_destino_id)
VALUES (2, 'No le dejas pasar', 2, 5);