-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 24, 2023 at 09:05 PM
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
-- Database: `ums`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseId`, `Name`, `Code`, `Prerequisite`, `Credits`, `Hours`, `Major`, `Year`, `Semester`) VALUES
(1, 'Intro to CS', 'I1101', 'none', 5, 35, 'Informatics', 1, 1),
(2, 'Computer Architecture', 'I1102', 'none', 5, 40, 'Informatics', 1, 1),
(3, 'Calculus CS', 'I1201', 'none', 4, 35, 'Informatics', 1, 1),
(4, 'Intro to Web Dev', 'I1103', 'none', 4, 40, 'Informatics', 1, 1),
(5, 'Data Structures 1', 'I1104', 'none', 5, 40, 'Informatics', 1, 2),
(6, 'DataBase 1', 'I1105', 'none', 5, 35, 'Informatics', 1, 2),
(7, 'Programming Fundamentals', 'I1106', 'none', 4, 35, 'Informatics', 1, 2),
(8, 'Discrete Math of CS', 'I1202', 'none', 4, 35, 'Informatics', 1, 2),
(9, 'DataBase 2', 'I2201', 'I1105', 5, 40, 'Informatics', 2, 3),
(10, 'C Programming Language', 'I2202', 'none', 5, 40, 'Informatics', 2, 3),
(11, 'Theory of Computation', 'I2203', 'none', 4, 35, 'Informatics', 2, 3),
(12, 'Network 1', 'I2204', 'none', 4, 35, 'Informatics', 2, 3),
(13, 'Operating Systems 1', 'I2205', 'none', 5, 40, 'Informatics', 2, 4),
(14, 'Data Structures 2', 'I2206', 'I1104', 5, 40, 'Informatics', 2, 4),
(15, 'Advanced Web Dev', 'I2207', 'none', 4, 40, 'Informatics', 2, 4),
(16, 'Graphs', 'I2208', 'none', 4, 35, 'Informatics', 2, 4),
(17, 'Object Oriented Programming', 'I3301', 'none', 5, 40, 'Informatics', 3, 5),
(18, 'Software Engineering', 'I3302', 'none', 5, 40, 'Informatics', 3, 5),
(19, 'Network 2', 'I3303', 'I2204', 4, 35, 'Informatics', 3, 5),
(20, 'Info and Society', 'I3304', 'none', 4, 30, 'Informatics', 3, 5),
(21, 'Operating Systems 2', 'I3305', 'I2205', 5, 40, 'Informatics', 3, 6),
(22, 'C#', 'I3306', 'none', 5, 40, 'Informatics', 3, 6),
(23, 'Artificial Intelligence', 'I3307', 'none', 4, 40, 'Informatics', 3, 6),
(24, 'Software Graduation Project', 'I3308', 'none', 4, 30, 'Informatics', 3, 6),
(25, 'Calculus And Analytic Geomerty 1', 'M1101', 'none', 5, 40, 'Math', 1, 1),
(26, 'Differential Equations', 'M1102', 'none', 5, 40, 'Math', 1, 1),
(27, 'Introduction to Analysis', 'M1103', 'none', 4, 35, 'Math', 1, 1),
(28, 'Discrete Structures', 'M1104', 'none', 4, 35, 'Math', 1, 1),
(29, 'Math for Social Sciences 1', 'M1105', 'none', 5, 40, 'Math', 1, 2),
(30, 'Introductory Partial Differential Equations', 'M1106', 'none', 5, 40, 'Math', 1, 2),
(31, 'Higer Geometry', 'M1107', 'none', 4, 30, 'Math', 1, 2),
(32, 'Elementary Linear Algebra with Applications', 'M1108', 'none', 4, 35, 'Math', 1, 2),
(33, 'Calculus And Analytic Geomerty 2', 'M2201', 'M1101', 5, 40, 'Math', 2, 3),
(34, 'Topology 1', 'M2202', 'none', 5, 40, 'Math', 2, 3),
(35, 'Fourier Analysis and Applications', 'M2203', 'none', 4, 35, 'Math', 2, 3),
(36, 'Wavelets and Applications', 'M2204', 'none', 4, 35, 'Math', 2, 3),
(37, 'Math for Social Sciences 2', 'M2205', 'M1105', 5, 40, 'Math', 2, 4),
(38, 'Number Theory', 'M2206', 'none', 5, 40, 'Math', 2, 4),
(39, 'Advanced Probability', 'M2207', 'none', 4, 35, 'Math', 2, 4),
(40, 'Numerical Linear Algebra', 'M2208', 'none', 4, 35, 'Math', 2, 4),
(41, 'Topology 2', 'M3301', 'M2202', 5, 40, 'Math', 3, 5),
(42, 'Abstract Algebra', 'M3302', 'none', 5, 40, 'Math', 3, 5),
(43, 'Numerical Computing', 'M3303', 'none', 4, 35, 'Math', 3, 5),
(44, 'Java', 'M3304', 'none', 4, 35, 'Math', 3, 5),
(45, 'Set Theory', 'M3305', 'M2206', 5, 40, 'Math', 3, 6),
(46, 'Complex Analysis', 'M3306', 'none', 5, 40, 'Math', 3, 6),
(47, 'Topics in Algebra', 'M3307', 'none', 4, 35, 'Math', 3, 6),
(48, 'Senior Project', 'M3308', 'none', 4, 30, 'Math', 3, 6),
(49, 'Introductory Biology', 'B1101', 'none', 5, 40, 'Biology', 1, 1),
(50, 'Basic Concepts in Biology', 'B1102', 'none', 5, 40, 'Biology', 1, 1),
(51, 'Contemporary Issues in Biology', 'B1103', 'none', 4, 35, 'Biology', 1, 1),
(52, 'Concepts and Connections', 'B1104', 'none', 4, 35, 'Biology', 1, 1),
(53, 'General Biology 1', 'B1105', 'none', 5, 40, 'Biology', 1, 2),
(54, 'Diversity of Life', 'B1106', 'none', 5, 40, 'Biology', 1, 2),
(55, 'Human Biology', 'B1107', 'none', 4, 30, 'Biology', 1, 2),
(56, 'Introductory Biochemistry', 'B1108', 'none', 4, 35, 'Biology', 1, 2),
(57, 'Microbiology', 'B2201', 'B1101', 5, 40, 'Biology', 2, 3),
(58, 'Genetics', 'B2202', 'none', 5, 40, 'Biology', 2, 3),
(59, 'Non-Vascular Autotrophs and Fungi', 'B2203', 'none', 4, 35, 'Biology', 2, 3),
(60, 'Vascular Plants', 'B2204', 'none', 4, 35, 'Biology', 2, 3),
(61, 'General Biology 2', 'B2205', 'B1105', 5, 40, 'Biology', 2, 4),
(62, 'Plant Morphology', 'B2206', 'none', 5, 40, 'Biology', 2, 4),
(63, 'Plant Anatomy', 'B2207', 'none', 4, 35, 'Biology', 2, 4),
(64, 'Plant Systematics', 'B2208', 'none', 4, 35, 'Biology', 2, 4),
(65, 'Cell Biology', 'B3301', 'B2202', 5, 40, 'Biology', 3, 5),
(66, 'Biology of Invertebrates', 'B3302', 'none', 5, 40, 'Biology', 3, 5),
(67, 'Behavioral Neuroscience', 'B3303', 'none', 4, 35, 'Biology', 3, 5),
(68, 'Introduction to Neurobiology', 'B3304', 'none', 4, 35, 'Biology', 3, 5),
(69, 'Marine Biology', 'B3305', 'none', 5, 40, 'Biology', 3, 6),
(70, 'Parasitology', 'B3306', 'none', 5, 40, 'Biology', 3, 6),
(71, 'Aquaculture Laboratory', 'B3307', 'none', 4, 35, 'Biology', 3, 6),
(72, 'Senior Project', 'B3308', 'none', 4, 30, 'Biology', 3, 6),
(73, 'Introductory Physics 1', 'P1101', 'none', 5, 40, 'Physics', 1, 1),
(74, 'Physics for the Life Sciences', 'P1102', 'none', 5, 40, 'Physics', 1, 1),
(75, 'Understanding the Universe', 'P1103', 'none', 4, 35, 'Physics', 1, 1),
(76, 'Classical Physics for Life Sciences', 'P1104', 'none', 4, 35, 'Physics', 1, 1),
(77, 'Introductory Physics Laboratory 1', 'P1105', 'none', 5, 40, 'Physics', 1, 2),
(78, 'Classical Physics for Life Sciences', 'P1106', 'none', 5, 40, 'Physics', 1, 2),
(79, 'Modern Physics for Life Sciences', 'P1107', 'none', 4, 30, 'Physics', 1, 2),
(80, 'Calculus', 'P1108', 'none', 4, 35, 'Physics', 1, 2),
(81, 'Introductory Physics 2', 'P2201', 'P1101', 5, 40, 'Physics', 2, 3),
(82, 'Mechanics', 'P2202', 'none', 5, 40, 'Physics', 2, 3),
(83, 'Electricity and Magnetism', 'P2203', 'none', 4, 35, 'Physics', 2, 3),
(84, 'Electricity and Magnetism Laboratory', 'P2204', 'none', 4, 35, 'Physics', 2, 3),
(85, 'Introductory Physics Laboratory 2', 'P2205', 'P1105', 5, 40, 'Physics', 2, 4),
(86, 'Electromagnetic Theory', 'P2206', 'none', 5, 40, 'Physics', 2, 4),
(87, 'Computational Physics', 'P2207', 'none', 4, 35, 'Physics', 2, 4),
(88, 'Physical Optics', 'P2208', 'none', 4, 35, 'Physics', 2, 4),
(89, 'Quantum Mechanics', 'P3301', 'P2202', 5, 40, 'Physics', 3, 5),
(90, 'Introduction to Astronomy and Astrophysics', 'P3302', 'none', 5, 40, 'Physics', 3, 5),
(91, 'Electronics', 'P3303', 'none', 4, 35, 'Physics', 3, 5),
(92, 'Electronics Laboratory', 'P3304', 'none', 4, 35, 'Physics', 3, 5),
(93, 'Plasma Physics', 'P3305', 'none', 5, 40, 'Physics', 3, 6),
(94, 'Nuclear and Elementary Particle Physics', 'P3306', 'none', 5, 40, 'Physics', 3, 6),
(95, 'Statistical Physics', 'P3307', 'none', 4, 35, 'Physics', 3, 6),
(96, 'Senior Project', 'P3308', 'none', 4, 30, 'Physics', 3, 6),
(97, 'Introductory to BioChemistry', 'BC1101', 'none', 5, 40, 'BioChemistry', 1, 1),
(98, 'Basic Concepts in Biology', 'BC1102', 'none', 5, 40, 'BioChemistry', 1, 1),
(99, 'BC for Nursing', 'BC1103', 'none', 4, 35, 'BioChemistry', 1, 1),
(100, 'Medical Lab', 'BC1104', 'none', 4, 35, 'BioChemistry', 1, 1),
(101, 'General Biology', 'BC1105', 'none', 5, 40, 'BioChemistry', 1, 2),
(102, 'Microscopic Biochemistry', 'BC1106', 'none', 5, 40, 'BioChemistry', 1, 2),
(103, 'Diversity of Life', 'BC1107', 'none', 4, 35, 'BioChemistry', 1, 2),
(104, 'Nucleic Acids and Basic Genetics', 'BC1108', 'none', 4, 35, 'BioChemistry', 1, 2),
(105, 'Advanced BioChemistry', 'BC2201', 'BC1101', 5, 40, 'BioChemistry', 2, 3),
(106, 'MicroBiology', 'BC2202', 'none', 5, 40, 'BioChemistry', 2, 3),
(107, 'Protein Biochemistry', 'BC2203', 'none', 4, 35, 'BioChemistry', 2, 3),
(108, 'Cancer Genomics', 'BC2204', 'none', 4, 35, 'BioChemistry', 2, 3),
(109, 'BioInformatics', 'BC2205', 'BC1105', 5, 40, 'BioChemistry', 2, 4),
(110, 'Cellular Metabolism and Regulation', 'BC2206', 'none', 5, 40, 'BioChemistry', 2, 4),
(111, 'Receptors and Signal Transduction', 'BC2207', 'none', 4, 35, 'BioChemistry', 2, 4),
(112, 'Bioinformatics Tools and Applications in Genomics', 'BC2208', 'none', 4, 35, 'BioChemistry', 2, 4),
(113, 'Cell Biology', 'BC3301', 'none', 5, 40, 'BioChemistry', 3, 5),
(114, 'Behavioural Neuroscience', 'BC3302', 'none', 5, 40, 'BioChemistry', 3, 5),
(115, 'Developmental Biochemistry', 'BC3303', 'none', 4, 35, 'BioChemistry', 3, 5),
(116, 'Molecular Biology of Cancer', 'BC3304', 'BC2204', 4, 35, 'BioChemistry', 3, 5),
(117, 'Marine Biology', 'BC3305', 'none', 5, 40, 'BioChemistry', 3, 6),
(118, 'Aquaculture Laboratory', 'BC3306', 'none', 5, 40, 'BioChemistry', 3, 6),
(119, 'BioChemical Methods', 'BC3307', 'none', 4, 35, 'BioChemistry', 3, 6),
(120, 'Senior Project', 'BC3308', 'none', 4, 35, 'BioChemistry', 3, 6),
(121, 'General Chemistry 1', 'C1101', 'none', 5, 40, 'Chemistry', 1, 1),
(122, 'Basic Chemistry and Applications', 'C1102', 'none', 5, 40, 'Chemistry', 1, 1),
(123, 'Basic Concepts in Bio', 'C1103', 'none', 4, 35, 'Chemistry', 1, 1),
(124, 'Introductory Chemistry Laboratory', 'C1104', 'none', 4, 35, 'Chemistry', 1, 1),
(125, 'Introduction to Environmental Chemistry', 'C1105', 'none', 5, 40, 'Chemistry', 1, 2),
(126, 'Chemical Principles', 'C1106', 'none', 5, 40, 'Chemistry', 1, 2),
(127, 'Brief Survey of Organic Chemistry', 'C1107', 'none', 4, 35, 'Chemistry', 1, 2),
(128, 'Organic Laboratory for Non-Majors', 'C1108', 'none', 4, 35, 'Chemistry', 1, 2),
(129, 'General Chemistry 2', 'C2201', 'C1101', 5, 40, 'Chemistry', 2, 3),
(130, 'Organic Chemistry 1', 'C2202', 'none', 5, 40, 'Chemistry', 2, 3),
(131, 'Analytical Chemistry', 'C2203', 'none', 4, 35, 'Chemistry', 2, 3),
(132, 'Analytical Chemistry Laboratory', 'C2204', 'none', 4, 35, 'Chemistry', 2, 3),
(133, 'Advanced Environmental Chemistry', 'C2205', 'C1105', 5, 40, 'Chemistry', 2, 4),
(134, 'Quantitative Analysis', 'C2206', 'none', 5, 40, 'Chemistry', 2, 4),
(135, 'Molecular Structure', 'C2207', 'none', 4, 35, 'Chemistry', 2, 4),
(136, 'Technical Analysis', 'C2208', 'none', 4, 35, 'Chemistry', 2, 4),
(137, 'Organic Structure Determination', 'C3301', 'none', 5, 40, 'Chemistry', 3, 5),
(138, 'Organic Chemistry 2', 'C3302', 'C2202', 5, 40, 'Chemistry', 3, 5),
(139, 'Inorganic Chemistry', 'C3303', 'none', 4, 35, 'Chemistry', 3, 5),
(140, 'Coordination Compounds', 'C3304', 'none', 4, 35, 'Chemistry', 3, 5),
(141, 'Thermodynamics and Chemical Dynamics', 'C3305', 'none', 5, 40, 'Chemistry', 3, 6),
(142, 'Organic Synthesis', 'C3306', 'none', 5, 40, 'Chemistry', 3, 6),
(143, 'Inorganic Synthesis', 'C3307', 'none', 4, 35, 'Chemistry', 3, 6),
(144, 'Senior Project', 'C3308', 'none', 4, 35, 'Chemistry', 3, 6);

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
  `Phone` varchar(20) NOT NULL,
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
  `Phone` varchar(20) NOT NULL,
  `Accepted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructors`
--

INSERT INTO `instructors` (`Id`, `Fname`, `Lname`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Charbel', 'Rahhal', 'Rahal@123', 'charbel_rahal@gmail.com', '03250260', 1),
(2, 'Mohammad', 'Dandash', 'DandashMoe321', 'moedan89@hotmail.com', '70190280', 1),
(3, 'Osama', 'Zein', 'ZeinOs99', 'Osama.Zein@gmail.com', '03300400', 1),
(4, 'Bilal', 'Ghazal', 'SecretBG9', 'ghazal_b@hotmail.com', '71452052', 1),
(5, 'Maha', 'Khatib', 'KhMaha400', 'maha.Kh@gmail.com', '71770860', 1),
(6, 'Hussein', 'Jomaa', 'HJuni#12', 'jomaa_hussein70@gmail.com', '03003300', 1),
(7, 'Osman', 'Khodor', 'KhOs@190', 'osman_khodor@hotmail.com', '70130233', 1),
(8, 'Rima', 'Zaarour', 'rima@zr221', 'rima.zr@hotmail.com', '71451124', 1),
(9, 'Samar', 'Zein', 'Sm#Zn91', 'samar_zein87@gmail.com', '03620720', 1),
(10, 'Mohammad', 'Jradi', 'MjMath@34', 'jradi_moh@gmail.com', '03678867', 1),
(11, 'Maydon', 'Mortada', 'MMort@Uni', 'maydon.mortada88@hotmail.com', '71755760', 1),
(12, 'Elie', 'Moussaed', 'MElie@321', 'elie_moussaed80@gmail.com', '03012013', 1),
(13, 'Ahmad', 'Hamzi', 'SecretPass#4', 'Ahmad.hm2@hotmail.com', '70520830', 1),
(14, 'Lama', 'Moukadem', 'MkLama@#45', 'mokadem.lama@gmail.com', '71030270', 1),
(15, 'Iman', 'Faour', 'FaourIm#996', 'iman_fa@hotmail.com', '71551230', 1),
(16, 'Rami', 'Sayed', 'SaRami@45', 'rami.sayed55@gmail.com', '03203303', 1),
(17, 'Ali', 'Fakih', 'FSB@31', 'fakih.Ali@hotmail.com', '81809010', 1),
(18, 'Samar', 'Tout', 'TS@#134', 'samar_t89@gmail.com', '03500601', 1),
(19, 'Salim', 'Aljamal', 'asJ4@1', 'jamal.salim19@hotmail.com', '70990890', 1),
(20, 'Najat', 'Saghir', 'NajS%@13', 'naj.saghir@hotmail.com', '03425530', 1),
(21, 'Ali', 'Hasan', 'ALi@24', 'ali.Has9@gmail.com', '81880710', 1),
(22, 'Hussein', 'Hajj', 'HajH@454', 'hussein_hajj8@hotmail.com', '81716650', 1),
(23, 'Rana', 'Haidar', 'HRana@hr98', 'rana_haidar@gmail.com', '71019987', 1),
(24, 'Bassem', 'Badran', 'BsBd091', 'badran.bassem97@hotmail.com', '03232909', 1),
(25, 'Zeinab', 'Kasem', 'ZK@#901', 'zeinab_km3@hotmail.com', '70756501', 1),
(26, 'Yara', 'Mansour', 'YMY@189', 'yara_mns9@gmail.com', '81037150', 1),
(27, 'Mohammad', 'Mahmoud', 'MohMoud9@91', 'moe_mahmoud98@hotmail.com', '81543324', 1),
(28, 'Nada', 'Maatouk', 'MNad@321', 'nada_mtk@gmail.com', '03789901', 1),
(29, 'Hassan', 'Siblani', 'SHasB@123', 'siblani_hasan989@gmail.com', '81070111', 1),
(30, 'Fatima', 'Nouredine', 'FN@90#2', 'fatima.nrd@hotmail.com', '71112313', 1);

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
(3, 13),
(3, 17),
(3, 21),
(1, 2),
(1, 10),
(1, 22),
(2, 4),
(2, 6),
(2, 15),
(1, 1),
(4, 3),
(4, 8),
(4, 11),
(2, 5),
(6, 9),
(6, 14),
(6, 23),
(9, 12),
(9, 19),
(8, 7),
(8, 16),
(6, 18),
(3, 24),
(9, 20),
(5, 25),
(4, 26),
(7, 27),
(11, 28),
(10, 29),
(4, 30),
(10, 31),
(7, 32),
(5, 33),
(7, 34),
(11, 35),
(5, 36),
(10, 37),
(5, 38),
(11, 39),
(7, 40),
(7, 41),
(10, 42),
(4, 43),
(3, 44),
(5, 45),
(10, 46),
(11, 47),
(7, 48),
(12, 73),
(13, 74),
(14, 75),
(15, 76),
(16, 77),
(12, 78),
(13, 79),
(14, 80),
(12, 81),
(15, 82),
(16, 83),
(13, 84),
(16, 85),
(12, 86),
(13, 87),
(15, 88),
(15, 89),
(12, 90),
(13, 91),
(14, 92),
(16, 93),
(12, 94),
(13, 95),
(15, 96),
(17, 49),
(18, 50),
(19, 51),
(20, 52),
(21, 53),
(17, 54),
(18, 55),
(19, 56),
(17, 57),
(18, 58),
(19, 59),
(20, 60),
(21, 61),
(17, 62),
(18, 63),
(19, 64),
(18, 65),
(17, 66),
(19, 67),
(20, 68),
(21, 69),
(17, 70),
(18, 71),
(19, 72),
(22, 121),
(23, 122),
(24, 123),
(25, 124),
(26, 125),
(22, 126),
(23, 127),
(24, 128),
(22, 129),
(23, 130),
(24, 131),
(25, 132),
(26, 133),
(22, 134),
(23, 135),
(24, 136),
(22, 137),
(23, 138),
(24, 139),
(25, 140),
(26, 141),
(22, 142),
(23, 143),
(24, 144),
(22, 97),
(17, 98),
(27, 99),
(28, 100),
(18, 101),
(29, 102),
(30, 103),
(27, 104),
(22, 105),
(21, 106),
(28, 107),
(29, 108),
(18, 109),
(30, 110),
(27, 111),
(28, 112),
(18, 113),
(27, 114),
(28, 115),
(29, 116),
(21, 117),
(27, 118),
(28, 119),
(29, 120);

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
  `Accepted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `Fname`, `Lname`, `Major`, `Password`, `Email`, `Phone`, `Accepted`) VALUES
