CREATE DATABASE db_inventaris;
USE db_inventaris;

CREATE TABLE jenis_barang(
kode_jenis CHAR(10) PRIMARY KEY NOT NULL,
nama_jenis VARCHAR(45) NOT NULL
);

CREATE TABLE barang(
kode_barang CHAR(10) PRIMARY KEY NOT NULL,
nama_barang VARCHAR(45) NOT NULL,
satuan VARCHAR(10) NOT NULL,
harga DOUBLE NOT NULL,
stok INT NOT NULL,
kode_jenis CHAR(10) NOT NULL,
CONSTRAINT fk_jenis_barang FOREIGN KEY (kode_jenis) REFERENCES jenis_barang(kode_jenis)
);

CREATE TABLE pengguna(
id_pengguna CHAR(10) PRIMARY KEY NOT NULL,
nama_pengguna VARCHAR(45) NOT NULL,
username VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
telp_pengguna VARCHAR(13) NOT NULL,
alamat_pengguna VARCHAR(100) NOT NULL,
Level VARCHAR(20) NOT NULL
);

CREATE TABLE distributor(
id_distributor CHAR(10) PRIMARY KEY NOT NULL,
nama_distributor VARCHAR(45) NOT NULL,
telp_distributor VARCHAR(13) NOT NULL,
alamat_distributor VARCHAR(100) NOT NULL
);

CREATE TABLE pemesanan(
no_pesan CHAR(10) PRIMARY KEY NOT NULL,
tgl_pesan DATE NOT NULL,
total_pesan DOUBLE NOT NULL,
id_pengguna CHAR(10) NOT NULL,
id_distributor CHAR(10) NOT NULL,
CONSTRAINT fk_pengguna FOREIGN KEY (id_pengguna) REFERENCES pengguna(id_pengguna),
CONSTRAINT fk_distributor FOREIGN KEY (id_distributor) REFERENCES distributor(id_distributor)
);

CREATE TABLE barang_masuk(
no_masuk CHAR(10) PRIMARY KEY NOT NULL,
tgl_masuk DATE NOT NULL,
total_masuk DOUBLE NOT NULL,
id_pengguna CHAR(10) NOT NULL,
id_distributor CHAR(10) NOT NULL, 
CONSTRAINT fk_pengguna1 FOREIGN KEY (id_pengguna) REFERENCES pengguna(id_pengguna),
CONSTRAINT fk_distributor1 FOREIGN KEY (id_distributor) REFERENCES distributor(id_distributor)
);

CREATE TABLE barang_keluar(
no_keluar CHAR(10) PRIMARY KEY NOT NULL,
tgl_keluar DATE NOT NULL,
total_keluar DOUBLE NOT NULL,
id_pengguna CHAR(10) NOT NULL,
CONSTRAINT fk_pengguna2 FOREIGN KEY (id_pengguna) REFERENCES pengguna(id_pengguna)
);

CREATE TABLE detail_pemesanan(
no_pesan CHAR(10) NOT NULL,
kode_barang CHAR(10) NOT NULL,
jml_pesan INT NOT NULL,
subtotal_pesan DOUBLE NOT NULL,
CONSTRAINT fk_pemesanan FOREIGN KEY (no_pesan) REFERENCES pemesanan(no_pesan),
CONSTRAINT fk_barang FOREIGN KEY (kode_barang) REFERENCES barang(kode_barang)
);


CREATE TABLE detail_barang_masuk(
no_masuk CHAR(10) NOT NULL,
kode_barang CHAR(10) NOT NULL,
jml_masuk INT NOT NULL,
subtotal_masuk DOUBLE NOT NULL,
CONSTRAINT fk_barang_masuk FOREIGN KEY (no_masuk) REFERENCES barang_masuk(no_masuk),
CONSTRAINT fk_barang1 FOREIGN KEY (kode_barang) REFERENCES barang(kode_barang)
);

CREATE TABLE detail_barang_keluar(
no_keluar CHAR(10) NOT NULL,
kode_barang CHAR(10) NOT NULL,
jml_keluar INT NOT NULL,
subtotal_keluar DOUBLE NOT NULL,
CONSTRAINT fk_barang_keluar FOREIGN KEY (no_keluar) REFERENCES barang_keluar(no_keluar),
CONSTRAINT fk_barang2 FOREIGN KEY (kode_barang) REFERENCES barang(kode_barang)
);
