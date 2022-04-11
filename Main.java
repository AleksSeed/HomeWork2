package HomeWork2;
/**
 * 1. Как отловить исключения из try-with-resources?
 * 2. Является ли try-with-resource небезопасным при объявлении нескольких эффективных конечных ресурсов?
 **/

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"},};
// Недопустимое значение в ячейке 1x2
        //String[][] array = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "k", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
// Превышение размера массива
        //String[][] array = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}, {"5", "5", "5", "5"}};
        try {
            try {
                int result = method(array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Недопустимое значение в ячейке: " + e.i + "x" + e.j);
        }

    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }

}
