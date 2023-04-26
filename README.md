
# IntermediateJavaBackend
Intermediate Java knowledge for beginners.

1) SQL-PostgreSQL Principles

2) OOP-Principles

 -Encapsulation
 -Inheritance
 -Method Overriding
 -Polymorphism
 -Abstraction
 -Interface
 
 3) Adventure Game (HomeWork)


 Text based game Full OOP 
 
 4) ToMyList (HomeWork)
 
 -Generic Class
 -Generic Methods
 -Generic Interface
 -Generic Bounded Types
 
 5)
 
 -Exception Handling
 -Try-Catch
 -Throw
 -Exception
 
 6) Collections

-Set Interface And HashSet
-LinkedHashSet
-TreeSet
-ArrayList
-Queue LinkedList
-Map And HashMap
-BookSorter
-Fixture Generater

7)Logical Store

<details>
  <summary>Rules</summary>

  ```
 Sanal Mağazanın adı "PatikaStore" olacaktır.
Mağazada Markalar oluşturulacak ve ürünler bu markalar ile eşleşecektir.
id : Markanın sistemde kayıtlı benzersiz numar
name : Markanın adı
Markalar listelenirken her zaman alfabe sırasıyla listelenmelidir.
Markalar statik olarak kod blokları içerisinden aşağıdaki sıra ile eklenmelidir.
Markalar : Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster
Mağazada şuan için 2 tür ürün grubu satılması planlanmaktadır : Cep Telefonları, Notebook
Daha sonrasında farklı ürün gruplarını eklenebilir olmalıdır.
Cep Telefonu ürünlerinin özellikleri :
Ürünün sistemde kayıtlı benzersiz numarası
Birim fiyatı
İndirim oranı
Stok miktarı
Ürün adıMarka bilgisi (Sistemde ekli olan markalar kullanılacaktır)
Telefonun hafıza bilgisi (128 GB, 64 GB)
Ekran Boyutu (6.1 Inc)
Pil Gücü (4000)
RAM (6 MB)
Renk (Siyah,Kırmızı,Mavi)
Notebook ürünlerinin özellikleri :
Ürünün sistemde kayıtlı benzersiz numarası
Birim fiyatı
İndirim oranı
Stok miktarı
Ürün adı
Marka bilgisi (Sistemde ekli olan markalar kullanılacaktır)
Ram (8 GB)
Depolama (512 SSD)
Ekran Boyutu (14 inç)
Kullanıcı sistem üzerinden ilgili kategorideki (Notebook, Cep Telefonları vb.) ürünleri listeyebilimeli
Ürünler listelenirken tablo şeklinde konsol ekranında gösterilmeli (System.out.format() kullanılabilir).
Kullanıcı ürün ekleyebilmeli ve ürünün grubunu (Cep Telefonu, Notebook vb.) seçebilmeli.
Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.
Kullanıcı ürünlerin benzersiz numaralarına ve markalarına göre filtreleyip listeleyebilmeli.
  
  ```
  </details>
 
 
 8) Insurance-Management-System

