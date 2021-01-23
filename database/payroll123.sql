-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2015 at 07:54 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `payroll123`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE IF NOT EXISTS `accountant` (
  `id` varchar(15) NOT NULL,
  `salutation` varchar(5) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `middlename` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  `level` int(1) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`id`, `salutation`, `firstname`, `middlename`, `lastname`, `dob`, `phoneno`, `emailid`, `level`, `branch`, `department`) VALUES
('Ultiacc01', 'Mr.', 'Nilesh', 'Popatbhai', 'Lathiya', '1988-08-19', '+919913872306', 'nileshlathiya@gmail.com', 0, 'Ahmedabad', 'ABC'),
('Ultiacc02', 'Mr.', 'Abhishek', 'Latishbhai', 'Jagwani', '1994-10-21', '+918000467228', 'abhi.jagwani@gmail.com', 0, 'Ahmedabad', 'Pqr');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` varchar(15) NOT NULL,
  `salutation` varchar(5) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `middlename` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `dateofjoin` date NOT NULL,
  `bankname` varchar(25) NOT NULL,
  `accno` int(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  `basicsalary` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `salutation`, `firstname`, `middlename`, `lastname`, `dob`, `phoneno`, `emailid`, `designation`, `dateofjoin`, `bankname`, `accno`, `branch`, `department`, `basicsalary`) VALUES
('Ultimate01', 'Mr.', 'Parth', 'Popatbhai', 'Lathiya', '1995-07-05', '+917405500480', 'lathiyaparth33@gmail.com', 'IT Analyst', '2011-08-09', 'State Bank of India', 2110, 'Ahmedabad', 'XYZ', 17000),
('Ultimate02', 'Mr.', 'Mayur', 'Laljibhai', 'Paladiya', '1995-08-05', '+919662968362', 'lathiyaparth66@yahoo.com', 'SE', '2010-12-09', 'ICICI', 2115, 'Ahmedabad', 'DEF', 20000),
('Ultimate03', 'Mr.', 'Sanyam', 'Ukabhai', 'Dobariya', '1995-07-05', '9913872306', 'sam.dob@gmail.com', 'SE', '2010-12-30', 'ICICI', 111111111, 'Ahmedabad', 'Telecom', 25000),
('Ultimate04', 'Mr.', 'Hemang', 'Raghavbhai', 'Parghi', '1995-07-05', '+918460110332', 'hemang@gmail.com', 'ITA', '2015-09-04', 'ICICI', 111100111, 'Ahmedabad', 'Android', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `hr`
--

CREATE TABLE IF NOT EXISTS `hr` (
  `id` varchar(15) NOT NULL,
  `salutation` varchar(5) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `middlename` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr`
--

INSERT INTO `hr` (`id`, `salutation`, `firstname`, `middlename`, `lastname`, `dob`, `phoneno`, `emailid`) VALUES
('Ultihr01', 'Mr.', 'Yagnik', 'Hiralal', 'Lamba', '2015-08-04', '+919033684800', 'yago@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `leave`
--

CREATE TABLE IF NOT EXISTS `leave` (
  `EL` int(3) NOT NULL,
  `SL` int(3) NOT NULL,
  `CL` int(3) NOT NULL,
  `month` varchar(10) NOT NULL,
  `year` int(5) NOT NULL,
  `employeeid` varchar(15) NOT NULL,
  PRIMARY KEY (`month`,`year`,`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leave`
--

INSERT INTO `leave` (`EL`, `SL`, `CL`, `month`, `year`, `employeeid`) VALUES
(-8, -1, 0, 'FEB', 2015, 'Ultimate01'),
(3, 2, 2, 'FEB', 2015, 'Ultimate02'),
(3, 2, 2, 'FEB', 2015, 'Ultimate03'),
(3, 2, 2, 'FEB', 2015, 'Ultimate04'),
(3, 2, 2, 'MAY', 2015, 'Ultimate01'),
(3, 2, 2, 'MAY', 2015, 'Ultimate02'),
(3, 2, 2, 'MAY', 2015, 'Ultimate03'),
(3, 2, 2, 'MAY', 2015, 'Ultimate04');

-- --------------------------------------------------------

--
-- Table structure for table `payslip`
--

CREATE TABLE IF NOT EXISTS `payslip` (
  `employeeid` varchar(15) NOT NULL,
  `month` varchar(10) NOT NULL,
  `year` int(5) NOT NULL,
  `basicsalary` float NOT NULL,
  `dayspaid` int(3) NOT NULL,
  PRIMARY KEY (`employeeid`,`month`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payslip`
--

INSERT INTO `payslip` (`employeeid`, `month`, `year`, `basicsalary`, `dayspaid`) VALUES
('Ultimate01', 'FEB', 2015, 17000, 28),
('Ultimate01', 'MAY', 2015, 17000, 31),
('Ultimate02', 'FEB', 2015, 20000, 25),
('Ultimate02', 'MAY', 2015, 20000, 31),
('Ultimate03', 'FEB', 2015, 25000, 25),
('Ultimate03', 'MAY', 2015, 25000, 31),
('Ultimate04', 'FEB', 2015, 35000, 30),
('Ultimate04', 'MAY', 2015, 35000, 31);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payslip`
--
ALTER TABLE `payslip`
  ADD CONSTRAINT `payslip_ibfk_1` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