(1, 'Obaida', 'Ammar', 'Informatics', 'ObAmmar99', 'ammarobaida@gmail.com', '03030303', 1),
(2, 'Osama', 'Zammar', 'Informatics', 'OsZam23', 'osama.zammar2@gmail.com', '71707180', 1),
(3, 'Mohammad', 'Aboulfoul', 'Informatics', 'MohAF55', 'moe_alfoul@gmail.com', '70809060', 1),
(4, 'Hadi', 'Kattan', 'Informatics', 'Hadi9K10', 'kattanH@hotmail.com', '81801901', 1),
(5, 'Ali', 'Siblani', 'Informatics', 'SbAli98', 'ali.sbl80@hotmail.com', '71110250', 1),
(6, 'Ahmad', 'Wardani', 'Math', 'WardaniAH2000', 'ahem.wrd2@hotmail.com', '70900600', 1),
(7, 'Zeina', 'Taki', 'Math', 'tkZeina82', 'zein_tk@gmail.com', '03100300', 1),
(8, 'Sara', 'Kaakour', 'Math', 'SrKK98', 'Sara.KK@gmail.com', '81820130', 1),
(9, 'Salem', 'Jarrah', 'Chemistry', 'slmJr@123', 'jarrah_salem@hotmail.com', '81340430', 0),
(10, 'Lama', 'Ghorayeb', 'Physics', 'GhLama#213', 'lama_GH@gmail.com', '70541905', 0),
(11, 'Georges', 'Saad', 'Informatics', 'SaadG@221', 'georges.sd97@gmail.com', '71683873', 1),
(12, 'Ali', 'Mezher', 'Informatics', 'MZali@321', 'ali_mzhr@hotmail.com', '03203304', 1),
(13, 'Salim', 'Awad', 'Math', 'AWS@109', 'away_salim2001@gmail.com', '71110120', 1),
(14, 'Ahmad', 'Tarhini', 'Chemistry', 'AhT@456', 'tarhini.ahmd@hotmail.com', '70861634', 1),
(15, 'Salma', 'Srour', 'Chemistry', 'SrourS#76$', 'salma_sr9@gmail.com', '71616515', 1),
(16, 'Nader', 'Hellani', 'Physics', 'NH99@Hell', 'hellani_ndr@gmail.com', '81578801', 1),
(17, 'Nancy', 'Atat', 'Physics', 'Nancy@@', 'atat.nancy45@hotmail.com', '03900805', 1),
(18, 'Samer', 'Faour', 'Biology', 'SF#887', 'faour.samerr22@hotmail.com', '81222332', 1),
(19, 'Rawan', 'Sayed', 'Biology', 'sayidRayan#9', 'rayan_sayed65@gmail.com', '71100512', 1),
(20, 'Karam', 'Darwich', 'Biology', 'KDDar@990', 'karam_DR@gmail.com', '70698989', 1),
(21, 'Tamara', 'Saad', 'BioChemistry', 'tamS&1243', 'tamara_saad961@hotmail.com', '03443302', 1),
(22, 'Alaa', 'Yousef', 'BioChemistry', 'passYA@741', 'alaa.usef9@gmail.com', '03414913', 1),
(23, 'Nour', 'Kadri', 'BioChemistry', 'NKad%01', 'kadri_nour01@gmail.com', '71321468', 1);

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
(1, 1, '90.50', '2019-2020', 1),
(1, 2, '87.90', '2019-2020', 1),
(1, 3, '91.00', '2019-2020', 1),
(1, 4, '95.00', '2019-2020', 1),
(1, 5, '84.50', '2019-2020', 1),
(1, 6, '90.50', '2019-2020', 1),
(1, 7, '87.40', '2019-2020', 1),
(1, 8, '89.70', '2019-2020', 1),
(1, 9, '88.00', '2020-2021', 1),
(1, 10, '96.00', '2020-2021', 1),
(1, 11, '93.50', '2020-2021', 1),
(1, 12, '85.00', '2020-2021', 1),
(1, 13, '90.00', '2020-2021', 1),
(1, 14, '83.60', '2020-2021', 1),
(1, 15, '88.50', '2020-2021', 1),
(1, 16, '91.00', '2020-2021', 1),
(1, 17, '87.30', '2021-2022', 1),
(1, 18, '93.40', '2021-2022', 1),
(1, 19, '89.00', '2021-2022', 1),
(1, 20, '82.50', '2021-2022', 1),
(1, 21, '91.00', '2021-2022', 1),
(1, 22, '86.80', '2021-2022', 1),
(1, 23, '96.00', '2021-2022', 1),
(1, 24, '90.00', '2021-2022', 1),
(2, 1, '89.50', '2019-2020', 1),
(2, 2, '87.00', '2019-2020', 1),
(2, 3, '91.00', '2019-2020', 1),
(2, 4, '85.80', '20192-2020', 1),
(2, 5, '83.00', '2019-2020', 1),
(2, 6, '92.00', '2019-2020', 1),
(2, 7, '90.00', '2019-2020', 1),
(2, 8, '86.20', '2019-2020', 1),
(2, 9, '84.00', '2020-2021', 1),
(2, 10, '91.50', '2020-2021', 1),
(2, 11, '80.80', '2020-2021', 1),
(2, 12, '93.00', '2020-2021', 1),
(2, 13, '83.50', '2020-2021', 1),
(2, 14, '80.00', '2020-2021', 1),
(2, 15, '86.40', '2020-2021', 1),
(2, 16, '88.00', '2020-2021', 1),
(2, 17, '82.00', '2021-2022', 1),
(2, 18, '89.00', '2021-2022', 1),
(2, 19, '87.00', '2021-2022', 1),
(2, 20, '85.50', '2021-2022', 1),
(2, 21, '84.00', '2021-2022', 1),
(2, 22, '89.20', '2021-2022', 1),
(2, 23, '81.00', '2021-2022', 1),
(2, 24, '86.00', '2021-2022', 1),
(3, 1, '81.00', '2019-2020', 1),
(3, 2, '89.00', '2019-2020', 1),
(3, 3, '88.00', '2019-2020', 1),
(3, 4, '83.50', '2019-2020', 1),
(3, 5, '83.50', '2019-2020', 1),
(3, 6, '91.00', '2019-2020', 1),
(3, 7, '92.00', '2019-2020', 1),
(3, 8, '90.00', '2019-2020', 1),
(3, 9, '88.00', '2020-2021', 1),
(3, 10, '89.00', '2020-2021', 1),
(3, 11, '93.00', '2020-2021', 1),
(3, 12, '90.00', '2020-2021', 1),
(3, 13, '84.00', '2020-2021', 1),
(3, 14, '91.50', '2020-2021', 1),
(3, 15, '82.00', '2020-2021', 1),
(3, 16, '92.50', '2020-2021', 1),
(3, 17, '85.60', '2021-2022', 1),
(3, 18, '81.50', '2021-2022', 1),
(3, 19, '89.00', '2021-2022', 1),
(3, 20, '82.40', '2021-2022', 1),
(3, 21, '87.00', '2021-2022', 1),
(3, 22, '86.00', '2021-2022', 1),
(3, 23, '90.00', '2021-2022', 1),
(3, 24, '83.50', '2021-2022', 1),
(4, 1, '89.00', '2019-2020', 1),
(4, 2, '85.00', '2019-2020', 1),
(4, 3, '92.00', '2019-2020', 1),
(4, 4, '90.00', '2019-2020', 1),
(4, 5, '87.00', '2019-2020', 1),
(4, 6, '83.00', '2019-2020', 1),
(4, 7, '88.00', '2019-2020', 1),
(4, 8, '91.00', '2019-2020', 1),
(4, 9, '85.50', '2020-2021', 1),
(4, 10, '84.50', '2020-2021', 1),
(4, 11, '86.70', '2020-2021', 1),
(4, 12, '85.00', '2020-2021', 1),
(4, 13, '92.50', '2020-2021', 1),
(4, 14, '89.00', '2020-2021', 1),
(4, 15, '86.40', '2020-2021', 1),
(4, 16, '88.40', '2020-2021', 1),
(4, 17, '87.00', '2021-2022', 1),
(4, 18, '81.50', '2021-2022', 1),
(4, 19, '83.00', '2021-2022', 1),
(4, 20, '86.50', '2021-2022', 1),
(4, 21, '87.60', '2021-2022', 1),
(4, 22, '81.00', '2021-2022', 1),
(4, 23, '83.00', '2021-2022', 1),
(4, 24, '80.00', '2021-2022', 1),
(5, 1, '65.00', '2021-2022', 1),
(5, 2, '70.00', '2021-2022', 1),
(5, 3, '55.00', '2021-2022', 1),
(5, 4, '75.50', '2021-2022', 1),
(5, 5, '48.00', '2021-2022', 1),
(5, 6, '68.00', '2021-2022', 1),
(5, 7, '55.50', '2021-2022', 1),
(5, 8, '58.00', '2021-2022', 1),
(5, 9, '-1.00', '2022-2023', 0),
(5, 10, '-1.00', '2022-2023', 0),
(5, 11, '-1.00', '2022-2023', 0),
(5, 12, '-1.00', '2022-2023', 0),
(6, 25, '65.00', '2019-2020', 1),
(6, 26, '78.00', '2019-2020', 1),
(6, 27, '82.00', '2019-2020', 1),
(6, 28, '90.00', '2019-2020', 1),
(6, 29, '78.00', '2019-2020', 1),
(6, 30, '88.00', '2019-2020', 1),
(6, 31, '71.50', '2019-2020', 1),
(6, 32, '67.50', '2019-2020', 1),
(6, 33, '80.00', '2020-2021', 1),
(6, 34, '76.00', '2020-2021', 1),
(6, 35, '85.50', '2020-2021', 1),
(6, 36, '73.00', '2020-2021', 1),
(6, 37, '68.00', '2020-2021', 1),
(6, 38, '84.50', '2020-2021', 1),
(6, 39, '79.00', '2020-2021', 1),
(6, 40, '87.40', '2020-2021', 1),
(6, 41, '68.00', '2021-2022', 1),
(6, 42, '74.00', '2021-2022', 1),
(6, 43, '80.00', '2021-2022', 1),
(6, 44, '81.00', '2021-2022', 1),
(6, 45, '78.00', '2021-2022', 1),
(6, 46, '88.50', '2021-2022', 1),
(6, 47, '76.40', '2021-2022', 1),
(6, 48, '74.00', '2021-2022', 1),
(7, 25, '80.00', '2020-2021', 1),
(7, 26, '73.00', '2020-2021', 1),
(7, 27, '86.00', '2020-2021', 1),
(7, 28, '87.00', '2020-2021', 1),
(7, 29, '69.00', '2020-2021', 1),
(7, 30, '82.00', '2020-2021', 1),
(7, 31, '74.50', '2020-2021', 1),
(7, 32, '70.00', '2020-2021', 1),
(7, 33, '82.00', '2021-2022', 1),
(7, 34, '68.50', '2021-2022', 1),
(7, 35, '81.70', '2021-2022', 1),
(7, 36, '76.00', '2021-2022', 1),
(7, 37, '71.00', '2021-2022', 1),
(7, 38, '86.50', '2021-2022', 1),
(7, 39, '88.00', '2021-2022', 1),
(7, 40, '82.40', '2021-2022', 1),
(7, 41, '-1.00', '2022-2023', 0),
(7, 42, '-1.00', '2022-2023', 0),
(7, 43, '-1.00', '2022-2023', 0),
(7, 44, '-1.00', '2022-2023', 0),
(9, 121, '-1.00', '2022-2023', 0),
(9, 122, '-1.00', '2022-2023', 0),
(9, 123, '-1.00', '2022-2023', 0),
(9, 124, '-1.00', '2022-2023', 0),
(10, 73, '-1.00', '2022-2023', 0),
(10, 74, '-1.00', '2022-2023', 0),
(10, 75, '-1.00', '2022-2023', 0),
(10, 76, '-1.00', '2022-2023', 0),
(11, 1, '68.00', '2020-2021', 1),
(11, 2, '72.00', '2020-2021', 1),
(11, 3, '78.00', '2020-2021', 1),
(11, 4, '81.00', '2020-2021', 1),
(11, 5, '63.00', '2020-2021', 1),
(11, 6, '88.00', '2020-2021', 1),
(11, 7, '73.00', '2020-2021', 1),
(11, 8, '69.50', '2020-2021', 1),
(11, 9, '78.00', '2021-2022', 1),
(11, 10, '65.00', '2021-2022', 1),
(11, 11, '77.50', '2021-2022', 1),
(11, 12, '70.00', '2021-2022', 1),
(11, 13, '80.00', '2021-2022', 1),
(11, 14, '71.00', '2021-2022', 1),
(11, 15, '76.00', '2021-2022', 1),
(11, 16, '82.40', '2021-2022', 1),
(11, 17, '-1.00', '2022-2023', 0),
(11, 18, '-1.00', '2022-2023', 0),
(11, 19, '-1.00', '2022-2023', 0),
(11, 20, '-1.00', '2022-2023', 0),
(12, 1, '-1.00', '2022-2023', 1),
(12, 2, '-1.00', '2022-2023', 1),
(12, 3, '-1.00', '2022-2023', 1),
(12, 4, '-1.00', '2022-2023', 1),
(13, 25, '45.00', '2021-2022', 1),
(13, 26, '65.00', '2021-2022', 1),
(13, 27, '70.00', '2021-2022', 1),
(13, 28, '73.00', '2021-2022', 1),
(13, 29, '69.00', '2021-2022', 1),
(13, 30, '80.00', '2021-2022', 1),
(13, 31, '69.50', '2021-2022', 1),
(13, 32, '65.00', '2021-2022', 1),
(13, 34, '-1.00', '2022-2023', 0),
(13, 35, '-1.00', '2022-2023', 0),
(13, 36, '-1.00', '2022-2023', 0),
(14, 121, '78.60', '2021-2022', 1),
(14, 122, '81.00', '2021-2022', 1),
(14, 123, '70.00', '2021-2022', 1),
(14, 124, '67.00', '2021-2022', 1),
(14, 125, '63.50', '2021-2022', 1),
(14, 126, '60.00', '2021-2022', 1),
(14, 127, '77.00', '2021-2022', 1),
(14, 128, '75.50', '2021-2022', 1),
(14, 129, '-1.00', '2022-2023', 0),
(14, 130, '-1.00', '2022-2023', 0),
(14, 131, '-1.00', '2022-2023', 0),
(14, 132, '-1.00', '2022-2023', 0),
(15, 121, '88.60', '2020-2021', 1),
(15, 122, '78.00', '2020-2021', 1),
(15, 123, '73.50', '2020-2021', 1),
(15, 124, '70.00', '2020-2021', 1),
(15, 125, '69.00', '2020-2021', 1),
(15, 126, '68.40', '2020-2021', 1),
(15, 127, '73.50', '2020-2021', 1),
(15, 128, '77.50', '2020-2021', 1),
(15, 129, '67.00', '2021-2022', 1),
(15, 130, '44.00', '2021-2022', 1),
(15, 131, '68.60', '2021-2022', 1),
(15, 132, '74.00', '2021-2022', 1),
(15, 133, '64.50', '2021-2022', 1),
(15, 134, '72.00', '2021-2022', 1),
(15, 135, '78.60', '2021-2022', 1),
(15, 136, '62.80', '2021-2022', 1),
(15, 137, '-1.00', '2022-2023', 0),
(15, 139, '-1.00', '2022-2023', 0),
(15, 140, '-1.00', '2022-2023', 0),
(16, 73, '87.00', '2021-2022', 1),
(16, 74, '77.00', '2021-2022', 1),
(16, 75, '75.50', '2021-2022', 1),
(16, 76, '87.00', '2021-2022', 1),
(16, 77, '79.50', '2021-2022', 1),
(16, 78, '71.50', '2021-2022', 1),
(16, 79, '84.00', '2021-2022', 1),
(16, 80, '73.50', '2021-2022', 1),
(16, 81, '-1.00', '2022-2023', 0),
(16, 82, '-1.00', '2022-2023', 0),
(16, 83, '-1.00', '2022-2023', 0),
(16, 84, '-1.00', '2022-2023', 0),
(17, 73, '65.00', '2020-2021', 1),
(17, 74, '73.00', '2020-2021', 1),
(17, 75, '77.50', '2020-2021', 1),
(17, 76, '81.00', '2020-2021', 1),
(17, 77, '83.50', '2020-2021', 1),
(17, 78, '79.50', '2020-2021', 1),
(17, 79, '84.00', '2020-2021', 1),
(17, 80, '75.00', '2020-2021', 1),
(17, 81, '72.00', '2021-2022', 1),
(17, 82, '76.00', '2021-2022', 1),
(17, 83, '74.50', '2021-2022', 1),
(17, 84, '81.00', '2021-2022', 1),
(17, 85, '72.50', '2021-2022', 1),
(17, 86, '76.50', '2021-2022', 1),
(17, 87, '85.00', '2021-2022', 1),
(17, 88, '78.00', '2021-2022', 1),
(17, 89, '-1.00', '2022-2023', 0),
(17, 90, '-1.00', '2022-2023', 0),
(17, 91, '-1.00', '2022-2023', 0),
(17, 92, '-1.00', '2022-2023', 0),
(18, 49, '-1.00', '2022-2023', 0),
(18, 50, '-1.00', '2022-2023', 0),
(18, 51, '-1.00', '2022-2023', 0),
(18, 52, '-1.00', '2022-2023', 0),
(19, 49, '67.00', '2021-2022', 1),
(19, 50, '74.50', '2021-2022', 1),
(19, 51, '77.00', '2021-2022', 1),
(19, 52, '70.00', '2021-2022', 1),
(19, 53, '81.00', '2021-2022', 1),
(19, 54, '83.00', '2021-2022', 1),
(19, 55, '72.50', '2021-2022', 1),
(19, 56, '79.00', '2021-2022', 1),
(19, 57, '-1.00', '2022-2023', 0),
(19, 58, '-1.00', '2022-2023', 0),
(19, 59, '-1.00', '2022-2023', 0),
(19, 60, '-1.00', '2022-2023', 0),
(20, 49, '67.00', '2020-2021', 1),
(20, 50, '74.50', '2020-2021', 1),
(20, 51, '77.00', '2020-2021', 1),
(20, 52, '70.00', '2020-2021', 1),
(20, 53, '81.00', '2020-2021', 1),
(20, 54, '83.00', '2020-2021', 1),
(20, 55, '72.50', '2020-2021', 1),
(20, 56, '79.00', '2020-2021', 1),
(20, 57, '75.00', '2021-2022', 1),
(20, 58, '78.50', '2021-2022', 1),
(20, 59, '76.00', '2021-2022', 1),
(20, 60, '82.00', '2021-2022', 1),
(20, 61, '80.00', '2021-2022', 1),
(20, 62, '73.50', '2021-2022', 1),
(20, 63, '77.50', '2021-2022', 1),
(20, 64, '83.50', '2021-2022', 1),
(20, 65, '-1.00', '2022-2023', 0),
(20, 66, '-1.00', '2022-2023', 0),
(20, 67, '-1.00', '2022-2023', 0),
(20, 68, '-1.00', '2022-2023', 0),
(21, 97, '-1.00', '2022-2023', 0),
(21, 98, '-1.00', '2022-2023', 0),
(21, 99, '-1.00', '2022-2023', 0),
(21, 100, '-1.00', '2022-2023', 0),
(22, 97, '80.00', '2021-2022', 1),
(22, 98, '78.00', '2021-2022', 1),
(22, 99, '74.00', '2021-2022', 1),
(22, 100, '82.50', '2021-2022', 1),
(22, 101, '79.00', '2021-2022', 1),
(22, 102, '76.00', '2021-2022', 1),
(22, 103, '72.50', '2021-2022', 1),
(22, 104, '85.00', '2021-2022', 1),
(22, 105, '-1.00', '2022-2023', 0),
(22, 106, '-1.00', '2022-2023', 0),
(22, 107, '-1.00', '2022-2023', 0),
(22, 108, '-1.00', '2022-2023', 0),
(23, 97, '78.00', '2020-2021', 1),
(23, 98, '69.00', '2020-2021', 1),
(23, 99, '71.00', '2020-2021', 1),
(23, 100, '80.00', '2020-2021', 1),
(23, 101, '76.00', '2020-2021', 1),
(23, 102, '71.50', '2020-2021', 1),
(23, 103, '74.00', '2020-2021', 1),
(23, 104, '83.50', '2020-2021', 1),
(23, 105, '68.50', '2021-2022', 1),
(23, 106, '70.00', '2021-2022', 1),
(23, 107, '77.50', '2021-2022', 1),
(23, 108, '85.00', '2021-2022', 1),
(23, 109, '82.00', '2021-2022', 1),
(23, 110, '79.00', '2021-2022', 1),
(23, 111, '86.00', '2021-2022', 1),
(23, 112, '89.00', '2021-2022', 1),
(23, 113, '-1.00', '2022-2023', 0),
(23, 114, '-1.00', '2022-2023', 0),
(23, 115, '-1.00', '2022-2023', 0),
(23, 116, '-1.00', '2022-2023', 0);

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
  `Phone` varchar(20) NOT NULL,
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
  ADD PRIMARY KEY (`Id`,`CourseId`);

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
  MODIFY `CourseId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- AUTO_INCREMENT for table `instructors`
--
ALTER TABLE `instructors`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
