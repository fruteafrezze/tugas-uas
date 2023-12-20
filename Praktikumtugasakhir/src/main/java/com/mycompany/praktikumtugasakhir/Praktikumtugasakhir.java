/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */package com.mycompany.praktikumtugasakhir;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author FILIPUS FERRY
 */
public class Praktikumtugasakhir {
    static boolean isProgramRunning = true;
    static boolean isLoggedIn = false;
    static String[] jenisTiket = {"crowd", "reguler", "vip", "vvip"};
    static int [] maxKuota = {150, 150, 90, 60};
    static int[] jumlahKursi = new int[4];
    static int jumlahTiket=0;
    

    static Map<String, String> databaseUser = new HashMap<>();
    public static void main(String[] args) {
        Thread musicThread = new Thread(() -> playBackgroundMusic("Only Today (Instrumental).wav"));
        musicThread.start();
        mainProgram();
        isProgramRunning = false;
        try {
            musicThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void mainProgram(){
        Scanner in = new Scanner(System.in);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int pilihan=0;
        System.out.println("===================================");
        System.out.println("             FUNFEST.ID      ");
        System.out.println("===================================");
        System.out.println("<       GOR UNY 20/12/2023        >");
        System.out.println("<         THE GUEST STAR          >");
        System.out.println("<              JKT48              >");
        System.out.println("<  Selamat Datang di FUNFEST.ID   >");
        System.out.println("< Silahkan pilih menu dibawah ini >");
        System.out.println();
        do {
        System.out.println("          MENU          ");
        System.out.println("1. Check Harga.");
        System.out.println("2. Check kuota kursi tersisa.");
        System.out.println("3. Beli tiket.");
        System.out.println("4. Tentang FUNFEST.ID ");
        System.out.println("5. keluar.");
        System.out.print("masukan pilihan anda : ");
        pilihan=in.nextInt();
        System.out.println();
            switch (pilihan) {
                case 1:
                    checkHarga(pilihan);
                    break;
                case 2:
                    checkKuota();
                    break;
                case 3:
                    beliTiket();
                    break;
                case 4:
                    tentangFunfest();
                    break;
                default:
                    break;
            }
        } while (pilihan < 5);
        System.out.println(" v_v terima kasih telah berkunjung v_v ");
        System.out.println();
    }
    private static void playBackgroundMusic(String filePath) {
        if (isProgramRunning) {
            try {
                File audioFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                clip.start();


                while (clip.isRunning()) {
                    Thread.sleep(0);
                }

                clip.loop(5);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }
    static void checkHarga (int pilihan){
       
        String[] jenisTiket = {"crowd", "reguler", "vip", "vvip"};
        int[] hargaTiket = { 50000, 75000, 150000, 250000};
        int n = jenisTiket.length;

        System.out.println("no\t\tGolongan Tiket\t\tHarga");
        for (int i = 0; i < n; i++) {
        System.out.println((i+1)+".\t\t"+jenisTiket[i]+"\t\t\tRp."+hargaTiket[i]);
   
        }
        System.out.println();
        System.out.println("""
                                           THE STAGE
                            CCC    $$$$$$$$$$$   $$$$$$$$$$$   CCC
                            CCC    $$$$$$$$$$$   $$$$$$$$$$$   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC              BALKON            CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
                           """);
        System.out.println("""
                           note:
                           $  : Area VVIP
                           V  : Area VIP
                           R  : Area Reguler
                           C  : Area Crowd
                           """);
        System.out.println();
    }
    static void checkKuota (){
        System.out.println("                  Check Kuota Kursi FUNFEST.ID");
        for (int i = 0; i < maxKuota.length; i++) {
        System.out.println((i+1)+".\t\t"+jenisTiket[i]+"\t\t\ttersisa "+jumlahKursi[i]+"/"+maxKuota[i]+" kursi.");
   
        }
        System.out.println();
    }
    public static void beliTiket(){
        Scanner in = new Scanner(System.in);
        int pilihan=0, hargaFinal=0;
        String nama, nomorKTP, email, nomorTelepon, jenisFinal="";

        Scanner input = new Scanner(System.in);

        String[] jenisTiket = {"crowd", "reguler", "vip", "vvip"};
        int[] hargaTiket = { 50000, 75000, 150000, 250000};
        int n = jenisTiket.length;
         while (!isLoggedIn) {  
             System.out.println("\t\t==<MASUK AKUN>==");
            System.out.println("1. login");
            System.out.println("2. sign up");
            System.out.print("pilih opsi (1/2): ");
            pilihan = in.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.println("\t-- MASUK AKUN --");
                    login();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\t-- BUAT AKUN --");
                    signUp();
                    System.out.println();
                    break;
                default:
                    break;
            }
         }
        System.out.println();
        System.out.println("""
                                           THE STAGE
                            CCC    $$$$$$$$$$$   $$$$$$$$$$$   CCC
                            CCC    $$$$$$$$$$$   $$$$$$$$$$$   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    VVVVVVVVVVV   VVVVVVVVVVV   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC              BALKON            CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCC    RRRRRRRRRRR   RRRRRRRRRRR   CCC
                            CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
                           """);
        System.out.println("""
                           note:
                           $  : Area VVIP
                           V  : Area VIP
                           R  : Area Reguler
                           C  : Area Crowd
                           """);
        System.out.println();
         System.out.println("no\t\tGolongan Tiket\t\tHarga");
        for (int i = 0; i < n; i++) {
        System.out.println((i+1)+".\t\t"+jenisTiket[i]+"\t\t\tRp."+hargaTiket[i]);
        }
        System.out.print("Pilih tiket yang ingin dibeli(1/2/3/4): ");
        pilihan= input.nextInt();
        jenisFinal=jenisTiket[(pilihan-1)];
        hargaFinal=hargaTiket[(pilihan-1)];

            switch (pilihan) {
                case 1:
                    System.out.println("tiket yang dipilih\t: "+jenisTiket[0]+"\tRp. "+hargaTiket[0]);
                    System.out.print("jumlah tiket yang ingin dibeli: ");
                    jumlahTiket=input.nextInt();
                    jumlahKursi[0]=jumlahTiket;
                    break;
                case 2:
                    System.out.println("tiket yang dipilih\t: "+jenisTiket[1]+"\tRp. "+hargaTiket[1]);
                    System.out.print("jumlah tiket yang ingin dibeli: ");
                    jumlahTiket=input.nextInt();
                    jumlahKursi[1]=jumlahTiket;

                    break;
                case 3:
                    System.out.println("tiket yang dipilih\t: "+jenisTiket[2]+"\tRp. "+hargaTiket[2]);
                    System.out.print("jumlah tiket yang ingin dibeli: ");
                    jumlahTiket=input.nextInt();
                    jumlahKursi[2]=jumlahTiket;
                    break;
                case 4:
                    System.out.println("tiket yang dipilih\t: "+jenisTiket[3]+"\tRp. "+hargaTiket[3]);
                    System.out.print("jumlah tiket yang ingin dibeli: ");
                    jumlahTiket=input.nextInt();
                    jumlahKursi[3]=jumlahTiket;
                    break;
                default:
                    break;
            }
        double totalHarga = jumlahTiket*hargaTiket[(pilihan-1)];
        System.out.println();
        System.out.println("== MASUKAN DATA DIRI ==");
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
        }
        pembayaran(totalHarga);
        System.out.println();
        System.out.println("=============================================================================");
        System.out.println("\t== \t\t\tINVOICE TIKET\t\t\t ==");
        System.out.println("=============================================================================");
        System.out.println("Nomor Pembelian\t: INVC/"+generateRandomNumber());
        System.out.println("nama\t\t: "+nama);
        System.out.println("Nomot Telepon\t: "+nomorTelepon);
        System.out.println("Email\t\t: "+email);
        System.out.println("=============================================================================");
        
        System.out.println("Jenis Tiket\t\tJumlah Tiket\t\tHarga Tiket\tHarga Total");
        System.out.println(jenisFinal+"\t\t\t"+jumlahTiket+"\t\t\t"+hargaFinal+"\t\t"+totalHarga);
        System.out.println("\tGOR UNY\t\t\t20 Desember 2023");
        System.out.println("Reedem kode dibawah ini pada saat masuk ke area vanue");
        System.out.println(generateRandomNumber());
        System.out.println("=============================================================================");

        System.out.println("terima kasih banyak sampai jumpa lagi");
        System.out.println();
    }
    public static void login(){
        Scanner in = new Scanner(System.in);
        System.out.print("masukan email\t: ");
        String email=in.nextLine();
        System.out.print("masukan password: ");
        String password=in.nextLine();
        if (databaseUser.containsKey(email)&&databaseUser.get(email).equals(password)) {
            System.out.println("Login berhasil (>~<) ");
            isLoggedIn=true;
        } else {
            System.out.println("Maaf Login Gagal <'o'>");
            isLoggedIn=false;
        }
    }
    public static void signUp(){
        Scanner in = new Scanner(System.in);
        System.out.print("masukan nomor telepon anda\t: ");
        String noHp=in.next();
        System.out.print("daftarkan email anda\t\t: ");
        String newEmail=in.next();
        System.out.print("masukan password baru\t\t: ");
        String newPassword=in.next();
        if (!databaseUser.containsKey(newEmail)) {
            databaseUser.put(newEmail, newPassword);
            System.out.println("Sign Up berhasil. Silahkan login dengan akun baru ");
        } else {
            System.out.println("username sudah terpakai silahkan ganti");
        }
    }
    static void pembayaran(double n){
        Scanner bayar = new Scanner (System.in);
         System.out.println("Pilih metode pembayaran:");
         System.out.println("1. E-Wallet");
         System.out.println("2. Kartu kredit");
         System.out.println("3. Kartu debit");
         System.out.print("Masukkan pilihan anda (1/2/3): ");
         int metodePembayaran = bayar.nextInt();
         
         if (metodePembayaran==1){
             System.out.print("Masukkan ID E-Wallet\t\t: ");
             String eWallet = bayar.next();
         } else if (metodePembayaran==2){
             System.out.print("Masukkan Nomor Kartu Kredit\t: ");
             String kartuKredit = bayar.next();
         } else {
             System.out.print("Masukan Nomor Kartu Debit\t: ");
             String kartuDebit = bayar.next();
         }
         System.out.println("======================================");
         System.out.println("\t== <TOTAL TAGIHAN> ==");
         System.out.println("======================================");
         System.out.println();
         System.out.println("Harga tiket\t: "+(n/jumlahTiket));
         System.out.println("Jumlah tiket\t: "+jumlahTiket);
         System.out.println("Total tagihan\t: "+n);
         System.out.println("======================================");
         System.out.print("Anda yakin untuk membayar?(ya/tidak): ");
        String pilihan = bayar.next();

        if ("ya".equalsIgnoreCase(pilihan)) {
            String kodeUnik = generateRandomCode();
            System.out.println("Kode unik pembayaran\t\t: " + kodeUnik);

            System.out.print("Masukkan kode pembayaran\t: ");
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
    
    
    
    
    
    public static int generateRandomNumber(){
        Random acak = new Random();
        return 100000 + acak.nextInt(900000);
    }
    public static void tentangFunfest(){
        System.out.println("""
                           Festival malam puncak mahasiswa USD yang berkolaborasi dengan Mahasiswa UNY 
                           dengan mengundang bintang tamu JKT 48 dan menghadirkan band mahasiswa dari 
                           masing-masing universitas
                           """);
    }
}