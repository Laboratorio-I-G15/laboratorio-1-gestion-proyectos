-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-06-2023 a las 01:31:59
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `leotoloza_proyectogestion`
--
CREATE DATABASE IF NOT EXISTS `leotoloza_proyectogestion` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `leotoloza_proyectogestion`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

DROP TABLE IF EXISTS `comentario`;
CREATE TABLE IF NOT EXISTS `comentario` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `comentario` text COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_avance` date NOT NULL,
  `id_tarea` int NOT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_tarea` (`id_tarea`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `comentario`
--

TRUNCATE TABLE `comentario`;
--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`id_comentario`, `comentario`, `fecha_avance`, `id_tarea`) VALUES
(1, 'Verificar altura respecto piso final', '2023-06-20', 1),
(2, 'Altura flor ducha 2.15 sobre nivel piso ducha', '2023-06-20', 1),
(3, 'NADA ', '2023-06-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE IF NOT EXISTS `equipo` (
  `id_equipo` int NOT NULL AUTO_INCREMENT,
  `id_proyecto` int NOT NULL,
  `nombre_equipo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha_creacion_equipo` date DEFAULT NULL,
  `estado_equipo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_equipo`),
  KEY `id_proyecto` (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `equipo`
--

TRUNCATE TABLE `equipo`;
--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id_equipo`, `id_proyecto`, `nombre_equipo`, `fecha_creacion_equipo`, `estado_equipo`) VALUES
(1, 1, 'Plomeria', '2023-06-20', 1),
(2, 1, 'Electricidad', '2023-06-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo_miembro`
--

DROP TABLE IF EXISTS `equipo_miembro`;
CREATE TABLE IF NOT EXISTS `equipo_miembro` (
  `id_miembro_eq` int NOT NULL AUTO_INCREMENT,
  `fecha_inscripcion` date DEFAULT NULL,
  `id_equipo` int NOT NULL,
  `id_miembro` int NOT NULL,
  PRIMARY KEY (`id_miembro_eq`),
  KEY `id_equipo` (`id_equipo`,`id_miembro`),
  KEY `id_miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `equipo_miembro`
--

TRUNCATE TABLE `equipo_miembro`;
--
-- Volcado de datos para la tabla `equipo_miembro`
--

INSERT INTO `equipo_miembro` (`id_miembro_eq`, `fecha_inscripcion`, `id_equipo`, `id_miembro`) VALUES
(1, '2023-06-20', 1, 1),
(2, '2023-06-20', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembro`
--

DROP TABLE IF EXISTS `miembro`;
CREATE TABLE IF NOT EXISTS `miembro` (
  `id_miembro` int NOT NULL AUTO_INCREMENT,
  `dni` int NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_miembro`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `miembro`
--

TRUNCATE TABLE `miembro`;
--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`id_miembro`, `dni`, `apellido`, `nombre`, `estado`) VALUES
(1, 123456789, 'LOPEZ', 'E. Rafael', 1),
(2, 12345678, 'GOMEZ', 'Juan Jose', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE IF NOT EXISTS `proyecto` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `nombre_proyecto` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion_proyecto` text COLLATE utf8mb4_general_ci,
  `fecha_inicio_proyecto` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `proyecto`
--

TRUNCATE TABLE `proyecto`;
--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`id_proyecto`, `nombre_proyecto`, `descripcion_proyecto`, `fecha_inicio_proyecto`, `estado`) VALUES
(1, 'Casa MAKENA ', 'Construcion casa MAKENA, 200 m2. Hubicacion Juana Koslay', '2023-06-20', 1),
(2, 'Casa JUNIN', 'Casa de 320 m2 en Potrero de Los Funes', '2023-06-20', 1),
(3, 'Pintura Falcon ', 'Pintar a fondo falcon 65, restaurado original', '2023-06-20', 1),
(4, 'Intalacion electrica Fabrica ZANELLA San Luis', 'Verificar instalacion trifasica linea embalaje', '2023-06-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

DROP TABLE IF EXISTS `tarea`;
CREATE TABLE IF NOT EXISTS `tarea` (
  `id_tarea` int NOT NULL AUTO_INCREMENT,
  `nombre_tarea` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_inicio_tarea` date NOT NULL,
  `fecha_fin_tarea` date NOT NULL,
  `estado_tarea` tinyint(1) NOT NULL,
  `id_miembro_equipo` int NOT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_miembro_equipo` (`id_miembro_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncar tablas antes de insertar `tarea`
--

TRUNCATE TABLE `tarea`;
--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id_tarea`, `nombre_tarea`, `fecha_inicio_tarea`, `fecha_fin_tarea`, `estado_tarea`, `id_miembro_equipo`) VALUES
(1, 'Canaleteo Baño PA', '2023-06-20', '2023-06-21', 3, 1),
(2, 'Canaleteo Baño Ducha', '2023-06-20', '2023-06-21', 3, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_tarea`) REFERENCES `tarea` (`id_tarea`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`);

--
-- Filtros para la tabla `equipo_miembro`
--
ALTER TABLE `equipo_miembro`
  ADD CONSTRAINT `equipo_miembro_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`),
  ADD CONSTRAINT `equipo_miembro_ibfk_2` FOREIGN KEY (`id_miembro`) REFERENCES `miembro` (`id_miembro`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`id_miembro_equipo`) REFERENCES `equipo_miembro` (`id_miembro_eq`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
