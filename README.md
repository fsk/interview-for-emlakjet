# interview-for-emlakjet
Invoicing System. <br>
Projenin çalışma mantığı şu şekildedir.<br>
Bir AccountingSpecialist sisteme gerekli bilgilerle kaydedilir. Sonrasında her bir Accounting Specialilst için invoice gönderilir.
Eğer gönderilen invoice değeri ile database'deki invoice tablosundaki <i>amount</i> alanının ilgili Accounting Specialist ' in toplamı
200'den büyükse hata döner. Değilse veritabanına ekler.

<hr>

### Kurulum ve Projeyi Çalıştırma

<i> git clone https://github.com/fsk/interview-for-emlakjet.git </i><br>
komutu ile projeyi local'e çektikten sonra herhangi bir ide'de ya da CLI üzerinden<br>
<i>mvn package -DskipTests</i>
<br>komutu çalıştırılmalıdır.<br>
<u>Not:</u> Bu komutun çalıştırılması gereken yer kök dizinin bulunduğu yer olmalıdır.

Bu adımdan sonra <br>
<i>docker compose up --build</i><br>
komutu ile proje docker'da ayağa kaldırılabilir.

<u>Not:</u> Projenin çalışması için 5433 ve 8080 portlarının kapalı olması gerekmektedir.

<hr>

### Kullanılan Teknolojiler
Java 17 - Spring Boot 3.1.0 - PostgreSQL 15 - Docker

<hr>

### Eğer istek atılmak istenirse;
Proje ayaktayken insomnia ya da postman gibi toollardan istek atılmak istenirse,
* Yeni bir Accounting Specialist oluşturmak için;
<br>
  <u>endpoint:</u> http://localhost:8080/specialist/
<br>
  <u>örnek request:</u>
  
```
{
  "firstName": "josh",
  "lastName": "long",
  "emails": [
    {"emailAddress": "josh@long.com"},
    {"emailAddress": "joshlong@gmail.com"}
  ]
}
```

```
{
  "firstName": "uncle",
  "lastName": "bob",
  "emails": [
    {"emailAddress": "unclebob@gmail.com"},
  ]
}
```

* Invoice Eklemek için;
  <br>
  <u>endpoint:</u> http://localhost:8080/invoice/
  <br>
  <u>örnek request:</u>

```
{
    "productName": "monitor",
    "billNo": "monitor1234",
    "amount": 150,
    "specialist": {
        "firstName": "uncle",
        "lastName": "bob",
        "emails": [
            {"emailAddress": "unclebob@gmail.com"},
        ]
    }
}
```

<u>Not:</u> Email alanı farklı bir tablo olarak tutulmuştur.

<u>Not:</u> Postman Collection'u src - resources klasörü altında bulunabilir.

### Ekiskler
* Email için RegEX ile validasyon kontrolleri yapılabilirdi.
* DTO katmanı oluşturulup burada MapStruct kullanılabilirdi.
* Amount için Integer değer yerine BigDecimal kullanılabilirdi.

