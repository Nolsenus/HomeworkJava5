import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {

    static int[] getRandomArray(int size) {
        int[] result = new int[size];
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            result[i] = rnd.nextInt(0, 100);
        }
        return result;
    }

    static int getArraySize(Scanner in) {
        int size;
        while (true) {
            System.out.print("Введите размер массива: ");
            if (!in.hasNextInt()) {
                System.out.println("Вы ввели не целое число. Попробуйте снова.");
                in.nextLine();
                continue;
            }
            size = in.nextInt();
            if (size >= 0) {
                break;
            }
            System.out.println("Размер массива должен быть больше или равен нулю.");
            in.nextLine();
        }
        return size;
    }

    static void printArray(int[] array) {
        int length = array.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.println(array[length - 1]);
    }

    static void heapify(int[] array) {
        int maxChildIndex, leftChildIndex, temp, curIndex;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            curIndex = i;
            leftChildIndex = curIndex * 2 + 1;
            while (leftChildIndex < array.length) {
                maxChildIndex = leftChildIndex;
                if (curIndex * 2 + 2 < array.length) {
                    maxChildIndex = array[maxChildIndex] > array[curIndex * 2 + 2] ? maxChildIndex : curIndex * 2 + 2;
                }
                if (array[curIndex] < array[maxChildIndex]) {
                    temp = array[curIndex];
                    array[curIndex] = array[maxChildIndex];
                    array[maxChildIndex] = temp;
                    curIndex = maxChildIndex;
                    leftChildIndex = curIndex * 2 + 1;
                } else {
                    break;
                }
            }
        }
    }

    static void siftDown(int[] array, int length) {
        int index = 0;
        int leftChildIndex = 1;
        int maxChildIndex, temp;
        while (leftChildIndex < length) {
            maxChildIndex = leftChildIndex;
            if (2 * index + 2 < length) {
                maxChildIndex = array[maxChildIndex] > array[2 * index + 2] ? maxChildIndex : 2 * index + 2;
            }
            if (array[index] < array[maxChildIndex]) {
                temp = array[index];
                array[index] = array[maxChildIndex];
                array[maxChildIndex] = temp;
                index = maxChildIndex;
                leftChildIndex = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    static void heapSort(int[] array) {
        heapify(array);
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            siftDown(array, i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = getArraySize(in);
        in.close();
        int[] array = getRandomArray(size);
        printArray(array);
        heapSort(array);
        printArray(array);
    }
}
