-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2017 at 05:36 PM
-- Server version: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guitarmania`
--

-- --------------------------------------------------------

--
-- Table structure for table `guitar`
--

CREATE TABLE `guitar` (
  `guitar_id` bigint(20) NOT NULL,
  `guitar_color` varchar(255) NOT NULL,
  `guitar_price` double NOT NULL,
  `guitar_serialnumber` varchar(255) NOT NULL,
  `guitar_vintage` int(11) NOT NULL,
  `guitar_guitarbrand_id` int(11) NOT NULL,
  `guitar_type` varchar(255) NOT NULL,
  `guitar_guitarowner_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guitar`
--

INSERT INTO `guitar` (`guitar_id`, `guitar_color`, `guitar_price`, `guitar_serialnumber`, `guitar_vintage`, `guitar_guitarbrand_id`, `guitar_type`, `guitar_guitarowner_id`) VALUES
(1, 'Ebony', 500000, 'G0001', 1990, 3, 'Les Paul Standard', 0),
(2, 'Metallic Red', 150000, 'G0002', 1989, 6, 'Striker 300HST', 0),
(3, 'Wine Red', 70000, 'G0003', 2009, 4, 'AV7 Les Paul', 0),
(4, 'Sunburst', 350000, 'G0004', 1973, 2, 'American Standard Stratocaster', 2);

-- --------------------------------------------------------

--
-- Table structure for table `guitarbrand`
--

CREATE TABLE `guitarbrand` (
  `guitarbrand_id` int(11) NOT NULL,
  `guitarbrand_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guitarbrand`
--

INSERT INTO `guitarbrand` (`guitarbrand_id`, `guitarbrand_name`) VALUES
(0, 'CORT'),
(1, 'EPIPHONE'),
(2, 'FENDER'),
(3, 'GIBSON'),
(4, 'GREG_BENNETT'),
(5, 'IBANEZ'),
(6, 'KRAMER'),
(7, 'MUSIC_MAN'),
(8, 'OVATION'),
(9, 'SCHECTER');

-- --------------------------------------------------------

--
-- Table structure for table `guitarowner`
--

CREATE TABLE `guitarowner` (
  `guitarowner_id` bigint(20) NOT NULL,
  `guitarowner_email` varchar(255) NOT NULL,
  `guitarowner_password` varchar(255) NOT NULL,
  `guitarowner_username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guitarowner`
--

INSERT INTO `guitarowner` (`guitarowner_id`, `guitarowner_email`, `guitarowner_password`, `guitarowner_username`) VALUES
(0, 'blacktom73@gmail.com', 'tamas', 'mitro.tamas'),
(1, 'kovacs.lajos@gmail.com', 'lajos', 'kovacs.lajos'),
(2, 'fekete.peter@gmail.com', 'peter', 'fekete.peter');

-- --------------------------------------------------------

--
-- Table structure for table `guitar_guitar_id_seq`
--

CREATE TABLE `guitar_guitar_id_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guitar_guitar_id_seq`
--

INSERT INTO `guitar_guitar_id_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `UserRoles`
--

CREATE TABLE `UserRoles` (
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserRoles`
--

INSERT INTO `UserRoles` (`username`, `role`) VALUES
('admin', 'ADMIN'),
('user1', 'USERS');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `username` varchar(255) NOT NULL,
  `passwd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`username`, `passwd`) VALUES
('admin', 'CqB4wLve9qYlprNF5FT+Z11XAk7PEe8gx7wVRTYOTC8='),
('user1', 'CqB4wLve9qYlprNF5FT+Z11XAk7PEe8gx7wVRTYOTC8=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guitar`
--
ALTER TABLE `guitar`
  ADD PRIMARY KEY (`guitar_id`),
  ADD KEY `FKdf5bttrm3jrik010c5i04tk0a` (`guitar_guitarowner_id`);

--
-- Indexes for table `guitarbrand`
--
ALTER TABLE `guitarbrand`
  ADD PRIMARY KEY (`guitarbrand_id`);

--
-- Indexes for table `guitarowner`
--
ALTER TABLE `guitarowner`
  ADD PRIMARY KEY (`guitarowner_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guitar`
--
ALTER TABLE `guitar`
  MODIFY `guitar_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `guitar`
--
ALTER TABLE `guitar`
  ADD CONSTRAINT `FKdf5bttrm3jrik010c5i04tk0a` FOREIGN KEY (`guitar_guitarowner_id`) REFERENCES `guitarowner` (`guitarowner_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
