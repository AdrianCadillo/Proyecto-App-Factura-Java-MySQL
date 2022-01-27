-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2022 a las 20:58:42
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cursofactura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombcategoria` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `correo` varchar(85) DEFAULT NULL,
  `id_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `correo`, `id_persona`) VALUES
(1, 'adriaaanroosales@gmail.com', 1),
(2, 'Julian200@gmail.com', 2),
(3, 'Gustavo2000@gmail.com', 3),
(4, '', 4),
(5, 'Julia@gmail.com', 5),
(6, '', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `fechaentrada` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_provedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompras`
--

CREATE TABLE `detallecompras` (
  `id_producto` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `preciocompra` decimal(9,2) NOT NULL,
  `importe` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `unidades` int(11) NOT NULL,
  `precioventa` decimal(9,2) NOT NULL,
  `importeventa` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `id_factura` int(11) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `fechaemitido` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id_persona` int(11) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `apellidos` varchar(85) DEFAULT NULL,
  `nombres` varchar(150) NOT NULL,
  `direccion` varchar(95) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id_persona`, `documento`, `apellidos`, `nombres`, `direccion`) VALUES
(1, '77436877', 'Rosales Cadillo', 'Abelardo Adrian', 'Anchas-Huaraz'),
(2, '03289734', 'Armas Pinedo', 'Julian Pedro', ''),
(3, '99023479', 'Gustavo Hugo', 'Mendoza Huamán', 'Lima'),
(4, '00389221', 'Roque Minaya', 'María Ursula', ''),
(5, '80001298', 'Rodriguez Perez', 'Julia Irma', ''),
(6, '08992323', 'Armas Pajuelo', 'Karla Fiorella', 'Lima-Puente Piedra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `codigoprod` varchar(20) NOT NULL,
  `descripcion` varchar(90) NOT NULL,
  `precio` decimal(9,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `foto` longblob DEFAULT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_provedor` int(11) NOT NULL,
  `correo` varchar(80) DEFAULT NULL,
  `paginaweb` varchar(80) DEFAULT NULL,
  `id_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nick` varchar(45) NOT NULL,
  `pasword` varchar(55) NOT NULL,
  `rol` enum('Administrador','Vendedor','Almacenero') NOT NULL,
  `estado` enum('0','1') NOT NULL,
  `id_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_listaclientes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_listaclientes` (
`documento` varchar(12)
,`apellidos` varchar(85)
,`nombres` varchar(150)
,`Direccion` varchar(95)
,`Correo` varchar(85)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_listaclientespordocumento`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_listaclientespordocumento` (
`documento` varchar(12)
,`apellidos` varchar(85)
,`nombres` varchar(150)
,`Direccion` varchar(95)
,`Correo` varchar(85)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_listaclientes`
--
DROP TABLE IF EXISTS `v_listaclientes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_listaclientes`  AS SELECT `p`.`documento` AS `documento`, `p`.`apellidos` AS `apellidos`, `p`.`nombres` AS `nombres`, if(`p`.`direccion` = '','No especifica dirección',`p`.`direccion`) AS `Direccion`, if(`c`.`correo` = '','No especifica correo',`c`.`correo`) AS `Correo` FROM (`clientes` `c` join `personas` `p` on(`c`.`id_persona` = `p`.`id_persona`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `v_listaclientespordocumento`
--
DROP TABLE IF EXISTS `v_listaclientespordocumento`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_listaclientespordocumento`  AS SELECT `p`.`documento` AS `documento`, `p`.`apellidos` AS `apellidos`, `p`.`nombres` AS `nombres`, `p`.`direccion` AS `Direccion`, `c`.`correo` AS `Correo` FROM (`clientes` `c` join `personas` `p` on(`c`.`id_persona` = `p`.`id_persona`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `fk_CLIENTES_PERSONAS_idx` (`id_persona`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `fk_ALMACEN_USUARIOS1_idx` (`id_usuario`),
  ADD KEY `fk_ALMACEN_PROVEEDORES1_idx` (`id_provedor`);

--
-- Indices de la tabla `detallecompras`
--
ALTER TABLE `detallecompras`
  ADD PRIMARY KEY (`id_producto`,`id_compra`),
  ADD KEY `fk_PRODUCTOS_has_COMPRAS_COMPRAS1_idx` (`id_compra`),
  ADD KEY `fk_PRODUCTOS_has_COMPRAS_PRODUCTOS1_idx` (`id_producto`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`id_factura`,`id_producto`),
  ADD KEY `fk_FACTURAS_has_PRODUCTOS_PRODUCTOS1_idx` (`id_producto`),
  ADD KEY `fk_FACTURAS_has_PRODUCTOS_FACTURAS1_idx` (`id_factura`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `fk_VENTAS_CLIENTES1_idx` (`id_cliente`),
  ADD KEY `fk_VENTAS_USUARIOS1_idx` (`id_usuario`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `fk_PRODUCTOS_CATEGORIAS1_idx` (`id_categoria`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_provedor`),
  ADD KEY `fk_PROVEEDORES_PERSONAS1_idx` (`id_persona`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_USUARIOS_PERSONAS1_idx` (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_provedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `fk_CLIENTES_PERSONAS` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `fk_ALMACEN_PROVEEDORES1` FOREIGN KEY (`id_provedor`) REFERENCES `proveedores` (`id_provedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ALMACEN_USUARIOS1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detallecompras`
--
ALTER TABLE `detallecompras`
  ADD CONSTRAINT `fk_PRODUCTOS_has_COMPRAS_COMPRAS1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PRODUCTOS_has_COMPRAS_PRODUCTOS1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD CONSTRAINT `fk_FACTURAS_has_PRODUCTOS_FACTURAS1` FOREIGN KEY (`id_factura`) REFERENCES `facturas` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_FACTURAS_has_PRODUCTOS_PRODUCTOS1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `fk_VENTAS_CLIENTES1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_VENTAS_USUARIOS1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_PRODUCTOS_CATEGORIAS1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD CONSTRAINT `fk_PROVEEDORES_PERSONAS1` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_USUARIOS_PERSONAS1` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
