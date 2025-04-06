import java.util.Arrays;


//Ordenar un arreglo comparando pares
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
//Prueba
    public static void main(String[] args) {
        int[] lista = {20, 23, 25, 10, 11, 11, 30};
        bubbleSort(lista);
        System.out.println(Arrays.toString(lista)); 
    }
}
