import java.io.File;

public class aaa {

    public static void main(String[] args) {
        getFileName();
    }

    public static void getFileName() {
        String path = ""; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File[] files = f.listFiles();
        assert files != null;
        for (File fs : files) {
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }
}