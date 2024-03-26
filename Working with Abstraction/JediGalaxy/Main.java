package JediGalaxy;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = initializeGalaxy(rows, cols);

        long sumOfStarsCollected = 0;
        String command;
        while (!(command = scanner.nextLine()).equals("Let the Force be with you")) {
            int[] peterStartCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilStartCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            destroyStars(galaxy, evilStartCoordinates);
            sumOfStarsCollected += collectStars(galaxy, peterStartCoordinates);
        }

        System.out.println(sumOfStarsCollected);
    }

    private static int[][] initializeGalaxy(int rows, int cols) {
        int[][] galaxy = new int[rows][cols];
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
        return galaxy;
    }

    private static void destroyStars(int[][] galaxy, int[] evilCoordinates) {
        int evilRow = evilCoordinates[0];
        int evilCol = evilCoordinates[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (isValidCoordinate(galaxy, evilRow, evilCol)) {
                galaxy[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long collectStars(int[][] galaxy, int[] peterCoordinates) {
        int peterRow = peterCoordinates[0];
        int peterCol = peterCoordinates[1];
        long starsCollected = 0;

        while (peterRow >= 0 && peterCol < galaxy[0].length) {
            if (isValidCoordinate(galaxy, peterRow, peterCol)) {
                starsCollected += galaxy[peterRow][peterCol];
            }
            peterRow--;
            peterCol++;
        }

        return starsCollected;
    }

    private static boolean isValidCoordinate(int[][] galaxy, int row, int col) {
        return row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[0].length;
    }
}