package MinesweeperGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows,cols;
        // Kullanıcıdan satır ve sütun sayılarını alarak oyunu başlatır
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Mayın tarlasına hoşgeldiniz.!");
        System.out.println("Lütfen oynamak istediğiniz boyutları seçin. !");
        System.out.print("Satır sayısı : ");
        rows = scanner.nextInt();
        System.out.print("Sütun sayısı : ");
        cols = scanner.nextInt();
        //MineSweeper sınıfından game adında bir nesne oluşturur.
        //Parantez içinde MineSweeper sınıfının isteği olan değerler için klavyeden girilen rows ve cols değerleri seçilir.
        MineSweeper game = new MineSweeper(rows,cols);

    }
}
