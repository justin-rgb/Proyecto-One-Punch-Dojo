/* se crea la base de datos */
CREATE SCHEMA `onepunchdojo_bd`;

/* se crean las tablas*/

CREATE TABLE `onepunchdojo_bd`.`cliente`(`id_cliente` int not null auto_increment,`nombre` varchar(50) NOT NULL, `apellidos` varchar(50) NOT NULL,`cedula` VARCHAR(50) NOT NULL,
			`direccion` VARCHAR(150) NOT NULL, `num_telefono` VARCHAR(50) NULL, `categoria` VARCHAR(50) NULL, PRIMARY KEY(`id_cliente`));

CREATE TABLE `onepunchdojo_bd`.`colaborador`(`id_colaborador` INT NOT NULL auto_increment, `nombre` VARCHAR(50) NOT NULL, `apellidos` VARCHAR(50) NOT NULL,
			`usuario` VARCHAR(50) NOT NULL,`pass` VARCHAR(50) NOT NULL,PRIMARY KEY (`id_colaborador`));
    
CREATE TABLE `onepunchdojo_bd`.`compras`(`id_compra` INT NOT NULL auto_increment,`monto` int NOT NULL, `detalle` varchar(150),`proveedor` VARCHAR(50),
			`fecha` VARCHAR(50),`url_imagen` varchar(200),PRIMARY KEY(`id_compra`));

CREATE TABLE `onepunchdojo_bd`.`evento`(`id_evento` INT NOT NULL AUTO_INCREMENT,`descripcion` varchar(50),`fecha` varchar(50) NOT NULL, `hora` varchar(50),
			`instructor` VARCHAR(50), PRIMARY KEY(`id_evento`));

CREATE TABLE `onepunchdojo_bd`.`factura`(`id_factura` INT NOT NULL auto_increment,`nombre` varchar(50) NOT NULL, `apellidos` varchar(50),`cedula` VARCHAR(50), `monto_total` INT NOT NULL,
										  `Fecha` varchar(50),PRIMARY KEY(`id_factura`));

CREATE TABLE `onepunchdojo_bd`.`inventario`(`id_item` INT NOT NULL auto_increment,`descripcion` varchar(50) NOT NULL, `cantidad` int NOT NULL,`url_imagen` varchar(200), PRIMARY KEY(`id_item`));
 
CREATE TABLE `onepunchdojo_bd`.`proveedor`(`id_proveedor` INT NOT NULL auto_increment,`nombre_empresa` varchar(50) NOT NULL, `telefono` varchar(50),
			`ubicacion` VARCHAR(50),`url_imagen` varchar(200),PRIMARY KEY(`id_proveedor`));

/*  crear usuario y asignar permisos */
CREATE USER 'admin' @'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON onepunchdojo_bd to 'admin';
flush privileges;