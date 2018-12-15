-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Des 2018 pada 10.33
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `savory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `nik` varchar(16) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`nik`, `id_produk`, `id_transaksi`) VALUES
('12346167128', 1, 1),
('12346167128', 2, 1),
('12346167128', 3, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_cashback_diskon`
--

CREATE TABLE `tbl_cashback_diskon` (
  `kode_voucher` varchar(7) NOT NULL,
  `persentase` int(11) NOT NULL,
  `pembayaran` enum('BNI','BCA','Indomaret') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_cashback_diskon`
--

INSERT INTO `tbl_cashback_diskon` (`kode_voucher`, `persentase`, `pembayaran`) VALUES
('KD001', 30, 'BNI');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_free_ongkir`
--

CREATE TABLE `tbl_free_ongkir` (
  `kode_voucher` varchar(7) NOT NULL,
  `potongan` int(6) NOT NULL,
  `pengiriman` enum('JNT','GOJEK','THE SAVORY') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_free_ongkir`
--

INSERT INTO `tbl_free_ongkir` (`kode_voucher`, `potongan`, `pengiriman`) VALUES
('KD002', 5000, 'JNT');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pembeli`
--

CREATE TABLE `tbl_pembeli` (
  `nik` varchar(16) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nohp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_pembeli`
--

INSERT INTO `tbl_pembeli` (`nik`, `nama`, `alamat`, `email`, `nohp`) VALUES
('12346167128', 'M Alif Abhiesa Al K', 'Jl Pangeran Sutajaya', 'abhiesa24@gmail.com', '09812219');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_produk`
--

CREATE TABLE `tbl_produk` (
  `id_produk` int(11) NOT NULL,
  `nama_produk` varchar(50) NOT NULL,
  `harga` int(7) NOT NULL,
  `ket` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_produk`
--

INSERT INTO `tbl_produk` (`id_produk`, `nama_produk`, `harga`, `ket`) VALUES
(1, 'Kue 1', 10000, 'ini adalah kue yang sangat enak banget'),
(2, 'Kue 2', 20000, 'ini kue kedua yang sangat enak banget'),
(3, 'Kue 3', 90000, 'Ini kue yang mahal banget'),
(4, 'Kue 4', 4000, 'ini kue paling murah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_staff`
--

CREATE TABLE `tbl_staff` (
  `nik_staff` varchar(16) NOT NULL,
  `nama_staff` varchar(30) NOT NULL,
  `alamat_staff` varchar(50) NOT NULL,
  `email_staff` varchar(30) NOT NULL,
  `nohp_staff` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_staff`
--

INSERT INTO `tbl_staff` (`nik_staff`, `nama_staff`, `alamat_staff`, `email_staff`, `nohp_staff`) VALUES
('11991001901', 'Naflah Q', 'Jl. P Selayar', 'naflaht@gmail.com', '09898109');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `kode_voucher` varchar(7) DEFAULT '0',
  `nik_staff` varchar(16) NOT NULL DEFAULT '0',
  `tgl_transaksi` date NOT NULL,
  `pembayaran` enum('BNI','BCA','Indomaret') NOT NULL,
  `pengiriman` enum('JNT','GOJEK','THE SAVORY') NOT NULL,
  `biaya_ongkir` int(11) NOT NULL,
  `status` enum('Paid','Pending','Cancel') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`id_transaksi`, `kode_voucher`, `nik_staff`, `tgl_transaksi`, `pembayaran`, `pengiriman`, `biaya_ongkir`, `status`) VALUES
(1, 'KD001', '11991001901', '2018-12-14', 'BNI', 'JNT', 11000, 'Pending'),
(5, 'KD002', '11991001901', '2018-12-15', 'BNI', 'JNT', 12000, 'Paid');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_voucher`
--

CREATE TABLE `tbl_voucher` (
  `kode_voucher` varchar(7) NOT NULL,
  `nama_voucher` varchar(30) NOT NULL,
  `valid_until` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_voucher`
--

INSERT INTO `tbl_voucher` (`kode_voucher`, `nama_voucher`, `valid_until`) VALUES
('KD001', 'Diskon 30%', '2018-12-15'),
('KD002', 'Free Ongkir 5Rb', '2018-12-16');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `FK_detail_transaksi_tbl_pembeli` (`nik`),
  ADD KEY `FK_detail_transaksi_tbl_produk` (`id_produk`),
  ADD KEY `FK_detail_transaksi_tbl_transaksi` (`id_transaksi`);

--
-- Indeks untuk tabel `tbl_cashback_diskon`
--
ALTER TABLE `tbl_cashback_diskon`
  ADD PRIMARY KEY (`kode_voucher`);

--
-- Indeks untuk tabel `tbl_free_ongkir`
--
ALTER TABLE `tbl_free_ongkir`
  ADD PRIMARY KEY (`kode_voucher`);

--
-- Indeks untuk tabel `tbl_pembeli`
--
ALTER TABLE `tbl_pembeli`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `tbl_produk`
--
ALTER TABLE `tbl_produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `tbl_staff`
--
ALTER TABLE `tbl_staff`
  ADD PRIMARY KEY (`nik_staff`);

--
-- Indeks untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `FK_tbl_transaksi_tbl_staff` (`nik_staff`),
  ADD KEY `FK_tbl_transaksi_tbl_voucher` (`kode_voucher`);

--
-- Indeks untuk tabel `tbl_voucher`
--
ALTER TABLE `tbl_voucher`
  ADD PRIMARY KEY (`kode_voucher`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_produk`
--
ALTER TABLE `tbl_produk`
  MODIFY `id_produk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `FK_detail_transaksi_tbl_pembeli` FOREIGN KEY (`nik`) REFERENCES `tbl_pembeli` (`nik`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_detail_transaksi_tbl_produk` FOREIGN KEY (`id_produk`) REFERENCES `tbl_produk` (`id_produk`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_detail_transaksi_tbl_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `tbl_transaksi` (`id_transaksi`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD CONSTRAINT `FK_tbl_transaksi_tbl_staff` FOREIGN KEY (`nik_staff`) REFERENCES `tbl_staff` (`nik_staff`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tbl_transaksi_tbl_voucher` FOREIGN KEY (`kode_voucher`) REFERENCES `tbl_voucher` (`kode_voucher`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
