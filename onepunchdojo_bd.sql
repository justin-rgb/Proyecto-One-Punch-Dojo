/* se crea la base de datos */
CREATE SCHEMA `onepunchdojo_bd`;

/* se crean las tablas*/

CREATE TABLE `onepunchdojo_bd`.`usuario`(`id_usuario` INT NOT NULL auto_increment, `usuario` VARCHAR(50) NOT NULL,`contraseña` VARCHAR(50) NOT NULL,`nombre` VARCHAR(50) NOT NULL, 
										`apellidos` VARCHAR(50) NOT NULL,PRIMARY KEY (`id_usuario`));

CREATE TABLE `onepunchdojo_bd`.`clientes`(`cedula` VARCHAR(50) NOT NULL,`nombre` varchar(50) NOT NULL, `apellidos` varchar(50) NOT NULL,
 `direccion` VARCHAR(150) NOT NULL, `num_telefono` VARCHAR(50) NULL, `categoria_cliente` VARCHAR(50) NULL, PRIMARY KEY(`cedula`));
 
CREATE TABLE `onepunchdojo_bd`.`inventario`(`id_item` INT NOT NULL auto_increment,`descripcion` varchar(50) NOT NULL, `cantidad` int NOT NULL, PRIMARY KEY(`id_item`));
 
CREATE TABLE `onepunchdojo_bd`.`facturas`(`id_factura` INT NOT NULL auto_increment,`nombre` varchar(50) NOT NULL, `apellidos` varchar(50),`cedula` VARCHAR(50), `monto` INT NOT NULL,
										  `fecha` varchar(50),PRIMARY KEY(`id_factura`));
 
CREATE TABLE `onepunchdojo_bd`.`proveedores`(`id_proveedor` INT NOT NULL auto_increment,`nombre_proveedor` varchar(50) NOT NULL, `telefono` varchar(50),`ubicacion` VARCHAR(50), PRIMARY KEY(`id_proveedor`));

CREATE TABLE `onepunchdojo_bd`.`compras`(`id_compra` INT NOT NULL auto_increment,`monto` int NOT NULL, `detalle` varchar(150),`proveedor` VARCHAR(50),`fecha` VARCHAR(50), PRIMARY KEY(`id_proveedor`));

CREATE TABLE `onepunchdojo_bd`.`eventos`(`id_evento` INT NOT NULL AUTO_INCREMENT,`descripcion` varchar(50),`fecha` varchar(50) NOT NULL, `hora` varchar(50),`instructor` VARCHAR(50), PRIMARY KEY(`id_evento`));

/*  crear usuario y asignar permisos */
CREATE USER 'admin' @'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON onepunchdojo_bd to 'admin';
flush privileges;