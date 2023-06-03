-- phpMyAdmin SQL Dump
-- version 5.1.4
-- https://www.phpmyadmin.net/
--
-- Host: mysql-leotoloza.alwaysdata.net
-- Generation Time: Jun 03, 2023 at 07:52 PM
-- Server version: 10.6.11-MariaDB
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `leotoloza_proyectogestion`
--

-- --------------------------------------------------------

--
-- Table structure for table `Comentarios`
--

CREATE TABLE `Comentarios` (
  `idComentario` int(11) NOT NULL,
  `comentario` text NOT NULL,
  `fechaAvance` date NOT NULL,
  `idTarea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Equipo`
--

CREATE TABLE `Equipo` (
  `idEquipo` int(11) NOT NULL,
  `idProyecto` int(11) NOT NULL,
  `nombreEquipo` varchar(50) DEFAULT NULL,
  `fechaCreacionEquipo` date DEFAULT NULL,
  `estadoEquipo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `EquipoMiembro`
--

CREATE TABLE `EquipoMiembro` (
  `idMiembroEq` int(11) NOT NULL,
  `fechaInscripcion` date DEFAULT NULL,
  `idEquipo` int(11) NOT NULL,
  `idMiembro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Miembro`
--

CREATE TABLE `Miembro` (
  `idMiembro` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Proyecto`
--

CREATE TABLE `Proyecto` (
  `idProyecto` int(11) NOT NULL,
  `nombreProyecto` varchar(50) DEFAULT NULL,
  `descripcionProyecto` text DEFAULT NULL,
  `fechaInicioProyecto` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Tarea`
--

CREATE TABLE `Tarea` (
  `idTarea` int(11) NOT NULL,
  `nombreTarea` varchar(100) NOT NULL,
  `fechaInicioTarea` date NOT NULL,
  `fechaFinTarea` date NOT NULL,
  `estadoTarea` tinyint(1) NOT NULL,
  `idMiembroEquipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Comentarios`
--
ALTER TABLE `Comentarios`
  ADD PRIMARY KEY (`idComentario`),
  ADD KEY `idTarea` (`idTarea`);

--
-- Indexes for table `Equipo`
--
ALTER TABLE `Equipo`
  ADD PRIMARY KEY (`idEquipo`),
  ADD KEY `idProyecto` (`idProyecto`);

--
-- Indexes for table `EquipoMiembro`
--
ALTER TABLE `EquipoMiembro`
  ADD PRIMARY KEY (`idMiembroEq`),
  ADD KEY `idEquipo` (`idEquipo`,`idMiembro`),
  ADD KEY `idMiembro` (`idMiembro`);

--
-- Indexes for table `Miembro`
--
ALTER TABLE `Miembro`
  ADD PRIMARY KEY (`idMiembro`);

--
-- Indexes for table `Proyecto`
--
ALTER TABLE `Proyecto`
  ADD PRIMARY KEY (`idProyecto`);

--
-- Indexes for table `Tarea`
--
ALTER TABLE `Tarea`
  ADD PRIMARY KEY (`idTarea`),
  ADD KEY `idMiembroEquipo` (`idMiembroEquipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Comentarios`
--
ALTER TABLE `Comentarios`
  MODIFY `idComentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Equipo`
--
ALTER TABLE `Equipo`
  MODIFY `idEquipo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `EquipoMiembro`
--
ALTER TABLE `EquipoMiembro`
  MODIFY `idMiembroEq` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Proyecto`
--
ALTER TABLE `Proyecto`
  MODIFY `idProyecto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Tarea`
--
ALTER TABLE `Tarea`
  MODIFY `idTarea` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Comentarios`
--
ALTER TABLE `Comentarios`
  ADD CONSTRAINT `Comentarios_ibfk_1` FOREIGN KEY (`idTarea`) REFERENCES `Tarea` (`idTarea`);

--
-- Constraints for table `Equipo`
--
ALTER TABLE `Equipo`
  ADD CONSTRAINT `Equipo_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `Proyecto` (`idProyecto`);

--
-- Constraints for table `EquipoMiembro`
--
ALTER TABLE `EquipoMiembro`
  ADD CONSTRAINT `EquipoMiembro_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `Equipo` (`idEquipo`),
  ADD CONSTRAINT `EquipoMiembro_ibfk_2` FOREIGN KEY (`idMiembro`) REFERENCES `Miembro` (`idMiembro`);

--
-- Constraints for table `Tarea`
--
ALTER TABLE `Tarea`
  ADD CONSTRAINT `Tarea_ibfk_1` FOREIGN KEY (`idMiembroEquipo`) REFERENCES `EquipoMiembro` (`idMiembroEq`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
