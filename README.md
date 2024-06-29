# Matrix Multiplication
Matrix multiplication in parallel programming

Bu proje, iki vektörün iç çarpımını Java'da paralel programlama kullanarak hesaplar. Program, kullanıcıdan vektör boyutlarını ve elemanlarını girdi olarak alır ve Fork/Join framework'ü kullanarak iç çarpımı hesaplar.


This project calculates the dot product of two vectors using parallel programming in Java. The program takes vector sizes and elements as input from the user and computes the dot product using the Fork/Join framework.

## Kullanım / How to Use

1. **Kodu Derleme / Compile the Code**:
   javac ParallelDotProduct.java

2. **Programı Çalıştırma / Run the Program**:
   java ParallelDotProduct


3. **Vektörleri Girme / Input the Vectors**:
- Vektörlerin boyutunu girin.
- Birinci vektörün elemanlarını girin.
- İkinci vektörün elemanlarını girin.

4. **Sonuç / Result**:
- Program, iki vektörün iç çarpımını çıktı olarak verir.

## Açıklama / Explanation

### DotProductTask Sınıfı / DotProductTask Class

`DotProductTask` sınıfı `RecursiveTask<Integer>` sınıfından türetilmiştir ve `compute` metodunu geçersiz kılar. Görev yeterince küçükse (bir eşik değeri ile belirlenir), iç çarpımı doğrudan hesaplar. Aksi takdirde, görevi daha küçük alt görevlere böler ve bunları paralel olarak işler.

### ParallelDotProduct Sınıfı / ParallelDotProduct Class

`ParallelDotProduct` sınıfı `main` metodunu içerir. Bu metod:
1. Kullanıcıdan vektör boyutlarını ve elemanlarını ister.
2. Bir `ForkJoinPool` ve `DotProductTask` oluşturur.
3. Görevi çalıştırır ve sonucu yazdırır.
