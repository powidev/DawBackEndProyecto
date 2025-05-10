# Sistema de Gestion Transporte BACK

  <img width="30%" align="right" alt="Github" src="https://user-images.githubusercontent.com/48678280/88862734-4903af80-d201-11ea-968b-9c939d88a37c.gif" />

- ### Lenguaje y Tool
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="C#" width="40" height="40"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="C#" width="40" height="40"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" alt="C#" width="40" height="40"/>
  
- ### Database **SQL**
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="C#" width="40" height="40"/>
--------------------------------------------------------------------------------------------------------------------------------------------------------------
USE bdgestionbuses;

-- Insertar roles

INSERT INTO rol (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_SUPER');

-- Insertar usuarios

INSERT INTO usuario (username, password) VALUES ('admin', '$2a$12$q5vCPpoFsMABKixJ/6sTY.1d.jO4K8vu0Ekimb2NL0fB8kM7v43dG'), ('user', '$2a$12$q5vCPpoFsMABKixJ/6sTY.1d.jO4K8vu0Ekimb2NL0fB8kM7v43dG'), ('supervisor', '$2a$12$q5vCPpoFsMABKixJ/6sTY.1d.jO4K8vu0Ekimb2NL0fB8kM7v43dG'); -- usa la misma contraseña bcrypt

-- Asignar roles a los usuarios

INSERT INTO user_roles (user_id, role_name) VALUES (1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER'), (3, 'ROLE_SUPER');

INSERT INTO bus (anio, capacidad, marca, modelo, placa) 
VALUES 
(2022, 40, 'Volvo', 'B9R', 'JKL-111'),
(2023, 45, 'Mercedes', 'Sprinter', 'ABC-456'),
(2024, 55, 'Ford', 'Transit', 'DEF-789'),
(2025, 50, 'Toyota', 'Hiace', 'XYZ-123'),
(2021, 35, 'Hyundai', 'County', 'MNO-222'),
(2020, 60, 'Scania', 'K310', 'PQR-333');


INSERT INTO viaje (fech_lle, fech_sal, incidencias, precio, id_bus, id_destino) 
VALUES 
('2025-05-01', '2025-04-30', 'Sin novedades', 150.00, 1, 1),
('2025-06-15', '2025-06-14', 'Retraso menor', 200.00, 2, 2),
('2025-07-20', '2025-07-19', 'Falla mecánica', 180.50, 1, 3),
('2025-08-05', '2025-08-04', 'Buen clima', 250.75, 2, 4),
('2025-09-10', '2025-09-09', 'Cambio de ruta', 220.00, 1, 5);

INSERT INTO destino (imagen, nombre) 
VALUES 
('imagen1.jpg', 'Lima'),
('imagen2.jpg', 'Arequipa'),
('imagen3.jpg', 'Cusco'),
('imagen4.jpg', 'Trujillo'),
('imagen5.jpg', 'Iquitos');

