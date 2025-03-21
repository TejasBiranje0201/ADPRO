-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2025 at 09:24 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adpro_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `ad_schedules`
--

CREATE TABLE `ad_schedules` (
  `id` int(11) NOT NULL,
  `ad_date` date DEFAULT NULL,
  `before_agency_message` varchar(255) DEFAULT NULL,
  `before_client_message` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `on_date_agency_message` varchar(255) DEFAULT NULL,
  `on_date_client_message` varchar(255) DEFAULT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `pmedia_id` int(11) DEFAULT NULL,
  `pmedia_ro_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `agencies`
--

CREATE TABLE `agencies` (
  `id` int(11) NOT NULL,
  `accountno` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bankname` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gstno` bigint(20) NOT NULL,
  `ifsccode` varchar(255) DEFAULT NULL,
  `instructions` varchar(255) DEFAULT NULL,
  `logopath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `panno` varchar(255) DEFAULT NULL,
  `signpath` varchar(255) DEFAULT NULL,
  `stamppath` varchar(255) DEFAULT NULL,
  `stateid` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `address_string` varchar(255) DEFAULT NULL,
  `contact` bigint(20) NOT NULL,
  `gstno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `emediarodetails`
--

CREATE TABLE `emediarodetails` (
  `id` int(11) NOT NULL,
  `bonuspaid` double NOT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `charges` double NOT NULL,
  `dailyspots` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `emediarodetailid` int(11) NOT NULL,
  `fromtime` time(6) DEFAULT NULL,
  `fromtodate` date DEFAULT NULL,
  `noofdays` int(11) NOT NULL,
  `srno` int(11) NOT NULL,
  `totalcharges` double NOT NULL,
  `totalspots` int(11) NOT NULL,
  `totime` time(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `emediaroinvoices`
--

CREATE TABLE `emediaroinvoices` (
  `id` int(11) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `cc_amount` double NOT NULL,
  `cc_percent` float NOT NULL,
  `centers` varchar(255) DEFAULT NULL,
  `cgst_amount` double NOT NULL,
  `cgst_percent` float NOT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_no` int(11) NOT NULL,
  `comission_amount` double NOT NULL,
  `comission_percent` float NOT NULL,
  `financial_year` int(11) NOT NULL,
  `igst_amount` double NOT NULL,
  `igst_percent` float NOT NULL,
  `instructions` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `no_of_records` int(11) NOT NULL,
  `ro_bill_amount` double NOT NULL,
  `ro_date` date DEFAULT NULL,
  `ro_no` int(11) NOT NULL,
  `sgst_amount` double NOT NULL,
  `sgst_percent` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_charges` float NOT NULL,
  `total_spots` int(11) NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `emedia_id` int(11) DEFAULT NULL,
  `emediaro_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `emediaros`
--

CREATE TABLE `emediaros` (
  `id` int(11) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `cc_amount` double NOT NULL,
  `cc_percent` float NOT NULL,
  `centers` varchar(255) DEFAULT NULL,
  `cgst_amount` double NOT NULL,
  `cgst_percent` float NOT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_no` int(11) NOT NULL,
  `comission_amount` double NOT NULL,
  `comission_percent` float NOT NULL,
  `financial_year` date DEFAULT NULL,
  `igst_amount` double NOT NULL,
  `igst_percent` float NOT NULL,
  `instructions` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `no_of_records` int(11) NOT NULL,
  `ro_bill_amount` double NOT NULL,
  `ro_date` date DEFAULT NULL,
  `ro_no` int(11) NOT NULL,
  `sgst_amount` double NOT NULL,
  `sgst_percent` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_charges` double NOT NULL,
  `total_spots` int(11) NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `emedia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `e_medias`
--

CREATE TABLE `e_medias` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` bigint(20) NOT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `financialyears`
--

CREATE TABLE `financialyears` (
  `id` int(11) NOT NULL,
  `enddate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `startdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoicedetails`
--

CREATE TABLE `invoicedetails` (
  `id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `invoiceid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `srno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `manus`
--

CREATE TABLE `manus` (
  `id` int(11) NOT NULL,
  `isparent` bit(1) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `srno` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `module_menus`
--

CREATE TABLE `module_menus` (
  `id` int(11) NOT NULL,
  `moduleid` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pmediaroinvoice_details`
--

CREATE TABLE `pmediaroinvoice_details` (
  `id` int(11) NOT NULL,
  `area` float NOT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `cc_amount` double NOT NULL,
  `cc_percent` float NOT NULL,
  `cgst_amount` double NOT NULL,
  `charges` double NOT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_no` int(11) NOT NULL,
  `comission_amount` double NOT NULL,
  `comission_percent` float NOT NULL,
  `final_charges` double NOT NULL,
  `gst_amount` double NOT NULL,
  `height` float NOT NULL,
  `igst_amount` double NOT NULL,
  `invoice_no` bigint(20) NOT NULL,
  `p_date` date DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `rate` float NOT NULL,
  `sgst_amount` double NOT NULL,
  `sr_no` int(11) NOT NULL,
  `total_charges` double NOT NULL,
  `width` float NOT NULL,
  `pmediarodetail_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pmediaro_details`
--

CREATE TABLE `pmediaro_details` (
  `id` int(11) NOT NULL,
  `area` float NOT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `cc_amount` double NOT NULL,
  `cc_percent` float NOT NULL,
  `cgst_amount` float NOT NULL,
  `charges` float NOT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_no` int(11) NOT NULL,
  `comission_amount` float NOT NULL,
  `comission_percent` float NOT NULL,
  `final_charges` double NOT NULL,
  `gst_amount` float NOT NULL,
  `height` float NOT NULL,
  `igst_amount` float NOT NULL,
  `invoice_no` int(11) NOT NULL,
  `p_date` date DEFAULT NULL,
  `positon` varchar(255) DEFAULT NULL,
  `rate` float NOT NULL,
  `sgst_amount` float NOT NULL,
  `sr_no` int(11) NOT NULL,
  `total_charges` double NOT NULL,
  `width` float NOT NULL,
  `pmediaro_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pmediaro_invoices`
--

CREATE TABLE `pmediaro_invoices` (
  `id` int(11) NOT NULL,
  `bill_amount` double NOT NULL,
  `cgst_amount` float NOT NULL,
  `cgst_percent` float NOT NULL,
  `comission_amount` float NOT NULL,
  `dicount_amount` float NOT NULL,
  `discount_percent` float NOT NULL,
  `financial_year` int(11) NOT NULL,
  `igst_amount` float NOT NULL,
  `igst_percent` float NOT NULL,
  `invoice_date` date DEFAULT NULL,
  `invoice_no` int(11) NOT NULL,
  `ro_bill_amount` float NOT NULL,
  `sgst_amount` float NOT NULL,
  `sgst_percent` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_charges` double NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `pmediaro_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pmedia_ros`
--

CREATE TABLE `pmedia_ros` (
  `id` int(11) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `cc_amount` double NOT NULL,
  `cc_percent` double NOT NULL,
  `centers` varchar(255) DEFAULT NULL,
  `cgst_amount` double NOT NULL,
  `cgst_percent` double NOT NULL,
  `chequa_date` date DEFAULT NULL,
  `cheque_no` int(11) NOT NULL,
  `comission_amount` double NOT NULL,
  `comission_percent` double NOT NULL,
  `financial_year` int(11) NOT NULL,
  `free_days` int(11) NOT NULL,
  `igst_amount` double NOT NULL,
  `igst_percent` double NOT NULL,
  `instructions` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `no_of_records` int(11) NOT NULL,
  `paid_days` int(11) NOT NULL,
  `ro_bill_amount` double NOT NULL,
  `ro_date` date DEFAULT NULL,
  `rono` int(11) NOT NULL,
  `sgst_amount` double NOT NULL,
  `sgst_percent` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_charges` double NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `p_media_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `p_medias`
--

CREATE TABLE `p_medias` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` bigint(20) NOT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rolemodules`
--

CREATE TABLE `rolemodules` (
  `id` int(11) NOT NULL,
  `moduleid` int(11) DEFAULT NULL,
  `urole_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

CREATE TABLE `stats` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`id`, `name`) VALUES
(1, 'Andhra Pradesh'),
(2, 'Arunachal Pradesh'),
(3, 'Assam'),
(4, 'Bihar'),
(5, 'Chhattisgarh'),
(6, 'Goa'),
(7, 'Gujarat'),
(8, 'Haryana'),
(9, 'Himachal Pradesh'),
(10, 'Jharkhand'),
(11, 'Karnataka'),
(12, 'Kerala'),
(13, 'Madhya Pradesh'),
(14, 'Maharashtra'),
(15, 'Manipur'),
(16, 'Meghalaya'),
(17, 'Mizoram'),
(18, 'Nagaland'),
(19, 'Odisha'),
(20, 'Punjab'),
(21, 'Rajasthan'),
(22, 'Sikkim'),
(23, 'Tamil Nadu'),
(24, 'Telangana'),
(25, 'Tripura'),
(26, 'Uttar Pradesh'),
(27, 'Uttarakhand'),
(28, 'West Bengal'),
(29, 'Andaman and Nicobar Islands'),
(30, 'Chandigarh'),
(31, 'Dadra and Nagar Haveli and Daman and Diu'),
(32, 'Lakshadweep'),
(33, 'Delhi'),
(34, 'Puducherry'),
(35, 'Jammu and Kashmir'),
(36, 'Ladakh');

-- --------------------------------------------------------

--
-- Table structure for table `uroles`
--

CREATE TABLE `uroles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `createdon` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `urole_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `work_schedules`
--

CREATE TABLE `work_schedules` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `wdate` date DEFAULT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ad_schedules`
--
ALTER TABLE `ad_schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmj78j8lpcmulgdwdvobw2vybm` (`agency_id`),
  ADD KEY `FK1om0uuj5dx78ligk23kamdb7n` (`client_id`),
  ADD KEY `FKkbp31ko2gnedeumt5i9bp36jc` (`pmedia_id`),
  ADD KEY `FKl9gt80yu1h5tlqqp3em3my9yk` (`pmedia_ro_id`);

--
-- Indexes for table `agencies`
--
ALTER TABLE `agencies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsys8lfn2d41xove6l94kpr62s` (`state_id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8aag9a82gn8eqay73fwbdyeup` (`agency_id`),
  ADD KEY `FKcwgdo1me4e9kye5mips23dae2` (`state_id`);

--
-- Indexes for table `emediarodetails`
--
ALTER TABLE `emediarodetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emediaroinvoices`
--
ALTER TABLE `emediaroinvoices`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKinolqhqjob2qbpnkbfadbv3qe` (`agency_id`),
  ADD KEY `FKne7tf6t5b9nb8qr7pmih3wjh1` (`client_id`),
  ADD KEY `FKf9dyrjsv3joj7ehl20jyb3d7c` (`emedia_id`),
  ADD KEY `FK98jldt6171qbife8wvl0mbe48` (`emediaro_id`);

--
-- Indexes for table `emediaros`
--
ALTER TABLE `emediaros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7ppo7bs2qa3cdophrmtmnv7cj` (`agency_id`),
  ADD KEY `FKdw78w3aabi96w53n2iftfeio3` (`client_id`),
  ADD KEY `FKjhp9mc3nknojsmeuow9qvyv16` (`emedia_id`);

--
-- Indexes for table `e_medias`
--
ALTER TABLE `e_medias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtpiyfug8tv6rba2q65jaiyj35` (`state_id`);

--
-- Indexes for table `financialyears`
--
ALTER TABLE `financialyears`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoicedetails`
--
ALTER TABLE `invoicedetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manus`
--
ALTER TABLE `manus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `module_menus`
--
ALTER TABLE `module_menus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl2924c93v0sxxla09k6o9oy9` (`moduleid`),
  ADD KEY `FKhp9f0h2g94v2jxglc545xrqq2` (`menu_id`);

--
-- Indexes for table `pmediaroinvoice_details`
--
ALTER TABLE `pmediaroinvoice_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5kyw7jcyc3kbubsl7oybowtng` (`pmediarodetail_id`);

--
-- Indexes for table `pmediaro_details`
--
ALTER TABLE `pmediaro_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKaf362cj8bljlehf8y9nbbk5xq` (`pmediaro_id`);

--
-- Indexes for table `pmediaro_invoices`
--
ALTER TABLE `pmediaro_invoices`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk0ruik4cpitdu08fwchqfr2b4` (`agency_id`),
  ADD KEY `FKfcmnh8hkfset0pvxomqq1h7yo` (`pmediaro_id`);

--
-- Indexes for table `pmedia_ros`
--
ALTER TABLE `pmedia_ros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8ah0a9k7e6i2sm90fsi1v3yp6` (`agency_id`),
  ADD KEY `FK4h200bl7943atyno6e6sjx8kq` (`client_id`),
  ADD KEY `FKoe4riiyfkxsfsrntwbl9lc6cn` (`p_media_id`);

--
-- Indexes for table `p_medias`
--
ALTER TABLE `p_medias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5rlro86l3jivshkauf1la98xq` (`state_id`);

--
-- Indexes for table `rolemodules`
--
ALTER TABLE `rolemodules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtjxdpgrspku85vyu29916m4id` (`moduleid`),
  ADD KEY `FKmpht0h4lg4vasq7wcdvlac90g` (`urole_id`);

--
-- Indexes for table `stats`
--
ALTER TABLE `stats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `uroles`
--
ALTER TABLE `uroles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7bo7u275rpljcaj3paqbaxbp9` (`agency_id`),
  ADD KEY `FKdmahwa9uj8r9tkhbujb80qoj9` (`urole_id`);

--
-- Indexes for table `work_schedules`
--
ALTER TABLE `work_schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq2dutlwbjm5l4clixv5a1lk1q` (`agency_id`),
  ADD KEY `FKj81w5rs9r89mvwhvwm6vuqiln` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ad_schedules`
--
ALTER TABLE `ad_schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `agencies`
--
ALTER TABLE `agencies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emediarodetails`
--
ALTER TABLE `emediarodetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emediaroinvoices`
--
ALTER TABLE `emediaroinvoices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emediaros`
--
ALTER TABLE `emediaros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `e_medias`
--
ALTER TABLE `e_medias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `financialyears`
--
ALTER TABLE `financialyears`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoicedetails`
--
ALTER TABLE `invoicedetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manus`
--
ALTER TABLE `manus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `module_menus`
--
ALTER TABLE `module_menus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pmediaroinvoice_details`
--
ALTER TABLE `pmediaroinvoice_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pmediaro_details`
--
ALTER TABLE `pmediaro_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pmediaro_invoices`
--
ALTER TABLE `pmediaro_invoices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pmedia_ros`
--
ALTER TABLE `pmedia_ros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `p_medias`
--
ALTER TABLE `p_medias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rolemodules`
--
ALTER TABLE `rolemodules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stats`
--
ALTER TABLE `stats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `uroles`
--
ALTER TABLE `uroles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `work_schedules`
--
ALTER TABLE `work_schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ad_schedules`
--
ALTER TABLE `ad_schedules`
  ADD CONSTRAINT `FK1om0uuj5dx78ligk23kamdb7n` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKkbp31ko2gnedeumt5i9bp36jc` FOREIGN KEY (`pmedia_id`) REFERENCES `p_medias` (`id`),
  ADD CONSTRAINT `FKl9gt80yu1h5tlqqp3em3my9yk` FOREIGN KEY (`pmedia_ro_id`) REFERENCES `pmedia_ros` (`id`),
  ADD CONSTRAINT `FKmj78j8lpcmulgdwdvobw2vybm` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`);

--
-- Constraints for table `agencies`
--
ALTER TABLE `agencies`
  ADD CONSTRAINT `FKsys8lfn2d41xove6l94kpr62s` FOREIGN KEY (`state_id`) REFERENCES `stats` (`id`);

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FK8aag9a82gn8eqay73fwbdyeup` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `FKcwgdo1me4e9kye5mips23dae2` FOREIGN KEY (`state_id`) REFERENCES `stats` (`id`);

--
-- Constraints for table `emediaroinvoices`
--
ALTER TABLE `emediaroinvoices`
  ADD CONSTRAINT `FK98jldt6171qbife8wvl0mbe48` FOREIGN KEY (`emediaro_id`) REFERENCES `emediaros` (`id`),
  ADD CONSTRAINT `FKf9dyrjsv3joj7ehl20jyb3d7c` FOREIGN KEY (`emedia_id`) REFERENCES `e_medias` (`id`),
  ADD CONSTRAINT `FKinolqhqjob2qbpnkbfadbv3qe` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `FKne7tf6t5b9nb8qr7pmih3wjh1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `emediaros`
--
ALTER TABLE `emediaros`
  ADD CONSTRAINT `FK7ppo7bs2qa3cdophrmtmnv7cj` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `FKdw78w3aabi96w53n2iftfeio3` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FKjhp9mc3nknojsmeuow9qvyv16` FOREIGN KEY (`emedia_id`) REFERENCES `e_medias` (`id`);

--
-- Constraints for table `e_medias`
--
ALTER TABLE `e_medias`
  ADD CONSTRAINT `FKtpiyfug8tv6rba2q65jaiyj35` FOREIGN KEY (`state_id`) REFERENCES `stats` (`id`);

--
-- Constraints for table `module_menus`
--
ALTER TABLE `module_menus`
  ADD CONSTRAINT `FKhp9f0h2g94v2jxglc545xrqq2` FOREIGN KEY (`menu_id`) REFERENCES `manus` (`id`),
  ADD CONSTRAINT `FKl2924c93v0sxxla09k6o9oy9` FOREIGN KEY (`moduleid`) REFERENCES `modules` (`id`);

--
-- Constraints for table `pmediaroinvoice_details`
--
ALTER TABLE `pmediaroinvoice_details`
  ADD CONSTRAINT `FK5kyw7jcyc3kbubsl7oybowtng` FOREIGN KEY (`pmediarodetail_id`) REFERENCES `pmediaro_details` (`id`);

--
-- Constraints for table `pmediaro_details`
--
ALTER TABLE `pmediaro_details`
  ADD CONSTRAINT `FKaf362cj8bljlehf8y9nbbk5xq` FOREIGN KEY (`pmediaro_id`) REFERENCES `pmedia_ros` (`id`);

--
-- Constraints for table `pmediaro_invoices`
--
ALTER TABLE `pmediaro_invoices`
  ADD CONSTRAINT `FKfcmnh8hkfset0pvxomqq1h7yo` FOREIGN KEY (`pmediaro_id`) REFERENCES `pmedia_ros` (`id`),
  ADD CONSTRAINT `FKk0ruik4cpitdu08fwchqfr2b4` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`);

--
-- Constraints for table `pmedia_ros`
--
ALTER TABLE `pmedia_ros`
  ADD CONSTRAINT `FK4h200bl7943atyno6e6sjx8kq` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `FK8ah0a9k7e6i2sm90fsi1v3yp6` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `FKoe4riiyfkxsfsrntwbl9lc6cn` FOREIGN KEY (`p_media_id`) REFERENCES `p_medias` (`id`);

--
-- Constraints for table `p_medias`
--
ALTER TABLE `p_medias`
  ADD CONSTRAINT `FK5rlro86l3jivshkauf1la98xq` FOREIGN KEY (`state_id`) REFERENCES `stats` (`id`);

--
-- Constraints for table `rolemodules`
--
ALTER TABLE `rolemodules`
  ADD CONSTRAINT `FKmpht0h4lg4vasq7wcdvlac90g` FOREIGN KEY (`urole_id`) REFERENCES `uroles` (`id`),
  ADD CONSTRAINT `FKtjxdpgrspku85vyu29916m4id` FOREIGN KEY (`moduleid`) REFERENCES `modules` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK7bo7u275rpljcaj3paqbaxbp9` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `FKdmahwa9uj8r9tkhbujb80qoj9` FOREIGN KEY (`urole_id`) REFERENCES `uroles` (`id`);

--
-- Constraints for table `work_schedules`
--
ALTER TABLE `work_schedules`
  ADD CONSTRAINT `FKj81w5rs9r89mvwhvwm6vuqiln` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKq2dutlwbjm5l4clixv5a1lk1q` FOREIGN KEY (`agency_id`) REFERENCES `agencies` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
