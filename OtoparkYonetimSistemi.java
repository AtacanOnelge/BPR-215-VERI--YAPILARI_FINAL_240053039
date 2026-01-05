import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 Otopark Yönetim Sistemi
 Öğrenci Adı Soyadı: Atacan Önelge
 Öğrenci Numarası: 240053039
*/

public class OtoparkYonetimSistemi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kapasite = 5;
        int gunlukKazanc = 0;

        // Saatlik ücret tarifesi tablosu
        int[] ucretTablosu = {20, 30, 40, 50, 60};

        ArrayList<String> araclar = new ArrayList<>();
        HashMap<String, Long> girisZamani = new HashMap<>();

        int secim;

        do {
            System.out.println("\n--- OTOPARK YÖNETİM SİSTEMİ ---");
            System.out.println("Kapasite: " + kapasite +
                    " | Doluluk: " + araclar.size() +
                    " | Günlük Kazanç: " + gunlukKazanc + " TL");

            System.out.println("1- Araç Girişi");
            System.out.println("2- Araç Çıkışı");
            System.out.println("3- Otoparktaki Araçları Listele");
            System.out.println("4- Doluluk Bilgisi");
            System.out.println("5- Günlük Toplam Kazanç");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {

                case 1:
                    System.out.print("Araç plakasını giriniz: ");
                    String plakaGiris = scanner.nextLine();

                    if (araclar.contains(plakaGiris)) {
                        System.out.println("Bu plaka zaten otoparkta!");
                    } else if (araclar.size() >= kapasite) {
                        System.out.println("Otopark dolu! Araç alınamaz.");
                    } else {
                        araclar.add(plakaGiris);
                        girisZamani.put(plakaGiris, System.currentTimeMillis());
                        System.out.println("Araç otoparka alındı.");
                    }
                    break;

                case 2:
                    System.out.print("Çıkacak aracın plakasını giriniz: ");
                    String plakaCikis = scanner.nextLine();

                    if (araclar.contains(plakaCikis)) {

                        long cikisZamani = System.currentTimeMillis();
                        long giris = girisZamani.get(plakaCikis);

                        long sureMillis = cikisZamani - giris;
                        long sureSaat = (sureMillis / (1000 * 60 * 60)) + 1;

                        int ucret;
                        if (sureSaat >= ucretTablosu.length) {
                            ucret = ucretTablosu[ucretTablosu.length - 1];
                        } else {
                            ucret = ucretTablosu[(int) sureSaat - 1];
                        }

                        gunlukKazanc += ucret;

                        araclar.remove(plakaCikis);
                        girisZamani.remove(plakaCikis);

                        System.out.println("Araç çıkışı yapıldı.");
                        System.out.println("Kalınan süre: " + sureSaat + " saat");
                        System.out.println("Ödenecek ücret: " + ucret + " TL");

                    } else {
                        System.out.println("Araç bulunamadı!");
                    }
                    break;

                case 3:
                    System.out.println("\nOtoparktaki Araçlar:");
                    if (araclar.isEmpty()) {
                        System.out.println("Otopark boş.");
                    } else {
                        for (String plaka : araclar) {
                            System.out.println("- " + plaka);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Toplam kapasite: " + kapasite);
                    System.out.println("Mevcut araç sayısı: " + araclar.size());
                    System.out.println("Boş yer sayısı: " +
                            (kapasite - araclar.size()));
                    break;

                case 5:
                    System.out.println("Günlük toplam kazanç: " +
                            gunlukKazanc + " TL");
                    break;

                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    break;

                default:
                    System.out.println("Hatalı seçim yaptınız!");
            }

        } while (secim != 0);

        scanner.close();
    }
}
