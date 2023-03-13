CREATE DATABASE tienda;
USE tienda;
CREATE TABLE IF NOT EXISTS proveedores (
    id_proveedor int(3) NOT NULL AUTO_INCREMENT,
    nombre varchar(50),
    fecha_de_alta date,
    id_cliente int(3),
    PRIMARY KEY (id_proveedor)
);

CREATE USER 'sa'@'localhost' IDENTIFIED BY '1';
GRANT ALL PRIVILEGES ON tienda.* TO 'sa'@'localhost' WITH GRANT OPTION;

INSERT INTO tienda ( id_proveedor, nombre, fecha_de_alta, id_cliente ) VALUES ( null, 'Coca Cola', '2023/01/01', 5 );
INSERT INTO tienda ( id_proveedor, nombre, fecha_de_alta, id_cliente ) VALUES ( null, 'Pepsi', '2023/01/01', 5 );
INSERT INTO tienda ( id_proveedor, nombre, fecha_de_alta, id_cliente ) VALUES ( null, 'Red Bull', '2023/01/01', 6 );