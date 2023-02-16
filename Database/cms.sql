-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 15, 2023 at 10:11 PM
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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Id`, `Fname`, `Lname`, `Email`, `Password`, `Phone`) VALUES
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
  `Prerequisite` varchar(50) NOT NULL,
  `Credits` int(10) NOT NULL,
  `Hours` int(10) NOT NULL,
  `Major` varchar(50) NOT NULL,
  `Year` int(10) NOT NULL,
  `Semester` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseId`, `Name`, `Code`, `Prerequisite`, `Credits`, `Hours`, `Major`, `Year`, `Semester`) VALUES
(1, 'intro CS', 'I1001', 'none', 3, 30, 'Informatics', 1, 1),
(2, 'Algorithm', 'I1002', 'none', 6, 60, 'Informatics', 1, 1),
(3, 'Algorithm2', 'I1003', 'none', 5, 50, 'Informatics', 1, 2),
(4, 'web1', 'I2004', 'none', 4, 40, 'Informatics', 2, 1),
(5, 'java oop', 'I2005', 'none', 5, 50, 'Informatics', 2, 2),
(6, 'web2', 'I3006', 'none', 4, 40, 'Informatics', 3, 1),
(7, 'Graphical user interphase', 'I3007', 'none', 3, 30, 'Informatics', 3, 1),
(10, 'Analysis', 'M2008', 'none', 3, 30, 'Math', 2, 1),
(11, 'Algebra', 'M2011', 'none', 4, 35, 'Math', 2, 1);

--
-- Triggers `course`
--
DELIMITER $$
CREATE TRIGGER `before_delete_course` BEFORE DELETE ON `course` FOR EACH ROW BEGIN
INSERT INTO CourseHistory VALUES(OLD.CourseId,OLD.Name,OLD.Code,OLD.Prerequisite,OLD.Credits,OLD.Hours,OLD.Major,OLD.Year,OLD.Semester,NOW());
UPDATE course SET Prerequisite = 'none' WHERE Prerequisite = OLD.Code;
DELETE FROM studentgrades WHERE studentgrades.CourseId = OLD.CourseId;
DELETE FROM instructorteaches WHERE instructorteaches.CourseID = OLD.CourseId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `CourseHistory`
--

