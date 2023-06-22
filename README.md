# interview-for-emlakjet
Invoicing System 

## Burayı Okuyun ..!

Öncelikle,
tüm geliştirmeleri tamamladıktan ve testlerini yaptıktan sonra dockerfile'ları ve docker-compose dosyasını ekledim 
ama 5432 portunu kapattığım için (sebebi ise aslında docker-compose'da 5432 portunu 2345 portuna açmaya çalıştığımdan) 
şu an hiç bir son postman testini yapamıyorum.
Geri de açamadım 5432 portunu. Sürekli connection refused alıyorum.
MacBook'ta yeniyim ve windows için çözümü buldum ama macbook'ta ne yaptımsa çözümü yemedi.
Bu konuda anlayışınız için teşekkür ederim.


# Projeyi çalıştırma
Eğer docker-compose build alabilseydi hem postgresql'i hem de spring boot uygulaması dockerize olacaktı ama şu an 
postgresql olan bir bilgisayarda projeyi çalıştırıp direkt olarak 8080 portuna bağlanabilirsiniz.

Master branch'inde oldugunuza emin olmalisiniz. Ayrıca diğer branch'lerde yaptığım geliştirmeleri görebilirsiniz.

Bununla birlikte collection'u kaydetmeden export ettiğim için create invoice endpoint'i get olarak kalmış. Bu yüzden export
etsem bile şu an test edemeyeceğim için paylaşamıyorum.
