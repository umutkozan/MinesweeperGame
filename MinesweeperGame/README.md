**Mayın Tarlası Oyunu**

Bu proje, Java programlama dili kullanılarak geliştirilmiş bir Mayın Tarlası oyununu içerir. Kullanıcı, belirlediği boyutlarda bir oyun alanında mayınları tespit etmeye çalışırken, mayınsız bölgeleri keşfetmeye çalışır.

**Kurulum**

Projeyi bilgisayarınıza klonlayın veya ZIP olarak indirin.
Java JDK'sı yüklü olmalıdır. Java'nın resmi web sitesinden indirebilirsiniz.

Bir Java IDE'si (IntelliJ IDEA, Eclipse vb.) veya metin düzenleyici kullanarak projeyi açın.
Main.java dosyasını çalıştırarak oyunu başlatın.

**Nasıl Oynanır**

Oyun başladığında, kullanıcıdan satır ve sütun sayıları istenir. 
(Örneğin: 4x6)

Kullanıcı, satır ve sütun sayılarını girdikten sonra oyun başlar.

Kullanıcı her hamlede bir hücre seçer. Seçilen hücrede mayın yoksa, etrafındaki mayın sayısı görüntülenir. Mayına denk gelirse, oyun kaybedilir.

Tüm mayınsız hücreler açıldığında veya bir mayına basıldığında oyun sona erer.

**Oyun Kontrolleri**

Satır ve sütun sayılarını belirtirken, oyun alanı boyutlarına uygun olmalıdır:

Kullanıcının her hamlesinde girdiği satır ve sütun koordinatları, oyun alanının sınırları içinde olmalıdır. Örneğin, eğer kullanıcı 5x5 boyutunda bir oyun alanı seçtiyse ve 6,2 gibi geçersiz bir koordinat girerse, uyarı mesajı gösterilir.
Her hamle sonrasında oyun alanı güncellenir:

Kullanıcı her hamle yaptığında, oyun alanı güncellenir ve kullanıcıya güncel durumu gösterilir.

Bu, kullanıcının hangi hücreleri seçtiğini ve hangi hücrelerin mayın içerdiğini veya kaç mayın etrafında olduğunu görmesine olanak tanır.

Tüm mayınsız hücreler açıldığında veya bir mayına basıldığında, kullanıcıya uygun mesajlar gösterilir:

Kullanıcı tüm mayınsız hücreleri açtığında veya bir mayına bastığında, oyunun sona erdiğini ve sonuca bağlı olarak uygun mesajın gösterildiğini belirten bir bildirim görüntülenir. 

Örneğin, "Tebrikler! Tüm güvenli hücreleri açtınız. Oyunu kazandınız!" veya "Mayına denk geldiniz! Oyun bitti!" gibi mesajlar gösterilir.