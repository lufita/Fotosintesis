package com.example.fotosintesis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;;
import java.util.Arrays;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;

public class kuis_soal extends AppCompatActivity {

    //Kamus:
    ImageView gambar;
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            "Kita tahu bahwa dalam proses Fotosintesis terdapat C02 dan 02, peran dari kedua molekul tersebut sangat penting, lalu apa peran 02 itu ....",
            "Perbedaan berkas pengangkut pada batang monokotil dengan batang dikotil adalah ....",
            "Rambut atau bulu akar hanya terdapat pada bagian akar yang masih muda yang merupakan penonjolan atau diferensiasi dari jaringan ....",
            "Perhatikan anatomi daun berikut!\nJaringan yang ditunjukkan oleh huruf X merupakan salah satu jaringan penyusun daun. Jaringan X disebut jaringan ... dan berfungsi untuk ....",
            "Jaringan epidermis pada bagian bawah daun berubah bentuk menjadi ....",
            "Korteks yang terdapat pada batang berfungsi sebagai ....",
            "Perhatikan gambar berikut!\nBagian yang berfungsi sebagai jaringan pengangkut ditunjukkaan pada bagian bernomor ....",
            "Berikut ini, bagian-bagian akar yang dilalui oleh air tanah secara berturut turut adalah ....",
            "Pada umumnya akar menuju ke pusat bumi karena pengaruh gaya gravitasi, tetapi bakau tidak demikian. Gerakan akar pada bakau disebut ....",
            "Struktur daun yang berfungsi sebagai tempat pembuatan makanan dan tempat pertukaran udara dalam tumbuhan secara beturut-turut adalah....",
            "Umur pohon dapat dilihat dari garis-garis yang menunjukkan hasil kegiatan dari suatu masa pertumbuhan. Garis-garis itu disebut ....",
            "Yang merupakan jaringan pengangkut adalah ....",
            "Perhatikan gambar anatomi akar berikut!\nBerdasarkan gambar, fungsi dari struktur X adalah ....",
            "Bagian daun yang melakukan fotosintesis adalah ....",
            "Jaringan yang berfungsi menyebarkan hasil fotosintesis ke seluruh bagian adalah....",
            "Lapisan pelindung pada daun tumbuhan yang menginspirasi pembuatan lapisan pengilap cat mobil adalah ....",
            "Pada endodermis ditemukan bentukan seperti pita yang berfungsi sebagai pengatur jalannya larutan yang diserap dari tanah masuk ke silinder pusat yang disebut ...",
            "Berikut ini merupakan teknologi yang terinspirasi dari proses fotosintesis yang terjadi dalam daun adalah ….",
            "Gerak fototropisme ditunjukkan oleh gerak ....",
            "Dalam proses fotosintesis, C02 memiliki peran yang penting, maka fungsi dari C02 ...."
    };

    String[] pilih_jawaban = new String[]{
            "mengetahui bahwa amilum terdapat pada seluruh bagian daun", "mengetahui bahwa pada fotosintesis terbentuk gas oksigen", "Oksigen berfungsi dalam reaksi metabolisme tumbuhan karena oksigen penting dalam respirsi yang menghasilkan energi.", "mengetahui bahwa klorofil diperlukan dalam fotosintesis",
            "berkas pengangkut pada dikotil tidak memiliki kambium", "berkas pengangkut pada monokotil tersusun beraturan", "berkas pengangkut pada dikotil tersusun tidak beraturan", "berkas pengangkut pada dikotil dipisahkan oleh kambium",
            "korteks", "epidermis", "endodermis", "silinder pusat",
            "palisade, berperan dalam fotosintesis", "palisade, berperan dalam pengangkutan air", "bunga karang, berperan dalam fotosintesis", "bunga karang, berperan dalam pengangkutan air",
            "lentisel", "stomata", "lapisan lilin", "palisade",
            "pengangkutan hasil fotosintesis", "pengangkutan air", "tempat penyimpanan makanan", "jalan respirasi",
            "1 dan 3", "2 dan 5", "3 dan 4", "3 dan 5",
            "kulit luar – kambium –endodermis – xilem akar", "epidermis rambut akar – kambium – parenkim – xilem akar", "epidermis rambut akar – endodermis – parenkim – xilem akar", "epidermis rambut akar – parenkim – endodermis – xilem akar",
            "geotropisme negatif", "tigmotropisme negatif", "geotropisme positif", "tigmotropisme positif",
            "jaringan sponsa dan floem", "jaringan sponsa dan epidermis", "jaringan palisade dan stomata", "jaringan palisade dan xilem",
            "xilem", "felogen", "parenkim kayu", "lingkaran tahun",
            "Floem", "Epidermis", "Parenkim", "Kolenkim",
            "Melindungi akar ketika menembus tanah", "Memperluas daerah penyerapan air dan unsur hara dari tanah", "Mengangkut air dan usur hara dari tanah", "Menopang pohon untuk tetap dapat berdiri",
            "kortex", "plastida", "kutikula", "stomata",
            "rambut akar", "epidermis", "endodermis", "floem",
            "floem", "kutikula", "endodermis", "rambut akar",
            "pita kaspari", "pita kasperra", "pita kasuari", "pita kasparov",
            "Light-dependent resistor", "Lapisan pengilap cat mobil", "Alat pemurnian air", "Panel surya",
            "akar tumbuhan menuju pusat bumi", "bunga matahari menghadap sumber cahaya", "akar mendekati sumber air", "bunga pukul empat menutup daun di sore hari",
            "CO2 berguna untuk mengakut 02 untuk membuat makanan", "C02 dan matahari digunakan dalam proses fotosintesis", "Daun menyerap CO2 dari atmosfer yang kemudian bereaksi dengan air untuk menghasilkan glukosa.", "CO2 dan 02 digunakan untuk mengangkut sari makanan",
    };

    String[] jawaban_benar = new String[]{
            "Oksigen berfungsi dalam reaksi metabolisme tumbuhan karena oksigen penting dalam respirsi yang menghasilkan energi.",
            "berkas pengangkut pada dikotil dipisahkan oleh kambium",
            "epidermis",
            "palisade, berperan dalam fotosintesis",
            "stomata",
            "tempat penyimpanan makanan",
            "3 dan 5",
            "epidermis rambut akar – parenkim – endodermis – xilem akar",
            "geotropisme negatif",
            "jaringan palisade dan stomata",
            "lingkaran tahun",
            "Floem",
            "Memperluas daerah penyerapan air dan unsur hara dari tanah",
            "plastida",
            "floem",
            "kutikula",
            "pita kaspari",
            "Panel surya",
            "bunga matahari menghadap sumber cahaya",
            "Daun menyerap CO2 dari atmosfer yang kemudian bereaksi dengan air untuk menghasilkan glukosa."
    };

    Integer[] Images = new Integer[]{
            R.drawable.o2,
            R.drawable.iconbatang,
            R.drawable.iconakar,
            R.drawable.soal1,
            R.drawable.daun,
            R.drawable.iconbatang,
            R.drawable.soal2,
            R.drawable.iconakar,
            R.drawable.matahari,
            R.drawable.daun2,
            R.drawable.lingkaran_tahun,
            R.drawable.iconsemangka,
            R.drawable.soal3,
            R.drawable.daunbanyak,
            R.drawable.iconbunga,
            R.drawable.icondaun,
            R.drawable.iconakar,
            R.drawable.iconsemangka,
            R.drawable.matahari,
            R.drawable.co2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_soal);

        //Diskripsi:
        quis = (TextView) findViewById(R.id.quis);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        pilihA = (RadioButton) findViewById(R.id.pilihA);
        pilihB = (RadioButton) findViewById(R.id.pilihB);
        pilihC = (RadioButton) findViewById(R.id.pilihC);
        pilihD = (RadioButton) findViewById(R.id.pilihD);
        gambar = (ImageView) findViewById(R.id.iv_gambar);

        radiogroup.check(0);
        benar = 0;
        salah = 0;

        //Collections.shuffle(Arrays.asList(pertanyaan));

        //Fungtion
        quis.setText(pertanyaan[nomor]);
        pilihA.setText(pilih_jawaban[0]);
        pilihB.setText(pilih_jawaban[1]);
        pilihC.setText(pilih_jawaban[2]);
        pilihD.setText(pilih_jawaban[3]);
        gambar.setImageResource(Images[nomor]);

    }

    //Function:
    public void next(View view) {
        if (pilihA.isChecked() || pilihB.isChecked() || pilihC.isChecked() || pilihD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            radiogroup.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {
                quis.setText(pertanyaan[nomor]);
                pilihA.setText(pilih_jawaban[(nomor*4)+0]);
                pilihB.setText(pilih_jawaban[(nomor*4)+1]);
                pilihC.setText(pilih_jawaban[(nomor*4)+2]);
                pilihD.setText(pilih_jawaban[(nomor*4)+3]);
                gambar.setImageResource(Images[nomor]);

            } else {
                hasil = benar * 5;
                finish();
                Intent selesai = new Intent(getApplicationContext(), score_kuis.class);
                startActivity(selesai);
            }
        }
        else
        {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Anda Belum Mengerjakan Evaluasi, Yakin Akan Keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

}
