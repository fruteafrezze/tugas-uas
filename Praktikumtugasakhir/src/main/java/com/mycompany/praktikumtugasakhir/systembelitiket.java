/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikumtugasakhir;

import java.util.Scanner;
import java.util.Random;



/**
 *
 * @author FILIPUS FERRY
 */
public class systembelitiket {
    public static void main(String[] args) {
        String nama, nomorKTP, email, nomorTelepon;

        Scanner input = new Scanner(System.in);
        
        String[] jenisTiket = {"crowd", "reguler", "vip", "vvip"};
        int[] hargaTiket = { 50000, 75000, 150000, 250000};
        int n = jenisTiket.length;
        int pilihan=0;
        int jumlahTiket=0;

        System.out.println("no\t\tGolongan Tiket\t\tHarga");
        for (int i = 0; i < n; i++) {
        System.out.println((i+1)+".\t\t"+jenisTiket[i]+"\t\t\tRp."+hargaTiket[i]);
        }
        System.out.print("Pilih tiket yang ingin dibeli(1/2/3/4): ");
        pilihan= input.nextInt();
        if (pilihan==1) {
            System.out.println("tiket yang dipilih: "+jenisTiket[0]+"\tRp. "+hargaTiket[0]);
            System.out.print("jumlah tiket yang ingin dibeli: ");
            jumlahTiket=input.nextInt();
        } else if (pilihan==2) {
            System.out.println("tiket yang dipilih: "+jenisTiket[1]+"\tRp. "+hargaTiket[1]);
            System.out.print("jumlah tiket yang ingin dibeli: ");
            jumlahTiket=input.nextInt();
        } else if (pilihan==3) {
            System.out.println("tiket yang dipilih: "+jenisTiket[2]+"\tRp. "+hargaTiket[2]);
            System.out.print("jumlah tiket yang ingin dibeli: ");
            jumlahTiket=input.nextInt();
        } else if (pilihan==4) {
            System.out.println("tiket yang dipilih: "+jenisTiket[3]+"\tRp. "+hargaTiket[3]);
            System.out.print("jumlah tiket yang ingin dibeli: ");
            jumlahTiket=input.nextInt();
        }double totalHarga = jumlahTiket*hargaTiket[(pilihan-1)];
        System.out.println("total harga Rp."+totalHarga);

        // Minta input data diri
        System.out.print("Nama\t\t: ");
        nama = input.next();

        System.out.print("Nomor KTP\t: ");
        nomorKTP = input.next();
        
        System.out.print("Email\t\t: ");
        email = input.next();
        
        System.out.print("Nomor telepon\t: ");
        nomorTelepon = input.next();
        System.out.println("------------------------------------");

        
        if (nama.isEmpty() || nomorKTP.isEmpty() || email.isEmpty() || nomorTelepon.isEmpty()) {
            System.out.println("Data diri tidak lengkap.");
            return;
        }
        pembayaran(totalHarga);
  
    }
    static void pembayaran(double n){
        Scanner bayar = new Scanner (System.in);
         System.out.println("Pilih metode pembayaran:");
         System.out.println("1. E-Wallet");
         System.out.println("2. Kartu kredit");
         System.out.println("3. Kartu debit");
         System.out.println("Masukkan pilihan anda (1/2/3): ");
         int metodePembayaran = bayar.nextInt();
         
         if (metodePembayaran==1){
             System.out.print("Masukkan ID E-Wallet: ");
             String eWallet = bayar.next();
         } else if (metodePembayaran==2){
             System.out.print("Masukkan Nomor Kartu Kredit: ");
             String kartuKredit = bayar.next();
         } else {
             System.out.print("Masukan Nomor Kartu Debit: ");
             String kartuDebit = bayar.next();
         }
         System.out.print("Anda yakin untuk membayar? (ya/tidak): ");
        String pilihan = bayar.next();

        if ("ya".equalsIgnoreCase(pilihan)) {
            String kodeUnik = generateRandomCode();
            System.out.println("Kode unik pembayaran: " + kodeUnik);

            System.out.print("Masukkan kode pembayaran: ");
            String kodePembayaran = bayar.next();

            if (kodePembayaran.equals(kodeUnik)) {
                System.out.println("Pembayaran berhasil");
            } else {
                System.out.println("Pembayaran gagal");
            }
        } else {
            System.out.println("Pembayaran dibatalkan");
        }
    }

    public static String generateRandomCode() {
        String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
     int length =6;
     Random random = new Random ();
        StringBuilder sb = new StringBuilder (length);
        for (int i = 0; i< length ;i++){
            char randomchar = karakter.charAt(random.nextInt(karakter.length()));

          sb.append(randomchar);
        }
        return sb.toString(); 
    }
}
