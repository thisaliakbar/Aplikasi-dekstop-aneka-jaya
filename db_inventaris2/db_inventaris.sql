-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: db_inventaris
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
  `kode_barang` char(10) NOT NULL,
  `kode_jenis` char(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `harga` double NOT NULL,
  `stok` int NOT NULL,
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
INSERT INTO `barang` VALUES ('B2311001','JB001','Tplus Bottle 1L','Pcs',40000,258),('B2311002','JB001','Shaker Spider 600ML','Pcs',25000,266),('B2311003','JB003','Piring Oval Melamin 10Inch','Pack ',2500,310),('B2311004','JB007','Kotak Makan 3 Sekat','Pcs',28500,105),('B2311005','JB001','Botol Kale','Pcs',31000,205),('B2311006','JB001','Botol Almond','Pcs',35000,185),('B2311007','JB005','Keranjang Baju','Pcs',45000,198),('B2311008','JB009','Gelas kaca','Pack',40000,190),('B2311009','JB009','Gelas Plastik 500ML','Pack',80000,273),('B2311010','JB002','Mug Corak Naga','Pack',45000,50),('B2312001','JB006','Cream Bowl 15','Pcs',5000,150),('B2312002','JB006','Pink Bowl 15','Pcs',5000,98),('B2312003','JB006','Green Bowl 15','Pcs',5000,150),('B2312004','JB002','Cream Cup','Pcs',5000,95),('B2312005','JB002','Pink Cup','Pcs',5000,80),('B2312006','JB011','Rice Spoon Green','Pcs',4500,100),('B2312007','JB011','Rice Spoon Blue','Pcs',4500,100),('B2312008','JB006','Mangkuk Bakso 17cm','Pack',40000,50),('B2312009','JB010','Hongzhuo Termos Air 10L','Pcs',220000,99),('B2312010','JB010','Hongzhuo Termos Air 12L','Pcs',240000,99);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barang_keluar`
--

DROP TABLE IF EXISTS `barang_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang_keluar` (
  `no_keluar` char(10) NOT NULL,
  `tgl_keluar` date NOT NULL,
  `total_keluar` double NOT NULL,
  `id_pengguna` char(10) NOT NULL,
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
INSERT INTO `barang_keluar` VALUES ('BK2312001','2023-12-06',345000,'USR001'),('BK2312002','2023-12-07',640000,'USR002'),('BK2312003','2023-12-12',100000,'USR001');
/*!40000 ALTER TABLE `barang_keluar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barang_masuk`
--

DROP TABLE IF EXISTS `barang_masuk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barang_masuk` (
  `no_pesan` char(10) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `total_masuk` double NOT NULL,
  `id_pengguna` char(10) NOT NULL,
  `id_distributor` char(10) NOT NULL,
  PRIMARY KEY (`no_pesan`),
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
INSERT INTO `barang_masuk` VALUES ('PB2312001','2023-12-06',4069000,'USR001','SLR001'),('PB2312002','2023-12-07',5020000,'USR002','SLR002');
/*!40000 ALTER TABLE `barang_masuk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_barang_keluar`
--

DROP TABLE IF EXISTS `detail_barang_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_barang_keluar` (
  `no_keluar` char(10) NOT NULL,
  `kode_barang` char(10) NOT NULL,
  `jml_keluar` int NOT NULL,
  `subtotal_keluar` double NOT NULL,
  `keterangan` varchar(20) DEFAULT NULL,
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
INSERT INTO `detail_barang_keluar` VALUES ('BK2312001','B2312004',5,25000,'Terjual'),('BK2312001','B2312005',20,100000,'Terjual'),('BK2312001','B2312009',1,220000,'Terjual'),('BK2312002','B2311001',2,80000,'Terjual'),('BK2312002','B2311002',4,100000,'Terjual'),('BK2312002','B2312010',1,240000,'Terjual'),('BK2312002','B2312009',1,220000,'Terjual'),('BK2312003','B2311007',2,90000,'Terjual'),('BK2312003','B2312002',2,10000,'Terjual');
/*!40000 ALTER TABLE `detail_barang_keluar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_barang_masuk`
--

DROP TABLE IF EXISTS `detail_barang_masuk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_barang_masuk` (
  `no_pesan` char(10) NOT NULL,
  `kode_barang` char(10) NOT NULL,
  `jml_masuk` int NOT NULL,
  `subtotal_masuk` double NOT NULL,
  `status` varchar(20) NOT NULL,
  KEY `fk_no_masuk_idx` (`no_pesan`),
  KEY `fk_kode_barang_idx` (`kode_barang`),
  CONSTRAINT `fk_kode_barang` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `fk_no_masuk` FOREIGN KEY (`no_pesan`) REFERENCES `barang_masuk` (`no_pesan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_barang_masuk`
--

LOCK TABLES `detail_barang_masuk` WRITE;
/*!40000 ALTER TABLE `detail_barang_masuk` DISABLE KEYS */;
INSERT INTO `detail_barang_masuk` VALUES ('PB2312001','B2311005',50,1335000,'Telah Sampai'),('PB2312001','B2311006',50,1500000,'Telah Sampai'),('PB2312001','B2311008',25,865000,'Telah Sampai'),('PB2312001','B2312001',50,184500,'Telah Sampai'),('PB2312001','B2312003',50,184500,'Telah Sampai'),('PB2312002','B2311001',100,3000000,'Telah Sampai'),('PB2312002','B2311002',100,1850000,'Telah Sampai'),('PB2312002','B2311003',100,170000,'Telah Sampai');
/*!40000 ALTER TABLE `detail_barang_masuk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_pemesanan`
--

DROP TABLE IF EXISTS `detail_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_pemesanan` (
  `no_pesan` char(10) NOT NULL,
  `kode_barang` char(10) NOT NULL,
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
INSERT INTO `detail_pemesanan` VALUES ('PB2312001','B2311005',50,1335000,'Telah Sampai'),('PB2312001','B2311006',50,1500000,'Telah Sampai'),('PB2312001','B2311008',25,865000,'Telah Sampai'),('PB2312001','B2312001',50,184500,'Telah Sampai'),('PB2312001','B2312003',50,184500,'Telah Sampai'),('PB2312002','B2311001',100,3000000,'Telah Sampai'),('PB2312002','B2311002',100,1850000,'Telah Sampai'),('PB2312002','B2311003',100,170000,'Telah Sampai');
/*!40000 ALTER TABLE `detail_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributor`
--

DROP TABLE IF EXISTS `distributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributor` (
  `id_distributor` char(10) NOT NULL,
  `nama_distributor` varchar(50) NOT NULL,
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
INSERT INTO `distributor` VALUES ('SLR001','CV ANUGRAH JAYA','081222455679','Jl. Kaliurang, Lowokwaru, Malang, Jawa Timur'),('SLR002','CV BINTANG BARU','081234567899','Jl. PB Sudirman, Kel-Tompokser, Lumajang, Jawa Timur'),('SLR003','CV MITRA JASA ABADI','082345637489','Jl. Projakali, Bandung'),('SLR004','CV MITRA SUKSES ABADI','081347829806','TANGERANG'),('SLR005','PT KARYA ARDI PRESTASI','082465739867','BANTEN'),('SLR006','CV MULTI JAYA UTAMA','085232099788','JL SONGOYUDAN');
/*!40000 ALTER TABLE `distributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jenis_barang`
--

DROP TABLE IF EXISTS `jenis_barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jenis_barang` (
  `kode_jenis` char(10) NOT NULL,
  `nama_jenis` varchar(50) NOT NULL,
  PRIMARY KEY (`kode_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jenis_barang`
--

LOCK TABLES `jenis_barang` WRITE;
/*!40000 ALTER TABLE `jenis_barang` DISABLE KEYS */;
INSERT INTO `jenis_barang` VALUES ('JB001','Botol Minum'),('JB002','Cangkir'),('JB003','Waskom'),('JB004','Waskom'),('JB005','Keranjang'),('JB006','Mangkuk'),('JB007','Kotak makan'),('JB008','Toples'),('JB009','Gelas'),('JB010','Termos'),('JB011','Sendok Nasi');
/*!40000 ALTER TABLE `jenis_barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pemesanan`
--

DROP TABLE IF EXISTS `pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pemesanan` (
  `no_pesan` char(10) NOT NULL,
  `tgl_pesan` date NOT NULL,
  `total_pesan` double NOT NULL,
  `id_pengguna` char(10) NOT NULL,
  `id_distributor` char(10) NOT NULL,
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
INSERT INTO `pemesanan` VALUES ('PB2312001','2023-12-05',4069000,'USR003','SLR001'),('PB2312002','2023-12-07',5020000,'USR001','SLR002');
/*!40000 ALTER TABLE `pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pengguna` (
  `id_pengguna` char(10) NOT NULL,
  `nama_pengguna` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `telp_pengguna` varchar(13) NOT NULL,
  `alamat_pengguna` varchar(100) NOT NULL,
  `level` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pengguna`),
  UNIQUE KEY `nama_pengguna_UNIQUE` (`nama_pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengguna`
--

LOCK TABLES `pengguna` WRITE;
/*!40000 ALTER TABLE `pengguna` DISABLE KEYS */;
INSERT INTO `pengguna` VALUES ('USR001','Ali Akbar','aliakbar','admin','088801658736','Jl.Rambutan, Bangsalsari, Jember','Pemilik'),('USR002','Galang Sefian','galangsefian','admin','081353901995','JL.Mastrip,Jember','Karyawan'),('USR003','Alfito Dwi','alfitodwi','admin','082141236706','Perumahan Bangka Belitung, Jember','Karyawan');
/*!40000 ALTER TABLE `pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sementara_keluar`
--

DROP TABLE IF EXISTS `sementara_keluar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sementara_keluar` (
  `kode_barang` char(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `harga` double NOT NULL,
  `jml_keluar` int NOT NULL,
  `subtotal_keluar` double NOT NULL,
  `keterangan` varchar(25) NOT NULL
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
  `kode_barang` char(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `satuan` varchar(20) NOT NULL,
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
  `kode_barang` char(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `harga` double NOT NULL,
  `jml_pesan` int NOT NULL,
  `subtotal_pesan` double NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`kode_barang`)
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

-- Dump completed on 2023-12-16 10:58:02
