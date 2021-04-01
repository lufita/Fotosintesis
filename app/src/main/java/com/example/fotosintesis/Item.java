package com.example.fotosintesis;

public class Item extends Database{

    String pertanyaan, pilih_jawaban, jawaban_benar;
    Integer images;

    public Item(String pertanyaan, String pilih_jawaban, String jawaban_benar, Integer images){
        this.pertanyaan = pertanyaan;
        this.pilih_jawaban = pilih_jawaban;
        this.jawaban_benar = jawaban_benar;
        this.images = images;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public String getPilih_jawaban() {
        return pilih_jawaban;
    }

    public String getJawaban_benar() {
        return jawaban_benar;
    }

    public Integer getImages() {
        return images;
    }
}
