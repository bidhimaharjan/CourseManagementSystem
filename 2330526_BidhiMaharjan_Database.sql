-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 10, 2024 at 09:35 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CMS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`ID`, `Name`, `Phone`, `Email`, `Password`) VALUES
(1, 'Bidhi Maharjan', '9840173393', 'bidhi@gmail.com', 'bidhi');

-- --------------------------------------------------------

--
-- Table structure for table `Assignment`
--

CREATE TABLE `Assignment` (
  `AssignmentID` int(11) NOT NULL,
  `InstructorID` int(11) DEFAULT NULL,
  `ModuleCode` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Assignment`
--

INSERT INTO `Assignment` (`AssignmentID`, `InstructorID`, `ModuleCode`) VALUES
(1, 1, 'CS003'),
(2, 1, 'CS014'),
(3, 2, 'CS023'),
(4, 2, 'CS036'),
(7, 4, 'IT004'),
(9, 4, 'IT019'),
(10, 6, 'BM009'),
(11, 6, 'BM015'),
(12, 3, 'CI007'),
(13, 3, 'CI016'),
(14, 9, 'CI025'),
(15, 9, 'CI038'),
(16, 5, 'IT027'),
(17, 5, 'IT031'),
(18, 7, 'BM022'),
(19, 7, 'BM034'),
(20, 8, 'BA006'),
(21, 8, 'BA011'),
(22, 10, 'BA029'),
(24, 10, 'BA032');

-- --------------------------------------------------------

--
-- Table structure for table `Course`
--

CREATE TABLE `Course` (
  `CourseCode` varchar(5) NOT NULL,
  `CourseName` varchar(100) DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Course`
--

INSERT INTO `Course` (`CourseCode`, `CourseName`, `Duration`) VALUES
('NP101', 'BSc. (Hons) Computer Science (BCS)', 3),
('NP103', 'Bachelor in Information Technology (BIT)', 3),
('NP109', 'BSc. CSIT', 3),
('NP127', 'Bachelor in International Business Management (BIBM)', 3),
('NP133', 'Bachelor in Business Administration (BBA)', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Enrollment`
--

CREATE TABLE `Enrollment` (
  `EnrollmentID` int(11) NOT NULL,
  `Student_Email` varchar(50) DEFAULT NULL,
  `ModuleCode` varchar(5) DEFAULT NULL,
  `Marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Enrollment`
--

INSERT INTO `Enrollment` (`EnrollmentID`, `Student_Email`, `ModuleCode`, `Marks`) VALUES
(1, 'luzah@gmail.com', 'BM009', 89),
(2, 'luzah@gmail.com', 'BM015', 88),
(3, 'luzah@gmail.com', 'BM022', 86),
(4, 'luzah@gmail.com', 'BM034', 90),
(5, 'eliza@gmail.com', 'CS003', 81),
(6, 'eliza@gmail.com', 'CS014', 75),
(7, 'eliza@gmail.com', 'CS023', 87),
(8, 'eliza@gmail.com', 'CS036', 78),
(9, 'shriya@gmail.com', 'BM009', 77),
(10, 'shriya@gmail.com', 'BM015', 81),
(11, 'shriya@gmail.com', 'BM022', 82),
(12, 'shriya@gmail.com', 'BM034', 78),
(13, 'yajju@gmail.com', 'IT004', 95),
(14, 'yajju@gmail.com', 'IT019', 89),
(15, 'yajju@gmail.com', 'IT027', 92),
(16, 'yajju@gmail.com', 'IT031', 85),
(17, 'sujita@gmail.com', 'IT004', 81),
(18, 'sujita@gmail.com', 'IT019', 83),
(19, 'sujita@gmail.com', 'IT027', 73),
(20, 'sujita@gmail.com', 'IT031', 79),
(21, 'sambriddhi@gmail.com', 'CS003', 62),
(22, 'sambriddhi@gmail.com', 'CS014', 75),
(23, 'sambriddhi@gmail.com', 'CS023', 79),
(24, 'sambriddhi@gmail.com', 'CS036', 84),
(25, 'sushmita@gmail.com', 'CI007', 52),
(26, 'sushmita@gmail.com', 'CI016', 49),
(27, 'sushmita@gmail.com', 'CI025', 67),
(28, 'sushmita@gmail.com', 'CI038', 61),
(29, 'sanjana@gmail.com', 'IT004', 86),
(30, 'sanjana@gmail.com', 'IT019', 79),
(31, 'sanjana@gmail.com', 'IT027', 81),
(32, 'sanjana@gmail.com', 'IT031', 88),
(35, 'harry@gmail.com', 'BM009', 72),
(36, 'harry@gmail.com', 'BM015', 73),
(37, 'harry@gmail.com', 'BM022', 67),
(38, 'harry@gmail.com', 'BM034', 60),
(39, 'pratik@gmail.com', 'CI007', 82),
(40, 'pratik@gmail.com', 'CI016', 79),
(41, 'pratik@gmail.com', 'CI025', 70),
(42, 'pratik@gmail.com', 'CI038', 79),
(43, 'aayush@gmail.com', 'CI007', 56),
(44, 'aayush@gmail.com', 'CI016', 53),
(45, 'aayush@gmail.com', 'CI025', 52),
(46, 'aayush@gmail.com', 'CI038', 58),
(47, 'shristi@gmail.com', 'BA006', NULL),
(48, 'shristi@gmail.com', 'BA011', NULL),
(49, 'shristi@gmail.com', 'BA029', NULL),
(50, 'shristi@gmail.com', 'BA032', NULL),
(51, 'john@gmail.com', 'BA006', NULL),
(52, 'john@gmail.com', 'BA011', NULL),
(53, 'john@gmail.com', 'BA029', NULL),
(54, 'john@gmail.com', 'BA032', NULL),
(55, 'abhi@gmail.com', 'BA006', NULL),
(56, 'abhi@gmail.com', 'BA011', NULL),
(57, 'abhi@gmail.com', 'BA029', NULL),
(58, 'abhi@gmail.com', 'BA032', NULL),
(59, 'mikasa@gmail.com', 'CS003', 41),
(60, 'mikasa@gmail.com', 'CS014', 30),
(61, 'mikasa@gmail.com', 'CS023', 50),
(62, 'mikasa@gmail.com', 'CS036', 25),
(63, 'rina@gmail.com', 'CS003', 72),
(64, 'rina@gmail.com', 'CS014', 55),
(65, 'rina@gmail.com', 'CS023', 72),
(66, 'rina@gmail.com', 'CS036', 78),
(67, 'lisa@gmail.com', 'BA006', NULL),
(68, 'lisa@gmail.com', 'BA011', NULL),
(69, 'lisa@gmail.com', 'BA029', NULL),
(70, 'lisa@gmail.com', 'BA032', NULL),
(71, 'ram@gmail.com', 'BM009', 21),
(72, 'ram@gmail.com', 'BM015', 35),
(73, 'ram@gmail.com', 'BM022', 41),
(74, 'ram@gmail.com', 'BM034', 33),
(75, 'supriya@gmail.com', 'CI007', 39),
(76, 'supriya@gmail.com', 'CI016', 55),
(77, 'supriya@gmail.com', 'CI025', 39),
(78, 'supriya@gmail.com', 'CI038', 59);

-- --------------------------------------------------------

--
-- Table structure for table `Instructor`
--

CREATE TABLE `Instructor` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Course` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Instructor`
--

INSERT INTO `Instructor` (`ID`, `Name`, `Phone`, `Email`, `Password`, `Course`) VALUES
(1, 'Sajag Silwal', '9851082327', 'sajag@gmail.com', 'sajag', 'NP101'),
(2, 'Raj Pradhan', '9849214626', 'raj@gmail.com', 'raj', 'NP103'),
(3, 'Jenny Rajak', '9813670419', 'jenny@gmail.com', 'jenny', 'NP109'),
(4, 'Saurabh Chaudhary', '9855208873', 'saurabh@gmail.com', 'saurabh', 'NP127'),
(5, 'Sunita Parajuli', '9841743989', 'sunita@gmail.com', 'sunita', 'NP133'),
(6, 'Yangji Sherpa', '9803621508', 'yangji@gmail.com', 'yangji', 'NP101'),
(7, 'Nita Kc', '9851028483', 'nita@gmail.com', 'nita', 'NP127'),
(8, 'Pradip Gurung', '9741469052', 'pradip@gmail.com', 'pradip', 'NP103'),
(9, 'Bikash Lama', '9823076128', 'bikash@gmail.com', 'bikash', 'NP109'),
(10, 'Suzta Maharjan', '9849026731', 'suzta@gmail.com', 'suzta', 'NP133');

-- --------------------------------------------------------

--
-- Table structure for table `Module`
--

CREATE TABLE `Module` (
  `ModuleCode` varchar(5) NOT NULL,
  `ModuleName` varchar(100) DEFAULT NULL,
  `CourseCode` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Module`
--

INSERT INTO `Module` (`ModuleCode`, `ModuleName`, `CourseCode`) VALUES
('BA006', 'Economics', 'NP133'),
('BA011', 'Financial accounting', 'NP133'),
('BA029', 'Business Communication', 'NP133'),
('BA032', 'Microeconomics', 'NP133'),
('BM009', 'International Business', 'NP127'),
('BM015', 'Marketing', 'NP127'),
('BM022', 'Principles of Management', 'NP127'),
('BM034', 'Business Finance', 'NP127'),
('CI007', 'Computational Mathematics', 'NP109'),
('CI016', 'Wireless Networking', 'NP109'),
('CI025', 'Fundamentals of Computing', 'NP109'),
('CI038', 'C Programming', 'NP109'),
('CS003', 'Object Oriented programming and Design', 'NP101'),
('CS014', 'Concepts and Technologies of AI', 'NP101'),
('CS023', 'Numerical Methods and Concurrency', 'NP101'),
('CS036', 'Internet Software Architecture', 'NP101'),
('IT004', 'Web Technology', 'NP103'),
('IT019', 'Fundamentals of Information Technology', 'NP103'),
('IT027', 'Introductory Programming', 'NP103'),
('IT031', 'Digital Logic', 'NP103');

-- --------------------------------------------------------

--
-- Table structure for table `Result`
--

CREATE TABLE `Result` (
  `ResultID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `Student_Email` varchar(30) DEFAULT NULL,
  `Grade` varchar(4) DEFAULT NULL,
  `Year` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Result`
--

INSERT INTO `Result` (`ResultID`, `StudentID`, `Student_Email`, `Grade`, `Year`) VALUES
(1, 1, 'eliza@gmail.com', 'A', '1'),
(2, 12, 'sambriddhi@gmail.com', 'A', '1'),
(3, 5, 'sushmita@gmail.com', 'C', '1'),
(7, 16, 'mikasa@gmail.com', 'Fail', '1'),
(8, 18, 'rina@gmail.com', 'B', '1'),
(10, 2, 'luzah@gmail.com', 'A', '1'),
(11, 3, 'shriya@gmail.com', 'A', '1'),
(13, 20, 'ram@gmail.com', 'Fail', '1'),
(16, 14, 'yajju@gmail.com', 'A', '1'),
(18, 4, 'supriya@gmail.com', 'D', '1'),
(19, 8, 'sanjana@gmail.com', 'A', '1'),
(20, 7, 'sujita@gmail.com', 'A', '1'),
(21, 9, 'pratik@gmail.com', 'A', '1'),
(22, 10, 'aayush@gmail.com', 'C', '1');

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Course` varchar(5) DEFAULT NULL,
  `Year` varchar(10) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`ID`, `Name`, `Phone`, `Email`, `Password`, `Course`, `Year`) VALUES
(1, 'Eliza Shrestha', '9836736725', 'eliza@gmail.com', 'eliza', 'NP101', '1'),
(2, 'Luzah Manandhar', '9843176105', 'luzah@gmail.com', 'luzah', 'NP127', '1'),
(3, 'Shriya Tandukar', '9840429318', 'shriya@gmail.com', 'shriya', 'NP127', '1'),
(4, 'Supriya Bajracharya', '9860638341', 'supriya@gmail.com', 'supriya', 'NP109', '1'),
(5, 'Sushmita Magar', '9741469052', 'sushmita@gmail.com', 'sushmita', 'NP109', '1'),
(6, 'Harry Styles', '9851894701', 'harry@gmail.com', 'harry', 'NP127', '1'),
(7, 'Sujita Maharjan', '9825637104', 'sujita@gmail.com', 'sujita', 'NP103', '1'),
(8, 'Sanjana Maharjan', '9827368901', 'sanjana@gmail.com', 'sanjana', 'NP103', '1'),
(9, 'Pratik Shrestha', '9845129103', 'pratik@gmail.com', 'pratik', 'NP109', '1'),
(10, 'Aayush Kayastha', '9863129503', 'aayush@gmail.com', 'aayush', 'NP109', '1'),
(11, 'Shristi Dongol', '9840573217', 'shristi@gmail.com', 'shristi', 'NP133', '1'),
(12, 'Sambriddhi Shrestha', '9803775291', 'sambriddhi@gmail.com', 'sambriddhi', 'NP101', '1'),
(13, 'John Rai', '9847412903', 'john@gmail.com', 'john', 'NP133', '1'),
(14, 'Yajju Ratna Maharjan', '9849026731', 'yajju@gmail.com', 'yajju', 'NP103', '1'),
(15, 'Abhi Shahi', '9851178385', 'abhi@gmail.com', 'abhi', 'NP133', '1'),
(16, 'Mikasa Ackerman', '9823076128', 'mikasa@gmail.com', 'mikasa', 'NP101', '1'),
(18, 'Rina Tamrakar', '9841362671', 'rina@gmail.com', 'rina', 'NP101', '1'),
(19, 'Lisa Thapa', '9823066422', 'lisa@gmail.com', 'lisa', 'NP133', '1'),
(20, 'Ram Gurung', '9812674501', 'ram@gmail.com', 'ram', 'NP127', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Assignment`
--
ALTER TABLE `Assignment`
  ADD PRIMARY KEY (`AssignmentID`),
  ADD KEY `InstructorID` (`InstructorID`),
  ADD KEY `ModuleCode` (`ModuleCode`);

--
-- Indexes for table `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`CourseCode`);

--
-- Indexes for table `Enrollment`
--
ALTER TABLE `Enrollment`
  ADD PRIMARY KEY (`EnrollmentID`),
  ADD KEY `Student_Email` (`Student_Email`),
  ADD KEY `ModuleID` (`ModuleCode`);

--
-- Indexes for table `Instructor`
--
ALTER TABLE `Instructor`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Course` (`Course`);

--
-- Indexes for table `Module`
--
ALTER TABLE `Module`
  ADD PRIMARY KEY (`ModuleCode`),
  ADD KEY `CourseCode` (`CourseCode`);

--
-- Indexes for table `Result`
--
ALTER TABLE `Result`
  ADD PRIMARY KEY (`ResultID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `Student_Email` (`Student_Email`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `FK_Student_Course` (`Course`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Assignment`
--
ALTER TABLE `Assignment`
  MODIFY `AssignmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `Enrollment`
--
ALTER TABLE `Enrollment`
  MODIFY `EnrollmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `Instructor`
--
ALTER TABLE `Instructor`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `Result`
--
ALTER TABLE `Result`
  MODIFY `ResultID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `Student`
--
ALTER TABLE `Student`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Assignment`
--
ALTER TABLE `Assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`InstructorID`) REFERENCES `Instructor` (`ID`),
  ADD CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`ModuleCode`) REFERENCES `Module` (`ModuleCode`);

--
-- Constraints for table `Enrollment`
--
ALTER TABLE `Enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`Student_Email`) REFERENCES `Student` (`Email`),
  ADD CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`ModuleCode`) REFERENCES `Module` (`ModuleCode`);

--
-- Constraints for table `Instructor`
--
ALTER TABLE `Instructor`
  ADD CONSTRAINT `FK_Course` FOREIGN KEY (`Course`) REFERENCES `Course` (`CourseCode`);

--
-- Constraints for table `Module`
--
ALTER TABLE `Module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`CourseCode`) REFERENCES `Course` (`CourseCode`);

--
-- Constraints for table `Result`
--
ALTER TABLE `Result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `Student` (`ID`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`Student_Email`) REFERENCES `Student` (`Email`);

--
-- Constraints for table `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `FK_Student_Course` FOREIGN KEY (`Course`) REFERENCES `Course` (`CourseCode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
