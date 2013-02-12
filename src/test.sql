-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 12, 2013 at 02:31 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_code`
--

CREATE TABLE IF NOT EXISTS `product_code` (
  `product_Code` varchar(3) NOT NULL,
  `product_Code_Short_Desc` varchar(20) DEFAULT NULL,
  `product_Code_Desc` varchar(20) DEFAULT NULL,
  `third_Parties` varchar(20) DEFAULT NULL,
  `Telin_JKT11` varchar(20) DEFAULT NULL,
  `Telin_HK12` varchar(20) DEFAULT NULL,
  `Telkom` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`product_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_code`
--

INSERT INTO `product_code` (`product_Code`, `product_Code_Short_Desc`, `product_Code_Desc`, `third_Parties`, `Telin_JKT11`, `Telin_HK12`, `Telkom`) VALUES
('001', 'IPLC TDM', 'IPLC TDM', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('002', 'IPLC EoS', 'IPLC EoS', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('003', 'IEPL SDH (obsolete)', 'IEPL SDH (obsolete)', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('004', 'Transit', 'Voice Inbound Transi', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('005', 'Wholesale', 'Voice Inbound Wholes', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('006', 'Transit', 'Voice Outbound Trans', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('007', 'Wholesale', 'Voice Outbound Inpay', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('008', 'VPN', 'VPN', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40'),
('009', 'IPVPN', 'IPVPN', '4000050-000-10', '4000050-000-20', '4000050-000-30', '4000050-000-40');

-- --------------------------------------------------------

--
-- Table structure for table `product_map`
--

CREATE TABLE IF NOT EXISTS `product_map` (
  `product_Map_Id` int(3) NOT NULL AUTO_INCREMENT,
  `product_Map_Category` varchar(50) DEFAULT NULL,
  `product_Group` varchar(50) DEFAULT NULL,
  `main_Product` varchar(50) DEFAULT NULL,
  `prodcut_Map_Unit` varchar(50) DEFAULT NULL,
  `std_List_Price` varchar(50) DEFAULT NULL,
  `product_Code` varchar(3) DEFAULT NULL,
  `product_map_gst` varchar(50) DEFAULT NULL,
  `license_fee` varchar(3) DEFAULT NULL,
  `rev_gl_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_Map_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `product_map`
--

INSERT INTO `product_map` (`product_Map_Id`, `product_Map_Category`, `product_Group`, `main_Product`, `prodcut_Map_Unit`, `std_List_Price`, `product_Code`, `product_map_gst`, `license_fee`, `rev_gl_code`) VALUES
(5, 'asdas', 'jkj', 'kj', 'kj', 'kj', 'kj', NULL, '1', 'asdasdasd'),
(6, 'asd', 'asdas', 'adana', 'saasm', 'asdasd', '122', NULL, '1', 'asd'),
(7, 'asdasd', 'ads', 'asd', 'asd', 'asd', 'asd', NULL, NULL, 'asdasd'),
(8, 'asdasx', 'dasdsa', 'dasd', 'adsad', 'asd', '121', NULL, 'Yes', 'asdsad'),
(10, 'asd', 'asd', 'shortDesc', 'asd', 'asd', '111', NULL, 'No', '111 asdasdaa'),
(11, 'asdf', 'as df', 'shortDesc', 'Minute', 'a', '111', NULL, 'Yes', 'asda'),
(12, 'sf', 'sdf', 'shortDesc', 'sdf', '222', '111', NULL, 'Yes', 'sdfsdf'),
(17, 'kategori', 'asd', 'shortDesc', 'asd', 'asd', '113', NULL, 'Yes', 'asda'),
(18, 'Edited Last ', 'Inbound', 'Wholesale', 'Minute', ' ', '005', NULL, 'Yes', ' '),
(21, 'Herman Edited', 'asdasda', 'Transit', '10000', 'assadasdsa', '004', NULL, 'Yes', 'Testing'),
(22, 'Check1', 'Group 1', 'Transit', '2000', '10000', '004', NULL, 'Yes', 'GL-CODE-0001');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_baru`
--

CREATE TABLE IF NOT EXISTS `tabel_baru` (
  `field_idx` varchar(3) NOT NULL,
  `field_satu` varchar(20) DEFAULT NULL,
  `field_dua` varchar(20) DEFAULT NULL,
  `field_tiga` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`field_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_baru`
--

INSERT INTO `tabel_baru` (`field_idx`, `field_satu`, `field_dua`, `field_tiga`) VALUES
('1', 'aqsw', 'qwe', 'qwe');

-- --------------------------------------------------------

--
-- Table structure for table `test_table`
--

CREATE TABLE IF NOT EXISTS `test_table` (
  `field_id` varchar(3) NOT NULL,
  `field_1` varchar(20) DEFAULT NULL,
  `field_2` varchar(20) DEFAULT NULL,
  `field_3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`field_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_table`
--

INSERT INTO `test_table` (`field_id`, `field_1`, `field_2`, `field_3`) VALUES
('1', 'asdasd', 'asdasdad', 'asdasd'),
('2', 'qwqwqwqw', 'wqeqeqw', 'qweqweqwe'),
('3', 'asdADadsADasd SWDasd', 'ADd', 'SADasdASD'),
('6', 'qeqew', 'ewqwe', 'qwewq'),
('7', 'Edited', 'Edited juga', 'Test Edit');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `username`, `name`) VALUES
(1, 'asdasd3', 'asd2', 'asd1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
