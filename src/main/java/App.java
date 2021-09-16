import java.util.*;

public class App {
    private final static int QTD_FILMES = 176;

    public static void main(String[] args) {
        Set<Integer> filmes = new LinkedHashSet<>();
        Random random = new Random();
        for(int i = QTD_FILMES ; i > 0;) {
            int numero = random.nextInt(QTD_FILMES) + 1;
            if(filmes.add(numero)) {
               i--;
            }
        }
        filmes.forEach(System.out::println);
    }
}