<details>
  <summary>Rules</summary>

  ```
 Sigorta Yönetim Sistemi
Sigorta firması için bir yazılım yaptığınızı düşünün. Sigorta firmasının "Bireysel" (Individual) ve "Kurumsal" (Enterprise) olmak üzere iki tip müşteri profili bulunmaktadır. Müşteri profili için "Account" isminde soyut sınıf (abstract class) tasarlayınız. Account sınıfı müşterinin sisteme giriş sonrasında tüm bilgilerinin tutulduğu hesap bilgisidir. "Account" sınıfı içinde "User" tipinde bir nesne referansı bulunur. (Aggeration ilişkisi olarak)



"User" sınıfı müşterinin kişi bilgilerini ifade eder. "User" sınıfında müşterinin



isim (String),


soyisim (String),


email (String),


şifre (String),


meslek (String),


yaş (int),


adres listesi (ArrayList<Address>)


sisteme son giriş tarihi (Date)


bilgileri bulunur. Ayrıca, "User" sınıfında ArrayList tipinde adreslerinin tutulduğu bir liste vardır. Adres bilgisi iki tiptir. Ev adresi ("HomeAddress") ve İş adresi ("BusinessAddress") olmak üzere iki tane sınıf tasarlayınız. Bu adres sınıfları "Address" isimli bir interface'den kalıtım alacaktır. Fakat, bu interface'de hangi fonksiyonların olması gerektiğine siz karar vereceksiniz.



Müşteri adreslerinin ekleyip çıkarılma sorumluluğunu üstlenmiş olan "AddressManager" isminde bir sınıf tasarlayınız. Bu sınıfın içinde "User" nesnesinin adres listesine eleman ekleme-çıkarma yapabilen iki tane static fonksiyon tanımlayınız. Bu fonksiyon isimlerini siz belirleyiniz.



"Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon tanımlayınız.



"Account" sınıfında müşterilerin yaptırdıkları sigortaları liste halinde saklayınız. Sigortayı temsil eden "Insurance" isminde bir soyut sınıf tasarlayınız. Bu soyut sınıf içinde



sigortanın ismi (String),


sigortanın ücreti (double)


sigortanın başlangıç-bitiş tarihi (Date)


gibi değişkenlere sahip olacaktır. Ayrıca "calculate" isminde soyut bir fonksiyon tanımlanacaktır. Bu soyut fonksiyon aşağıda kalıtım alınan sınıflarda doldurulacaktır.



Bu soyut sınıftan türeyen



"HealthInsurance" (özel sağlık sigortasu),


"ResidenceInsurance" (konut sigortası),


"TravelInsurance" (seyahat sigortası),


"CarInsurance" (otomobil sigortası)


4 tane alt sınıf tasarlayınız. Her alt sınıf "calculate" isimli soyut fonksiyonu override ederek, sigorta ücretini kendine göre hesaplayacaktır.



Yukarıdaki tanımları dikkate aldığımızda soyut sınıf olan "Account" sınıfında aşağıdakiler yer almalıdır.



kullanıcının login olma durumu (AuthenticationStatus)


kullanıcı nesnesi (User)


kullanıcının yaptırmış olduğu sigortaların listesi (ArrayList)


AuthenticationStatus tipinde bir enum tanımlayınız. Enum içinde SUCCESS ve FAIL isminde iki tane sabit tanımlayın. SUCCESS login işlemi başarılı ise kullanılacaktır. FAIL ise login olmamışsa kullanılacaktır.


kullanıcının hesabına login olabilmesi için bir fonksiyon tanımlanacaktır. Bu fonksiyon email ve şifre bilgisi alacak ve gelen email şifre bilgisini User sınıfındaki email ve şifre ile kıyaslayacaktır. Eğer girilen bilgiler doğruysa giriş işlemi başarılı olacaktır. Ve kullanıcının login olma durumu SUCCESS'e çekilecektir. Giriş işlemi başarısız ise "InvalidAuthenticationException" tipinde bir hata fırlatacaktır. Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak sizin yazmanız gerekecektir.


kullanıcının adreslerine ekleme yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının adreslerinden çıkartma yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının login olma durumunu veren değer döndüren fonksiyon tanımlanacaktır.


kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir fonksiyon tanımlanacaktır. Bu soyut sınıf "Individual" ve "Enterprise" isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar marjı farklı olacaktır.


"Individual" ve "Enterprise" sınıfları "Account" sınıfından kalıtım alacaktır.



AccountManager isminde bir sınıf tasarlayınız. Bu sınıf içinde TreeSet tipinde bir veri listesi tutsun. Oluşturduğunuz bireysel ve kurumsal hesapları bu listede saklayınız. bu sınıf içinde login isminde bir fonksiyon tanımlayınız. Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp Account listesi üzerinde dolaşıp uygun bir giriş işlemi bulursa Account nesnesini çağrıldığı yere dönecektir. Bu fonksiyon Account nesnesi üzerindeki "login" olma fonksiyonunu çağıracaktır. Unutmayın bu fonksiyon "InvalidAuthenticationException" tipinde hata fırlatabiliyordu. Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.



"Account" sınıfından nesneleri TreeSet içinde tutacağımız için "Comparable" interface'den kalıtım almış olmasına dikkat edin. Ayrıca, "Account" sınıfının "hashCode" ve "equals" fonksiyonlarını doldurmayı unutmayın.



Klavyeden email ve şifre bilgisini alan bir sınıf tasarlayınız. Klavyeden alınan email ve şifre bilgisi ile AccountManager sınıfındaki "login" fonksiyonunu çağırın. Eğer geçerli bir kullanıcı ile giriş yapmışsanız bu fonksiyon size Account tipinde bir nesne dönecektir.
 
  ```
  </details>
  
  9) INput-Output Systems
  
  10)Threads
  
  11)Thread Race 
  
  <details>
  <summary>Rules</summary>

  ```
  1'den 10000 (10 bin)'e kadar olan sayılardan oluşan bir ArrayList oluşturunuz. Ardından, bu ArrayList'teki 10 bin elemanı 2500 eleman olacak şekilde 4 eşit parçaya ayırınız. Bu 4 ayrı 2500 elemanlık ArrayList'ler içinde tek ve çift sayıları bulan 4 ayrı Thread tasarlayınız.



4 Thread bulduğu çift sayıları ortak bir ArrayList'e ekleyecektir.


4 Thread bulduğu tek sayıları ortak bir ArrayList'e ekleyecektir.


Tek ve çift sayıları tutan ArrayList'ler ilk oluşturulduklarında boş olacaklardır. Ve iki tane ArrayList olacaklardır.


4 Thread kendine ait 2500 elemanlık ArrayList'i işlemeye başlayınca tek ve çift sayı ArrayList'lerini dolduracaktır.

  
```
  </details>
  
  
  
  

