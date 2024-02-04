-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: db_inventory
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang` (
  `kode_barang` char(8) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `satuan` varchar(10) NOT NULL,
  `harga` double NOT NULL,
  `stok` int NOT NULL,
  `kode_jenis` char(8) NOT NULL,
  PRIMARY KEY (`kode_barang`),
  KEY `fk_barang_jenis_barang1_idx` (`kode_jenis`),
  CONSTRAINT `fk_barang_jenis_barang1` FOREIGN KEY (`kode_jenis`) REFERENCES `jenis_barang` (`kode_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES ('B1908001','Paku 7cm','Kg',22000,100,'JB001'),('B1908002','Paku 8cm','Kg',22000,100,'JB002'),('B1908003','Paku 9cm','Kg',22000,100,'JB003');
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barang_keluar`
--

DROP TABLE IF EXISTS `barang_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang_keluar` (
  `no_keluar` char(8) NOT NULL,
  `tgl_keluar` date NOT NULL,
  `total_keluar` double NOT NULL,
  `id_pengguna` char(8) NOT NULL,
  PRIMARY KEY (`no_keluar`),
  KEY `fk_barang_keluar_pengguna_idx` (`id_pengguna`),
  CONSTRAINT `fk_barang_keluar_pengguna` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang_keluar`
--

