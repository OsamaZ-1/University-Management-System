-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 19, 2023 at 04:21 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2023 at 09:29 PM
-- Server version: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
  `Phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Id`, `Fname`, `Lname`, `Email`, `Password`, `Phone`) VALUES
(1, 'admin', 'admin', 'admin1@gmail.com', 'Admin1123', '70711770'),
(2, 'Admin', 'University', 'admin2@gmail.com', 'Admin2123', '71717171');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseId`, `Name`, `Code`, `Prerequisite`, `Credits`, `Hours`, `Major`, `Year`, `Semester`) VALUES
(1, 'intro CS', 'I1001', 'none', 3, 30, 'Informatics', 1, 1),
(2, 'Algorithm', 'I1002', 'none', 6, 60, 'Informatics', 1, 1),
(3, 'Algorithm2', 'I1003', 'none', 5, 50, 'Informatics', 1, 2),
(4, 'web1', 'I2004', 'none', 4, 40, 'Informatics', 2, 3),
(5, 'java oop', 'I2005', 'none', 5, 50, 'Informatics', 2, 4),
(6, 'web2', 'I3006', 'none', 4, 40, 'Informatics', 3, 5),
(7, 'Graphical user interphase', 'I3007', 'none', 3, 30, 'Informatics', 3, 5),
(10, 'Analysis', 'M2008', 'none', 3, 30, 'Math', 2, 3),
(11, 'Algebra', 'M2011', 'none', 4, 35, 'Math', 2, 3);

--
-- Triggers `course`
--
DELIMITER $$

CREATE TRIGGER `before_delete_course` AFTER DELETE ON `course` FOR EACH ROW BEGIN
INSERT INTO CourseHistory VALUES(OLD.CourseId,OLD.Name,OLD.Code,OLD.Prerequisite,OLD.Credits,OLD.Hours,OLD.Major,OLD.Year,OLD.Semester,NOW());
DELETE FROM studentgrades WHERE studentgrades.CourseId = OLD.CourseId;
DELETE FROM instructorteaches WHERE instructorteaches.CourseID = OLD.CourseId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `coursehistory`
--

CREATE TABLE `coursehistory` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `instructorcoursehistory`
--

CREATE TABLE `instructorcoursehistory` (
  `InstID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `instructorhistory`
--

CREATE TABLE `instructorhistory` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Accepted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Phone` varchar(20) NOT NULL,
  `Accepted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`Id`, `Fname`, `Lname`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Mohammad', 'Dandash', 'php123', 'moe@dandash.com', '81721345', 1),
(3, 'Osama', 'Zein', 'ZeinOs123', 'os_zein@gmail.com', '30030040', 1),
(4, 'Charbel', 'Rahhal', 'Char321', 'charahal@hotmail.com', '33000033', 1),
(5, 'anonymous', 'anon', 'hacker123', 'anon@gmail.com', '70037181', 0);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Phone` varchar(20) NOT NULL,
  `Accepted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `Fname`, `Lname`, `Major`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Ahmad', 'Majed', 'Math', '123456', 'ahmad@gmail.com', '81370594', 1),
(2, 'Hadi', 'Kattan', 'Informatics', '123', 'hadi@gmail.com', '76488386', 1),
(4, 'Osama', 'Zammar', 'Informatics', '321', 'oz@hotmail.com', '71999000', 1),
(5, 'mohammad', 'Abo alfoul', 'Informatics', '9876', 'moh@gmail.com', '81370598', 1),
(9, 'Obaida', 'Ammar', 'Informatics', 'ObAm123', 'ammarobaida@gmail.com', '03030303', 1),
(11, 'Mostafa', 'Kamal', 'Biology', 'kamal12', 'mostK@hotmail.com', '70970790', 0);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentgrades`
--

INSERT INTO `studentgrades` (`Id`, `CourseId`, `Grade`, `Year`, `Submitted`) VALUES
(2, 1, '91.00', '2021-2022', 1),
(5, 1, '91.00', '2021-2022', 1),
(4, 1, '92.00', '2021-2022', 1),
(9, 2, '93.00', '2020-2021', 1),
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
-- Table structure for table `studentgradeshistory`
--

CREATE TABLE `studentgradeshistory` (
  `Id` int(100) NOT NULL,
  `CourseId` int(100) NOT NULL,
  `Grade` decimal(65,2) NOT NULL,
  `Year` varchar(15) NOT NULL,
  `Submitted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `studenthistory`
--

CREATE TABLE `studenthistory` (
  `Id` int(100) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Major` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Accepted` tinyint(1) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studenthistory`
--

INSERT INTO `studenthistory` (`Id`, `Fname`, `Lname`, `Major`, `Password`, `Email`, `Phone`, `Accepted`, `Date`) VALUES
(13, 'Ali', 'Siblani', 'Informatics', 'Siblani', 'siblani@hotmail.com', '3303990', 0, '2023-02-18');

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
-- Indexes for table `coursehistory`
--
ALTER TABLE `coursehistory`
  ADD PRIMARY KEY (`CourseId`);

--
-- Indexes for table `instructorcoursehistory`
--
ALTER TABLE `instructorcoursehistory`
  ADD PRIMARY KEY (`InstID`,`CourseID`);

--
-- Indexes for table `instructorhistory`
--
ALTER TABLE `instructorhistory`
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
-- Indexes for table `studentgradeshistory`
--
ALTER TABLE `studentgradeshistory`
  ADD PRIMARY KEY (`Id`,`CourseId`);

--
-- Indexes for table `studenthistory`
--
ALTER TABLE `studenthistory`
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
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
