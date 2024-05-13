// 2. Projede açıklayıcı yorum satırları ya da bir projeye bir projeyi özetleyen bir readme dosyası eklenmiş mi? (5 puan
// 3. Kodlama düzeni ve kodun okunabilirliği yeterli mi? (10 puan)
// 4. Kodda doğru bir şekilde girinti kullanılmış mı? (5 puan)
package MinesweeperGame;

import java.util.Random;
import java.util.Scanner;

// 5. Proje MineSweeper sınıfı içerisinde tasarlanmış mı? (5puan)
public class MineSweeper {
    int size, cols, rows;
    String[][] mineMap; // Mayın haritasını tutar
    String[][] playMap; // Oyun haritasını tutar
    Random random = new Random(); // Rastgele sayı üretmek için kullanılır
    boolean game = true; // Oyunun devam edip etmediğini kontrol eder
    int maxMoves; // Maksimum hamle sayısını belirler
    int moves = 0; // Yapılan hamle sayısını tutar
    boolean[][] visited; // Ziyaret edilen noktaları tutar

    // MineSweeper sınıfının constructor'ı, oyun alanını başlatır.
    public MineSweeper(int cols, int rows) {
        // Değişkenlerin başlatılması
        if (cols < 2 || rows < 2) {
            // Oyun alanı minimum 2x2 olmalıdır. Kullanıcıya uyarı mesajı gönderir.
            System.out.println("Oyun alanı minimum 2x2 olmalıdır. Lütfen tekrar boyutları girin.");
            return;
        }
        this.cols = cols;
        this.rows = rows;
        this.size = cols * rows;
        this.mineMap = new String[rows][cols]; // Mayın haritası dizisini oluşturur
        this.playMap = new String[rows][cols]; // Oyun haritası dizisini oluşturur
        this.visited = new boolean[rows][cols]; // Ziyaret edilen noktalar dizisini oluşturur
        this.maxMoves = size - (size / 4); // Maksimum hamle sayısını belirler
        // Mayın haritasını ve oyunu başlatır
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mineMap[i][j] = "-";
            }
        }
        gameIsPreparing(); // Mayınları rastgele yerleştirir
        playGame(); // Oyunu başlatır
    }

    // Mayınları rastgele yerleştirir.
    public void gameIsPreparing() {
        int totalMine = 0;
        int maxMine = size / 4;
        // Diziye uygun sayıda rastgele mayın yerleştirilmiş mi? (10 puan)
        while (totalMine != maxMine) {
            int randomMineRow = random.nextInt(this.rows);
            int randomMineCol = random.nextInt(this.cols);
            if (!mineMap[randomMineRow][randomMineCol].equals("*")) {
                mineMap[randomMineRow][randomMineCol] = "*";
                totalMine++;
            }
        }
        // Mayınlı haritanın yazdırılması ve oyun haritasının başlatılması
        System.out.println("Mayınlı Harita:");
        printGame(mineMap);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                playMap[i][j] = "-";
            }
        }
    }

    // Oyunu oynatır.
    public void playGame() {
        int row, col;
        while (game) {
            System.out.println("\nOyun Haritası : ");
            printGame(playMap);
            // Kullanıcıdan hedef satır ve sütun bilgisini alır
            System.out.println("Satır giriniz : ");
            row = new Scanner(System.in).nextInt();
            System.out.println("Sütun giriniz : ");
            col = new Scanner(System.in).nextInt();
            // Kullanıcının seçtiği noktanın dizinin sınırları içerisinde olup olmadığını kontrol eder
            if (isInsideBounds(row, col)) {
                if (mineMap[row][col].equals("*")) {
                    // Kullanıcı mayına bastığında oyunu kaybedecek şekilde kontrol yapılır
                    System.out.println("Mayına denk geldiniz! Oyun bitti!");
                    game = false;
                } else if (visited[row][col]) {
                    System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin.");
                } else {
                    // Kullanıcı her hamle yaptığında oyun alanı güncellenir
                    visited[row][col] = true;
                    MineControl(row, col);
                    moves++;
                    // Tüm noktalar mayınsız bir şekilde seçilirse oyunu kazanmanın kontrolü yapılır
                    if (moves == maxMoves) {
                        System.out.println("Tebrikler! Tüm güvenli hücreleri açtınız. Oyunu kazandınız!");
                        game = false;
                    }
                }
            } else {
                System.out.println("Belirtilen koordinatlar oyun alanının sınırları dışında! Lütfen geçerli bir koordinat girin.");
            }
        }
    }

    // Verilen satır ve sütunun oyun alanı içinde olup olmadığını kontrol eder.
    public boolean isInsideBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Verilen diziyi ekrana yazdırır.
    public void printGame(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[0].length; k++) {
                System.out.print(array[i][k] + " ");
            }
            System.out.println();
        }
    }

    // Girilen noktada mayın yoksa etrafındaki mayın sayısını kontrol eder.
    public void MineControl(int row, int col) {
        if (mineMap[row][col].equals("-")) {
            int mineCount = 0;
            for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
                for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
                    if (mineMap[i][j].equals("*")) {
                        mineCount++;
                    }
                }
            }
            // Girilen noktada mayın yoksa etrafındaki mayın sayısı veya 0 değeri yerine yazılmış mı? (10puan)
            playMap[row][col] = mineCount > 0 ? Integer.toString(mineCount) : "0";
        }
    }
}