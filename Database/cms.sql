-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 10, 2023 at 03:45 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`Id`, `Fname`, `Lname`, `Email`, `Password`, `Phone`) VALUES
(1, 'admin', 'admin', 'admin1@gmail.com', 'Admin1123', 70711770),
(2, 'Admin', 'University', 'admin2@gmail.com', 'Admin2123', 71717171);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `CourseId` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Code` varchar(50) NOT NULL,
  `Credits` int(10) NOT NULL,
  `Hours` int(10) NOT NULL,
  `Major` varchar(50) NOT NULL,
  `Year` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseId`, `Name`, `Code`, `Credits`, `Hours`, `Major`, `Year`) VALUES
(1, 'Intro CS', 'I1001', 3, 30, 'Informatics', 1),
(2, 'Algorithm', 'I1002', 6, 60, 'Informatics', 1),
(3, 'Algorithm2', 'I1003', 5, 50, 'Informatics', 1),
(4, 'web1', 'I2004', 4, 40, 'Informatics', 2),
(5, 'java oop', 'I2005', 5, 50, 'Informatics', 2),
(6, 'web2', 'I3006', 4, 40, 'Informatics', 3),
(7, 'Graphical user interphase', 'I3007', 3, 30, 'Informatics', 3);

-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

CREATE TABLE `instructors` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL,
  `Accepted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`Id`, `Fname`, `Lname`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Mohammad', 'Dandash', 'php123', 'moe@dandash.com', 81721345, 1),
(3, 'Osama', 'Zein', 'ZeinOs123', 'os_zein@gmail.com', 30030040, 1),
(4, 'Charbel', 'Rahhal', 'Char321', 'charahal@hotmail.com', 33000033, 1),
(5, 'anonymous', 'anon', 'hacker123', 'anon@gmail.com', 70037181, 0);

-- --------------------------------------------------------

--
-- Table structure for table `instructorteaches`
--

CREATE TABLE `instructorteaches` (
  `InstID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `instructorteaches`
--

INSERT INTO `instructorteaches` (`InstID`, `CourseID`) VALUES
(1, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Major` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL,
  `Accepted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `Fname`, `Lname`, `Major`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'ahmad', 'majed', 'Math', '12345', 'ahmad@gmail.com', 81370594, 1),
(2, 'Hadi', 'Kattan', 'Computer Science', '123', 'hadi@gmail.com', 76488386, 1),
(4, 'Osama', 'Zammar', 'Computer Science', '321', 'oz@hotmail.com', 71999000, 1),
(5, 'mohammad', 'Abo alfoul', 'Computer Science', '9876', 'moh@gmail.com', 81370598, 1),
(9, 'Obaida', 'Ammar', 'Computer Science', 'ObAm123', 'ammarobaida@gmail.com', 3030303, 1),
(11, 'Mostafa', 'Kamal', 'Biology', 'kamal12', 'mostK@hotmail.com', 70970790, 0);

-- --------------------------------------------------------

--
-- Table structure for table `studentgrades`
--

CREATE TABLE `studentgrades` (
  `Id` int(100) NOT NULL,
  `CourseId` int(100) NOT NULL,
  `Grade` decimal(65,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `studentgrades`
--

INSERT INTO `studentgrades` (`Id`, `CourseId`, `Grade`) VALUES
(1, 1, '85.00'),
(1, 2, '80.00'),
(1, 3, '50.00'),
(1, 4, '50.00'),
(1, 5, '25.00'),
(2, 1, '91.00'),
(5, 1, '91.00'),
(4, 1, '91.00'),
(1, 6, '-1.00'),
(9, 2, '89.50'),
(9, 3, '95.00'),
(9, 4, '87.70'),
(9, 6, '95.20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseId`),
  ADD UNIQUE KEY `Code` (`Code`);

--
-- Indexes for table `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `studentgrades`
--
ALTER TABLE `studentgrades`
  ADD KEY `Id` (`Id`),
  ADD KEY `CourseId` (`CourseId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `CourseId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `instructors`
--
ALTER TABLE `instructors`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `studentgrades`
--
ALTER TABLE `studentgrades`
  ADD CONSTRAINT `studentgrades_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `student` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
