/**
 * Created by Ivan Isaev on 04.04.2018.
 */
public class Main {
    static FileUtils fileUtils = new FileUtils();
    static SQLUtils sqlUtils = new SQLUtils();

    public static void main(String[] args) {
        sqlUtils.executeQueryCreateTable(fileUtils.readDirectory("E:\\alevel\\src\\dbConsole\\src\\files\\").get(0));
    }
}
