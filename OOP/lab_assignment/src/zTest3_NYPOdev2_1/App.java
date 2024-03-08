/*
 * Ahmet Oğuz
 * 1306210064
 * NYP 
 *
 */

package zTest3_NYPOdev2_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape[] shapes = new Shape[10];

        System.out.println("Alan ve kütle hesaplama programına hoş geldiniz. Bu programda sizden 10 kez hangi şekli istediğiniz sorulacak ve her biri için ayrı ayrı koordinatları girmeniz istenecek.");
        System.out.println("Uyarı: Lütfen büyük ve küçük harflere dikkat edin (dikdörtgen değil Dikdortgen olmalıdır.)");

        for (int i = 0; i < 10; i++) {
            System.out.print("Hangi şekli tanımlamak istersiniz? (Yamuk, Paralelkenar, Dikdortgen, Kare): ");
            String secim = scanner.nextLine();

            System.out.print("Noktanın x1 koordinatını girin: ");
            int x1 = scanner.nextInt();
            System.out.print("Noktanın x2 koordinatını girin: ");
            int x2 = scanner.nextInt();
            System.out.print("Noktanın y1 koordinatını girin: ");
            int y1 = scanner.nextInt();
            System.out.print("Noktanın y2 koordinatını girin: ");
            int y2 = scanner.nextInt();

            scanner.nextLine(); 

            Nokta nokta = new Nokta(x1, x2, y1, y2);

            Shape shape;

            switch (secim) {
                case "Yamuk":
                    shape = new Yamuk(nokta);
                    break;
                case "Paralelkenar":
                    shape = new Paralelkenar(nokta);
                    break;
                case "Dikdortgen":
                    shape = new Dikdortgen(nokta);
                    break;
                case "Kare":
                    shape = new Kare(nokta);
                    break;
                default:
                    shape = null;
                    System.out.println("Geçersiz bir şekil seçtiniz.");
            }

            if (shape != null) {
                shapes[i] = shape;
            }
        }

        System.out.println("Alanlar ve kütleler:");

        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println("Şekil Alanı: " + shape.hesaplaAlan());
                System.out.println("Şekil Kütle: " + shape.hesaplaKütle());
            }
        }
    }
}