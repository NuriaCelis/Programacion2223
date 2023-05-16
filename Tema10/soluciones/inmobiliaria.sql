-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2021 a las 16:25:35
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmobiliaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmuebles`
--

CREATE TABLE `inmuebles` (
  `idinmueble` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `localidad` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `annoconstruccion` varchar(4) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `superficiem2` int(11) DEFAULT NULL,
  `NIFpropietario` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `precio` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `inmuebles`
--

INSERT INTO `inmuebles` (`idinmueble`, `direccion`, `localidad`, `annoconstruccion`, `superficiem2`, `NIFpropietario`, `precio`) VALUES
('100', 'Calle Ancha', 'Torrelavega', '1950', 85, '1230F', 85000),
('101', 'Calle Ancha', 'Torrelavega', '1970', 100, '1435B', 95000),
('102', 'Calle Azul', 'Suances', '2010', 75, '3458H', 120000),
('103', 'Calle Paz', 'Suances', '1990', 45, '4477H', 65000),
('104', 'Plaza Mayor', 'Renedo', '1998', 75, '4531A', 90000),
('105', 'Calle Principal', 'Renedo', '1985', 100, '4531A', 90000),
('106', 'Calle Ancha', 'Torrelavega', '1998', 100, '1230F', 95000),
('107', 'Calle Azul', 'Renedo', '2000', 80, '1230F', 85000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `DNItitular` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`DNItitular`, `nombre`, `telefono`) VALUES
('1230F', 'Miguel', '678654565'),
('1435B', 'Mario', '675656776'),
('3458H', 'Juan', '942534565'),
('4477H', 'Pedro', '942345676'),
('4531A', 'Pepe', '942348976'),
('5690B', 'Carla', '678546590'),
('6711C', 'Amalia', '987567823'),
('7765T', 'Isidro', '942378765');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  ADD PRIMARY KEY (`idinmueble`),
  ADD KEY `NIFpropietario` (`NIFpropietario`),
  ADD KEY `oficina` (`precio`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`DNItitular`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  ADD CONSTRAINT `inmuebles_ibfk_1` FOREIGN KEY (`NIFpropietario`) REFERENCES `propietarios` (`DNItitular`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
