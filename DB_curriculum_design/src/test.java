public class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 3; i <= j; j--)
                System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (i == 2 && j == 1) {
                    break;
                }
                System.out.print("*");
            }

            System.out.println();
        }
    }

}
