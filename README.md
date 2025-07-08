# Anggota Kelompok
- Muhammad Irsyad Mustaqim (1237050050)
- Muhammad Jalallullail (1237050025)
- Jordan Marcellino (1237050102)



# 🐾 Website Manajemen Adopsi Kucing

Website ini merupakan aplikasi manajemen adopsi kucing berbasis web yang dibangun menggunakan Spring Boot, *Thymeleaf*, *Bootstrap 5*, dan *MySQL*. Tujuan utama dari aplikasi ini adalah untuk membantu shelter, pet shop, atau tempat adopsi hewan dalam mengelola informasi kucing yang tersedia untuk diadopsi secara efisien, rapi, dan modern.

---

## 📘 Pengertian

Website manajemen adopsi kucing ini adalah sistem berbasis web yang dirancang untuk menyimpan, menampilkan, dan mengelola data kucing yang dapat diadopsi oleh masyarakat. Sistem ini memungkinkan admin (pengelola shelter atau tempat adopsi) untuk:

- Menambahkan data kucing baru beserta foto dan deskripsi.
- Mengedit atau menghapus data kucing.
- Menandai status adopsi dan validasi dari setiap kucing.
- Melihat daftar kucing berdasarkan filter seperti ras, jenis kelamin, status adopsi, dan validasi 

Website ini tidak menggunakan sistem login, sehingga hanya digunakan secara lokal atau internal oleh petugas yang dipercaya. Cocok untuk digunakan oleh shelter kecil, komunitas pecinta kucing, atau usaha adopsi rumahan.

---

## 🎯 Tujuan Proyek

- Membantu pengelolaan data kucing adopsi secara sistematis.
- Menyediakan antarmuka pengguna yang ramah dan responsif.
- Mengurangi pencatatan manual dalam proses adopsi.

---

## 🚀 Teknologi yang Digunakan

| Teknologi         | Keterangan |
|-------------------|------------|
| Java 17+          | Bahasa utama pemrograman |
| Spring Boot       | Framework backend |
| Thymeleaf         | Template engine untuk frontend |
| Bootstrap 5       | Framework UI responsif |
| MySQL             | Basis data relasional |
| Maven             | Manajemen dependensi |
| VS Code           | IDE yang digunakan dalam pengembangan |

---

## 🖥 Fitur-Fitur Utama

- ✅ Tambah/Edit/Hapus Data Kucing
- 📸 Upload dan tampilkan foto kucing
- 🔍 Filter berdasarkan nama, ras, gender, status adopsi & validasi
- 👁 Lihat detail kucing lengkap
- 🌙 Desain UI modern dan responsif (mobile friendly)

---

## 📂 Struktur Proyek (Sederhana)


src/
├── controller/        # Mengatur routing dan HTTP logic
├── model/             # Entity Cat
├── repository/        # Interface JpaRepository
├── service/           # Logic aplikasi
└── templates/         # File HTML (Thymeleaf)


---

## 📸 Cuplikan Tampilan

| Halaman | Tampilan |
|--------|----------|
| Daftar Kucing | ![list](screenshots/list.png) |
| Form Tambah/Edit | ![form](screenshots/form.png) |
| Detail Kucing | ![detail](screenshots/detail.png) |

---

## ⚙ Cara Menjalankan Proyek

1. Clone repositori
   bash
   git clone https://github.com/namakamu/cat-adoption.git
   cd cat-adoption
   

2. Atur database
   - Buat database MySQL, misalnya: cat_adoption
   - Sesuaikan application.properties:
     properties
     spring.datasource.url=jdbc:mysql://localhost:3306/cat_adoption
     spring.datasource.username=root
     spring.datasource.password=1234
     upload.dir=/src/main/resources/static/images
     

3. Jalankan aplikasi
   - Menggunakan terminal atau VS Code:
     bash
     mvn spring-boot:run
     

4. Buka di browser
   
   http://localhost:8080/cats
   

---

## 🙋 Kontribusi

Jika kamu ingin membantu meningkatkan sistem ini (misalnya menambah login admin, fitur adopsi online, atau validasi otomatis), silakan fork dan ajukan pull request. Terbuka untuk kontribusi edukatif.

---

## 📄 Lisensi

Proyek ini dikembangkan untuk keperluan pembelajaran dan tugas kuliah. Bebas digunakan dan dimodifikasi dengan menyertakan atribusi.

---