LOCK TABLES `barang_keluar` WRITE;
/*!40000 ALTER TABLE `barang_keluar` DISABLE KEYS */;
/*!40000 ALTER TABLE `barang_keluar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barang_masuk`
--

DROP TABLE IF EXISTS `barang_masuk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang_masuk` (
  `no_masuk` char(8) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `total_masuk` double NOT NULL,
  `id_pengguna` char(8) NOT NULL,
  `id_distributor` char(8) NOT NULL,
  PRIMARY KEY (`no_masuk`),
  KEY `fk_barang_masuk_pengguna1_idx` (`id_pengguna`),
  KEY `fk_barang_masuk_Distributor1_idx` (`id_distributor`),
  CONSTRAINT `fk_barang_masuk_Distributor1` FOREIGN KEY (`id_distributor`) REFERENCES `distributor` (`id_distributor`),
  CONSTRAINT `fk_barang_masuk_pengguna1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang_masuk`
--

LOCK TABLES `barang_masuk` WRITE;
/*!40000 ALTER TABLE `barang_masuk` DISABLE KEYS */;
/*!40000 ALTER TABLE `barang_masuk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_barang_keluar`
--

DROP TABLE IF EXISTS `detail_barang_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_barang_keluar` (
  `no_keluar` char(8) NOT NULL,
  `kode_barang` char(8) NOT NULL,
  `jml_keluar` int NOT NULL,
  `subtotal_keluar` double NOT NULL,
  KEY `fk_barang_keluar_has_barang_barang1_idx` (`kode_barang`),
  KEY `fk_barang_keluar_has_barang_barang_keluar1_idx` (`no_keluar`),
  CONSTRAINT `fk_barang_keluar_has_barang_barang1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `fk_barang_keluar_has_barang_barang_keluar1` FOREIGN KEY (`no_keluar`) REFERENCES `barang_keluar` (`no_keluar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_barang_keluar`
--

LOCK TABLES `detail_barang_keluar` WRITE;
/*!40000 ALTER TABLE `detail_barang_keluar` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_barang_keluar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_barang_masuk`
--

DROP TABLE IF EXISTS `detail_barang_masuk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_barang_masuk` (
  `no_masuk` char(8) NOT NULL,
  `kode_barang` char(8) NOT NULL,
  `jml_masuk` int NOT NULL,
  `subtotal_masuk` double NOT NULL,
  KEY `fk_barang_masuk_has_barang_barang1_idx` (`kode_barang`),
  KEY `fk_barang_masuk_has_barang_barang_masuk1_idx` (`no_masuk`),
  CONSTRAINT `fk_barang_masuk_has_barang_barang1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `fk_barang_masuk_has_barang_barang_masuk1` FOREIGN KEY (`no_masuk`) REFERENCES `barang_masuk` (`no_masuk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_barang_masuk`
--

LOCK TABLES `detail_barang_masuk` WRITE;
/*!40000 ALTER TABLE `detail_barang_masuk` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_barang_masuk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_pemesanan`
--

DROP TABLE IF EXISTS `detail_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_pemesanan` (
  `no_pesan` char(8) NOT NULL,
  `kode_barang` char(8) NOT NULL,
  `jml_pesan` int NOT NULL,
  `subtotal_pesan` double NOT NULL,
  `status` varchar(20) NOT NULL,
  KEY `fk_pemesanan_has_barang_barang1_idx` (`kode_barang`),
  KEY `fk_pemesanan_has_barang_pemesanan1_idx` (`no_pesan`),
  CONSTRAINT `fk_pemesanan_has_barang_barang1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `fk_pemesanan_has_barang_pemesanan1` FOREIGN KEY (`no_pesan`) REFERENCES `pemesanan` (`no_pesan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_pemesanan`
--

LOCK TABLES `detail_pemesanan` WRITE;
/*!40000 ALTER TABLE `detail_pemesanan` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributor`
--

DROP TABLE IF EXISTS `distributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor` (
  `id_distributor` char(8) NOT NULL,
  `nama_distributor` varchar(30) NOT NULL,
  `telp_distributor` varchar(13) NOT NULL,
  `alamat_distributor` varchar(100) NOT NULL,
  PRIMARY KEY (`id_distributor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributor`
--

LOCK TABLES `distributor` WRITE;
/*!40000 ALTER TABLE `distributor` DISABLE KEYS */;
/*!40000 ALTER TABLE `distributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jenis_barang`
--

DROP TABLE IF EXISTS `jenis_barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jenis_barang` (
  `kode_jenis` char(8) NOT NULL,
  `nama_jenis` varchar(30) NOT NULL,
  PRIMARY KEY (`kode_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jenis_barang`
--

LOCK TABLES `jenis_barang` WRITE;
/*!40000 ALTER TABLE `jenis_barang` DISABLE KEYS */;
INSERT INTO `jenis_barang` VALUES ('JB001','Paku'),('JB002','Paku'),('JB003','Paku');
/*!40000 ALTER TABLE `jenis_barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pemesanan`
--

DROP TABLE IF EXISTS `pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pemesanan` (
  `no_pesan` char(8) NOT NULL,
  `tgl_pesan` date NOT NULL,
  `total_pesan` double NOT NULL,
  `id_pengguna` char(8) NOT NULL,
  `id_distributor` char(8) NOT NULL,
  PRIMARY KEY (`no_pesan`),
  KEY `fk_pemesanan_pengguna1_idx` (`id_pengguna`),
  KEY `fk_pemesanan_Distributor1_idx` (`id_distributor`),
  CONSTRAINT `fk_pemesanan_Distributor1` FOREIGN KEY (`id_distributor`) REFERENCES `distributor` (`id_distributor`),
  CONSTRAINT `fk_pemesanan_pengguna1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pemesanan`
--

LOCK TABLES `pemesanan` WRITE;
/*!40000 ALTER TABLE `pemesanan` DISABLE KEYS */;
/*!40000 ALTER TABLE `pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pengguna` (
  `id_pengguna` char(8) NOT NULL,
  `nama_pengguna` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `telp_pengguna` varchar(13) NOT NULL,
  `alamat_pengguna` varchar(100) NOT NULL,
  `level` varchar(5) NOT NULL,
  PRIMARY KEY (`id_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengguna`
--

LOCK TABLES `pengguna` WRITE;
/*!40000 ALTER TABLE `pengguna` DISABLE KEYS */;
INSERT INTO `pengguna` VALUES ('12345','Aliakbar','Admin','21232f297a57a5a743894a0e4a801fc3','085733178340','Bangsalsari','Owner');
/*!40000 ALTER TABLE `pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sementara_keluar`
--

DROP TABLE IF EXISTS `sementara_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sementara_keluar` (
  `kode_barang` char(8) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga` double NOT NULL,
  `jml_keluar` int NOT NULL,
  `subtotal_keluar` double NOT NULL,
  PRIMARY KEY (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sementara_keluar`
--

LOCK TABLES `sementara_keluar` WRITE;
/*!40000 ALTER TABLE `sementara_keluar` DISABLE KEYS */;
/*!40000 ALTER TABLE `sementara_keluar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sementara_masuk`
--

DROP TABLE IF EXISTS `sementara_masuk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sementara_masuk` (
  `kode_barang` char(8) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga` double NOT NULL,
  `jml_masuk` int NOT NULL,
  `subtotal_masuk` double NOT NULL,
  PRIMARY KEY (`kode_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sementara_masuk`
--

LOCK TABLES `sementara_masuk` WRITE;
/*!40000 ALTER TABLE `sementara_masuk` DISABLE KEYS */;
/*!40000 ALTER TABLE `sementara_masuk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sementara_pesan`
--

DROP TABLE IF EXISTS `sementara_pesan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sementara_pesan` (
  `kode_barang` char(8) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `harga` double NOT NULL,
  `jml_pesan` int NOT NULL,
  `subtotal_pesan` double NOT NULL,
  `status` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sementara_pesan`
--

LOCK TABLES `sementara_pesan` WRITE;
/*!40000 ALTER TABLE `sementara_pesan` DISABLE KEYS */;
/*!40000 ALTER TABLE `sementara_pesan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-01  6:58:35
