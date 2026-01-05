🚗 Otopark Yönetim Sistemi

Java programlama dili kullanılarak geliştirilen bu proje, Programcılığa Giriş dersi kapsamında hazırlanmış konsol tabanlı bir Otopark Yönetim Sistemi uygulamasıdır. Proje, gerçek hayatta karşılaşılan otopark yönetimi problemlerine temel seviyede bir yazılımsal çözüm sunmayı amaçlamaktadır.

📌 Proje Amacı

Bu projenin temel amacı;

Programlamaya giriş seviyesinde öğrenilen Java konularını uygulamak,

Gerçek hayattan bir problemi analiz ederek yazılım ile çözmek,

Algoritma kurma ve problem çözme becerilerini geliştirmektir.

Geliştirilen sistem sayesinde araç giriş–çıkış işlemleri kontrol altına alınmakta, otopark kapasitesi aşılmamakta ve araçların otoparkta kaldıkları süreye göre ücretlendirme yapılmaktadır.

⚙️ Özellikler

🚘 Araç giriş işlemi

🚪 Araç çıkış işlemi

🔒 Aynı plakanın tekrar giriş yapmasının engellenmesi

🅿️ Otopark kapasite kontrolü

⏱ Saatlik ücret tarifesi tablosu (dizi kullanımı)

💰 Araç bazlı ücret hesaplama

📊 Günlük toplam kazanç takibi

📋 Otoparktaki araçların listelenmesi

🧠 Kullanılan Teknolojiler

Programlama Dili: Java

IDE: IntelliJ IDEA

Uygulama Türü: Konsol (Console Application)

🧩 Kullanılan Veri Yapıları

ArrayList → Otoparktaki araç plakalarının tutulması

HashMap → Araç plakaları ile giriş zamanlarının eşleştirilmesi

int[] (Dizi) → Saatlik ücret tarifesi tablosu

⏱ Saatlik Ücret Tarifesi
Süre	Ücret
1 Saat	20 TL
2 Saat	30 TL
3 Saat	40 TL
4 Saat	50 TL
5 Saat ve üzeri	60 TL (Sabit)

Ücretlendirme işlemi, saatlik ücret tarifesi dizisi kullanılarak otomatik olarak hesaplanmaktadır.

▶️ Program Akışı

Kullanıcıya menü gösterilir

Araç girişi yapılırsa:

Kapasite kontrol edilir

Plaka tekrar kontrolü yapılır

Araç çıkışı yapılırsa:

Kalınan süre hesaplanır

Ücret tarifesine göre ödeme hesaplanır

Günlük kazanca eklenir

Otoparktaki araçlar ve doluluk bilgisi görüntülenebilir

📸 Ekran Görüntüleri

📌 Bu alana IntelliJ IDEA proje yapısı, kod ekranı ve program çıktısına ait ekran görüntüleri eklenmelidir.

📝 Proje Kapsamı

Bu proje eğitim amaçlıdır ve küçük ölçekli otoparklar için temel bir otomasyon altyapısı sunmaktadır. Geliştirilen sistem, daha ileri seviyelerde grafiksel arayüz, veritabanı bağlantısı ve plaka tanıma sistemleri ile genişletilebilir.
