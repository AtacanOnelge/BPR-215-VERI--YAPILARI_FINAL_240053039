import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/*
 Otopark Yönetim Sistemi - GUI Versiyonu
 Öğrenci Adı Soyadı: Atacan Önelge
*/

public class OtoparkArayuz extends JFrame {
    private int kapasite = 5;
    private int gunlukKazanc = 0;
    private int[] ucretTablosu = {20, 30, 40, 50, 60};

    private ArrayList<String> araclar = new ArrayList<>();
    private HashMap<String, Long> girisZamani = new HashMap<>();

    // Arayüz Bileşenleri
    private JLabel lblDurum, lblKazanc, lblKapasite;
    private DefaultListModel<String> listeModeli;
    private JList<String> aracListesi;

    public OtoparkArayuz() {
        setTitle("Otopark Yönetim Sistemi");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- ÜST PANEL: Bilgiler ---
        JPanel ustPanel = new JPanel(new GridLayout(1, 3));
        lblKapasite = new JLabel("Kapasite: " + kapasite);
        lblDurum = new JLabel("İçerideki Araç: 0");
        lblKazanc = new JLabel("Günlük Kazanç: 0 TL");
        ustPanel.add(lblKapasite);
        ustPanel.add(lblDurum);
        ustPanel.add(lblKazanc);
        add(ustPanel, BorderLayout.NORTH);

        // --- ORTA PANEL: Araç Listesi ---
        listeModeli = new DefaultListModel<>();
        aracListesi = new JList<>(listeModeli);
        add(new JScrollPane(aracListesi), BorderLayout.CENTER);

        // --- ALT PANEL: Butonlar ---
        JPanel altPanel = new JPanel();
        JButton btnGiris = new JButton("Araç Girişi");
        JButton btnCikis = new JButton("Araç Çıkışı");
        JButton btnYenile = new JButton("Durum Güncelle");

        altPanel.add(btnGiris);
        altPanel.add(btnCikis);
        altPanel.add(btnYenile);
        add(altPanel, BorderLayout.SOUTH);

        // --- BUTON İŞLEVLERİ ---

        // ARAÇ GİRİŞİ
        btnGiris.addActionListener(e -> {
            String plaka = JOptionPane.showInputDialog(this, "Araç Plakasını Giriniz:");
            if (plaka != null && !plaka.trim().isEmpty()) {
                plaka = plaka.toUpperCase();
                if (araclar.contains(plaka)) {
                    JOptionPane.showMessageDialog(this, "Bu araç zaten içeride!");
                } else if (araclar.size() >= kapasite) {
                    JOptionPane.showMessageDialog(this, "Otopark dolu!");
                } else {
                    araclar.add(plaka);
                    girisZamani.put(plaka, System.currentTimeMillis());
                    listeModeli.addElement(plaka);
                    arayuzuGuncelle();
                }
            }
        });

        // ARAÇ ÇIKIŞI
        btnCikis.addActionListener(e -> {
            String seciliPlaka = aracListesi.getSelectedValue();
            if (seciliPlaka == null) {
                seciliPlaka = JOptionPane.showInputDialog(this, "Çıkacak araç plakasını giriniz:");
            }

            if (seciliPlaka != null && araclar.contains(seciliPlaka.toUpperCase())) {
                seciliPlaka = seciliPlaka.toUpperCase();

                // Ücret Hesaplama
                long sureMillis = System.currentTimeMillis() - girisZamani.get(seciliPlaka);
                // Test için: milisaniyeyi saniye gibi düşünelim (normalde 1000*60*60 olmalı)
                long sureSaat = (sureMillis / 5000) + 1; // Her 5 saniye 1 saat gibi davranır (test kolaylığı için)

                int ucret = (sureSaat >= ucretTablosu.length) ?
                        ucretTablosu[ucretTablosu.length - 1] : ucretTablosu[(int)sureSaat - 1];

                gunlukKazanc += ucret;
                araclar.remove(seciliPlaka);
                girisZamani.remove(seciliPlaka);
                listeModeli.removeElement(seciliPlaka);

                JOptionPane.showMessageDialog(this,
                        "Plaka: " + seciliPlaka +
                                "\nSüre: " + sureSaat + " saat" +
                                "\nÜcret: " + ucret + " TL");

                arayuzuGuncelle();
            } else if (seciliPlaka != null) {
                JOptionPane.showMessageDialog(this, "Araç bulunamadı!");
            }
        });

        btnYenile.addActionListener(e -> arayuzuGuncelle());
    }

    private void arayuzuGuncelle() {
        lblDurum.setText("İçerideki Araç: " + araclar.size());
        lblKazanc.setText("Günlük Kazanç: " + gunlukKazanc + " TL");
    }

    public static void main(String[] args) {
        // Arayüzü başlat
        SwingUtilities.invokeLater(() -> {
            new OtoparkArayuz().setVisible(true);
        });
    }
}