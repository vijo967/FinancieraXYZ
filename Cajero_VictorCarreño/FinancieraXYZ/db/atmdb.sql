-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:8889
-- Tiempo de generación: 29-10-2017 a las 06:28:39
-- Versión del servidor: 5.5.34
-- Versión de PHP: 5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `atmdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `nombres` varchar(20) NOT NULL,
  `apellidost` varchar(20) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombres`, `apellidost`, `telefono`, `correo`) VALUES
(0, 'Victor', 'Carreno', '0986245602', 'vcarreno@hotmail.com'),
(1, 'Juan', 'Perez', '1800', 'XXXXX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `id_cuenta` int(11) NOT NULL,
  `contrasenia` varchar(20) NOT NULL,
  `saldo` double NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `fk_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id_cuenta`, `contrasenia`, `saldo`, `id_cliente`) VALUES
(2900001, '12345', 979, 1),
(2900002, '54321', 504.38, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

CREATE TABLE `transacciones` (
  `id_cuenta` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `retiro` double NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `transacciones`
--

INSERT INTO `transacciones` (`id_cuenta`, `id_cliente`, `retiro`, `saldo`) VALUES
(2900001, 1, 200, 1289),
(2900001, 1, 200, 1289),
(2900001, 1, 200, 1289),
(2900002, 0, 150, 504.38),
(2900001, 1, 300, 989),
(2900001, 1, 10, 979);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
