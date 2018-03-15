package Task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 15.03.2018.
 */
public class TopPassword {
    static ArrayList<String> passwordArray = new ArrayList<>();
    static Pass[] passCount;
    static void readPassword(String path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String temp;
            String password = null;
            while ((temp = reader.readLine()) != null){
                for(String passw : temp.split(":")){
                    password = passw;
                }
                passwordArray.add(password);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException ex){
            System.out.println("Error(");
        }
    }

    static void checkedCountPassword(){
        passCount = new Pass[passwordArray.size()];
        ArrayList<String> checkPass = new ArrayList<>();
        int count = 0;
        int index = 0;
        for (String pa : passwordArray){
            if(!checkPass.contains(pa)){
                passCount[index] = new Pass();
                checkPass.add(pa);
                passCount[index].setPass(pa);
                for(String temp : passwordArray){
                    if(pa.equals(temp)){
                        count++;
                    }
                }
                passCount[index].setCount(count);
                index++;
                count = 0;
            }
        }
        sortArray();
        for (int i = 0; i < 10; i++){
            if(passCount[i] != null){
                System.out.println(passCount[i].toString());
            }
        }
    }

    public static void sortArray(){
        Arrays.sort(passCount, new Comparator<Pass>() {
            @Override
            public int compare(Pass o1, Pass o2) {
                if (o1 == null || o2 == null){
                    return 0;
                }
                if(o1.getCount() > o2.getCount()){
                    return -1;
                }
                if(o1.getCount() < o2.getCount()){
                    return 1;
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a path:>> ");
        String path = sc.nextLine(); //E:\alevel\src\Module1\src\Task4\logpswd.txt
        readPassword(path);
        checkedCountPassword();
    }
}
