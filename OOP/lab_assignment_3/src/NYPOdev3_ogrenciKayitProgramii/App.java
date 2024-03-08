package NYPOdev3_ogrenciKayitProgramii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {
    private static final String DOSYA_ADI = "ogrenciKayit.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("1 - Yeni ogrenci kaydet");
            System.out.println("2 - Ogrencileri listele");
            System.out.println("3 - Not guncelle");
            System.out.println("4 - Programdan cikis yap");

            System.out.print("Lutfen bir islem secin: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    yeniOgrenciKaydet(scanner);
                    break;
                case 2:
                    ogrencileriListele(scanner);
                    break;
                case 3:
                    notGuncelle(scanner);
                    break;
                case 4:
                    System.out.println("Programdan cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz islem! Lutfen 1-4 arası sayı giriniz.");
            }
        } while (secim != 4);

        scanner.close();
    }

    private static void yeniOgrenciKaydet(Scanner scanner) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DOSYA_ADI, true))) {
            System.out.print("Ogrenci ad soyad: ");
            String adSoyad = scanner.nextLine();

            System.out.print("Ogrenci numarasi: ");
            String numara = scanner.nextLine();

            System.out.print("Ogrenci dogum yili: ");
            int dogumYili = scanner.nextInt();

            System.out.print("Ogrenci not ortalamasi: ");
            int notOrtalamasi = scanner.nextInt();

            String yeniOgrenci = adSoyad + ", " + numara + ", " + dogumYili + ", " + notOrtalamasi;
            writer.println(yeniOgrenci);

            System.out.println("Yeni ogrenci kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatasi: " + e.getMessage());
        }
    }

    private static void ogrencileriListele(Scanner scanner) {
        System.out.print("Listelemek istediginiz harfi girin: ");
        char harf = scanner.next().charAt(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(DOSYA_ADI))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String adSoyad = parts[0];
                if (adSoyad.toUpperCase().charAt(0) == Character.toUpperCase(harf)) {
                    System.out.println("Bilgiler: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }
    }

    private static void notGuncelle(Scanner scanner) {
        try {
            File file = new File(DOSYA_ADI);

            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            System.out.print("Notunu guncellemek istediginiz ogrencinin numarasini girin: ");
            String numara = scanner.next();

            boolean ogrenciBulundu = false;
            long position = 0;
            String line;
            while ((line = randomAccessFile.readLine()) != null) {
                String[] parts = line.split(", ");
                String ogrenciNumara = parts[1];

                if (ogrenciNumara.equals(numara)) {
                    System.out.print("Yeni not ortalamasini girin: ");
                    int yeniNot = scanner.nextInt();

                    parts[3] = String.valueOf(yeniNot);
                    ogrenciBulundu = true;

                    randomAccessFile.seek(position);
                    randomAccessFile.writeBytes(String.join(", ", parts));
                    break;
                }

                position = randomAccessFile.getFilePointer();
            }

            randomAccessFile.close();

            if (!ogrenciBulundu) {
                System.out.println("Belirtilen numaraya sahip ogrenci bulunamadi.");
            } else {
                System.out.println("Not guncellendi.");
            }
        } catch (IOException e) {
            System.out.println("Dosya islemleri hatasi: " + e.getMessage());
        }
    }
}

