# LP7DPBO2024C1

## JANJI
*Saya Alif Faturahman Firdaus (2107377) mengerjakan Latihan Praktikum 7 dalam mata kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.*

## TUGAS
Lanjutkan program Flappy Bird di atas dan tambahkan fitur-fitur berikut:
1. Hentikan permainan saat player menabrak/menyentuh pipa atau terjatuh ke batas bawah JFrame (Game Over);
2. Setelah Game Over, tambahkan fungsionalitas untuk restart permainan dengan menekan tombol “R” pada keyboard.
3. Buat sebuah JLabel untuk menampilkan skor;
4. Tambah skor (+1) setiap kali player melewati pipa;

**BONUS MAIN MENU (+20)**  
Tambahkan sebuah GUI Form baru yang ditampilkan di awal program (sebelum JFrame game FlappyBird). GUI Form berisi sebuah tombol yang saat ditekan akan menutup dirinya sendiri dan membuka JFrame game.

## DESAIN PROGRAM
Terdapat 5 class pada program Flappy Bird yang saya buat, diantaranya :

### 1. Kelas App

Program di atas bertujuan untuk membuat antarmuka aplikasi permainan Flappy Bird. Dalam metode main(), sebuah JFrame dibuat dengan judul "Flappy Bird" dan konfigurasi properti seperti penutupan aplikasi dan ukuran frame. Kemudian, objek FlappyBird dibuat dan ditambahkan ke dalam JFrame.

### 2. Kelas Flappy Bird

Kelas Flappy Bird berperan sebagai pengatur utama bagi permainan Flappy Bird itu sendiri. Dalam kelas ini, proses logika permainan diterapkan. Ini mencakup pembuatan elemen-elemen kunci dalam permainan seperti gambar burung dan pipa, mengatur pergerakan objek-objek permainan, menangani tabrakan antara objek-objek tersebut, serta memeriksa dan mengelola skor pemain.

### 3. Kelas Main Menu Form

Kelas App memiliki tanggung jawab untuk menampilkan GUI Form atau menu utama dari permainan Flappy Bird. Saat pengguna membuka aplikasi, kelas ini akan menciptakan dan menampilkan sebuah JFrame yang memuat menu utama. Pengguna dapat memulai permainan dengan mengklik tombol "Start Game" yang tersedia di menu utama. Setelah tombol tersebut ditekan, kelas ini akan menutup menu utama dan membuka permainan Flappy Bird dengan memunculkan kelas FlappyBird.

### 4. Kelas Pipe

Kelas Pipe merepresentasikan pipa atas dan pipa bawah. Berikut adalah beberapa atributnya :

* *posX dan posY* : Mengatur posisi pipa di layar.
* *width and height*: Mengatur lebar dan tinggi burung.
* *image*: Untuk mengatur gambar yang digunakan untuk kebutuhan permainan
* *velocityY*: Menyimpan kecepatan horizontal pipa, yang digunakan untuk mengatur gerakan pipa dari kanan ke kiri.
* *passed*: Menyimpan status apakah pasangan pipa ini sudah dilewati oleh pemain atau belum.
  
### 5. Kelas Player

Kelas Player merepresentasikan pemain sebagai burungnya. Berikut adalah beberapa atributnya :
* *posX dan posY* : Untuk mengatur posisi burung pada layar
* *width and height* : Untuk mengatur lebar dan tinggi burung
* *image* : Untuk mengatur gambar yang digunakan untuk kebutuhan permainan
* *velocityY* : Untuk menyimpan kecepatan vertikal pemain, digunakan untuk mengatur gerakan lompatan burung

## PENJELASAN ALUR
1. Awal tampilan program dimulai dengan menampilkan GUI Form (Main Menu)
2. User dapat menekan tombol "*Start Game*" untuk memulai permainan
3. User harus menekan tombol "*space*" supaya burung dapat terbang/melompat berulang kali sehingga burung tidak akan jatuh dan mengenai batas bawah frame ataupun menyentuh pipa
4. Terdapat beberapa aturan dalam permainan :
    * Jika burung menyentuh batas atas frame, maka tidak akan terjadi apa-apa
    * Jika burung menyentuh pipa (pipa atas atau pipa bawah), maka permainan akan berakhir
    * Jika burung menyentuh batas bawah frame, maka permainan akan berakhir
5. Burung yang berhasil melewati pipa akan mendapatkan score (+1) setiap pipanya
6. Burung yang menyentuh batas bawah frame dan juga menyentuh pipa akan menampilkan pesan "*Game Over*"
7. Jika permainan berakhir dan user masih ingin bermain kembali, maka tekan tombol "R" pada keyboard untuk melakukan *restart*
8. Saat user melakukan *restart* maka score akan direset kembali menjadi 0 dan menghapus pesan "*Game Over*"

## DOKUMENTASI
Berikut adalah video demonstrasi dari permainan Flappy Bird :

https://github.com/Aliffaturahman/LP7DPBO2024C1/assets/100842759/0881be44-4553-4179-97bb-315b0d5088e8
