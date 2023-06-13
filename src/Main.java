import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = prepareArray(n);
        printArray(arr);
        sortArray(arr);
        printArray(arr);
    }

    /**
     * @apiNote сортировка кучей
     * @param arr массив
     */
    private static void sortArray ( int[] arr){
        //int n = arr.length/2 - 1;
        int n = arr.length - 1;
        for (int i = n; i >= 0; i--) {
            heapArray(arr, n, i);
        }
        for (int i = n; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapArray(arr, i, 0);
        }
    }

    /**
     * @apiNote функция формирования пирамидок, родитель и две дочерние
     * @param arr массив
     * @param heapSize размер массива
     * @param index индекс внешнего цикла укажет на родителя
     */
    private static void heapArray ( int[] arr, int heapSize, int index){
        int largest = index; // выберем родителя
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        // выберем из трех этих элементов наибольший
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        // сравним полученный наибольший с поступившим корнем в функцию
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapArray(arr, heapSize, largest);
        }

    }

    /**
     * @apiNote вывод массива в консоль
     * @param arr массив
     */
    public static void printArray( int[] arr){
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    /**
     * @apiNote формируем массив из рандомных чисел
     * @param length длинна массива
     * @return массив
     */
    public static int[] prepareArray ( int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}