CREATE TABLE `CourseHistory` (
  `CourseId` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Code` varchar(50) NOT NULL,
  `Prerequisite` varchar(50) NOT NULL,
  `Credits` int(10) NOT NULL,
  `Hours` int(10) NOT NULL,
  `Major` varchar(50) NOT NULL,
  `Year` int(10) NOT NULL,
  `Semester` int(10) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `InstructorCourseHistory`
--

CREATE TABLE `InstructorCourseHistory` (
  `InstID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `InstructorHistory`
--

CREATE TABLE `InstructorHistory` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL,
  `Accepted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`Id`, `Fname`, `Lname`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Mohammad', 'Dandash', 'php123', 'moe@dandash.com', 81721345, 1),
(3, 'Osama', 'Zein', 'ZeinOs123', 'os_zein@gmail.com', 30030040, 1),
(4, 'Charbel', 'Rahhal', 'Char321', 'charahal@hotmail.com', 33000033, 1),
(5, 'anonymous', 'anon', 'hacker123', 'anon@gmail.com', 70037181, 0);

--
-- Triggers `instructors`
--
DELIMITER $$
CREATE TRIGGER `before_delete_instructor` BEFORE DELETE ON `instructors` FOR EACH ROW BEGIN
INSERT INTO InstructorHistory VALUES(OLD.Id,OLD.Fname,OLD.Lname,OLD.Password,OLD.Email,OLD.Phone,OLD.Accepted,NOW());
DELETE from instructorteaches WHERE instructorteaches.InstID = OLD.Id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `instructorteaches`
--

CREATE TABLE `instructorteaches` (
  `InstID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructorteaches`
--

INSERT INTO `instructorteaches` (`InstID`, `CourseID`) VALUES
(1, 1),
(1, 2),
(1, 3);

--
-- Triggers `instructorteaches`
--
DELIMITER $$
CREATE TRIGGER `before_delete_instructor_course` BEFORE DELETE ON `instructorteaches` FOR EACH ROW BEGIN
INSERT INTO InstructorCourseHistory VALUES(OLD.InstID,OLD.CourseID,NOW());
END
$$
DELIMITER ;

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
(1, 'Ahmad', 'Majed', 'Math', '123456', 'ahmad@gmail.com', 81370594, 1),
(2, 'Hadi', 'Kattan', 'Informatics', '123', 'hadi@gmail.com', 76488386, 1),
(4, 'Osama', 'Zammar', 'Informatics', '321', 'oz@hotmail.com', 71999000, 1),
(5, 'mohammad', 'Abo alfoul', 'Informatics', '9876', 'moh@gmail.com', 81370598, 1),
(9, 'Obaida', 'Ammar', 'Informatics', 'ObAm123', 'ammarobaida@gmail.com', 3030303, 1),
(11, 'Mostafa', 'Kamal', 'Biology', 'kamal12', 'mostK@hotmail.com', 70970790, 0);

--
-- Triggers `student`
--
DELIMITER $$
CREATE TRIGGER `before_delete_student` BEFORE DELETE ON `student` FOR EACH ROW BEGIN
INSERT INTO StudentHistory VALUES(OLD.Id,OLD.Fname,OLD.Lname,OLD.Major,OLD.Password,OLD.Email,OLD.Phone,OLD.Accepted,NOW());
DELETE FROM studentgrades WHERE studentgrades.Id = OLD.Id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `studentgrades`
--

CREATE TABLE `studentgrades` (
  `Id` int(100) NOT NULL,
  `CourseId` int(100) NOT NULL,
  `Grade` decimal(65,2) DEFAULT NULL,
  `Year` varchar(15) NOT NULL,
  `Submitted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentgrades`
--

INSERT INTO `studentgrades` (`Id`, `CourseId`, `Grade`, `Year`, `Submitted`) VALUES
(2, 1, '91.00', '2021-2022', 0),
(5, 1, '91.00', '2021-2022', 0),
(4, 1, '92.00', '2021-2022', 0),
(9, 2, '89.50', '2020-2021', 0),
(9, 3, '95.00', '2020-2021', 0),
(9, 4, '87.70', '2020-2021', 0),
(9, 6, '95.20', '2020-2021', 0),
(1, 10, '80.00', '2020-2021', 0),
(1, 11, '86.00', '2020-2021', 0);

--
-- Triggers `studentgrades`
--
DELIMITER $$
CREATE TRIGGER `before_delete_student_grades` BEFORE DELETE ON `studentgrades` FOR EACH ROW BEGIN
INSERT INTO StudentGradesHistory VALUES(OLD.Id,OLD.CourseId,OLD.Grade,OLD.Year,OLD.Submitted,NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `StudentGradesHistory`
--

CREATE TABLE `StudentGradesHistory` (
  `Id` int(100) NOT NULL,
  `CourseId` int(100) NOT NULL,
  `Grade` decimal(65,2) NOT NULL,
  `Year` varchar(15) NOT NULL,
  `Submitted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `StudentHistory`
--

CREATE TABLE `StudentHistory` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Major` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` int(10) NOT NULL,
  `Accepted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseId`),
  ADD UNIQUE KEY `Code` (`Code`);

--
-- Indexes for table `CourseHistory`
--
ALTER TABLE `CourseHistory`
  ADD PRIMARY KEY (`CourseId`);

--
-- Indexes for table `InstructorCourseHistory`
--
ALTER TABLE `InstructorCourseHistory`
  ADD PRIMARY KEY (`InstID`,`CourseID`);

--
-- Indexes for table `InstructorHistory`
--
ALTER TABLE `InstructorHistory`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `instructorteaches`
--
ALTER TABLE `instructorteaches`
  ADD KEY `instructorteaches_instructor_r1` (`InstID`),
  ADD KEY `instructorteaches_courses_r1` (`CourseID`);

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
-- Indexes for table `StudentGradesHistory`
--
ALTER TABLE `StudentGradesHistory`
  ADD PRIMARY KEY (`Id`,`CourseId`);

--
-- Indexes for table `StudentHistory`
--
ALTER TABLE `StudentHistory`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `CourseId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `instructors`
--
ALTER TABLE `instructors`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
