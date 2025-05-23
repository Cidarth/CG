package HackerRank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class map{
	public static void main(String []argh){
        
		Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        
        Map<String, String> phoneBook = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            String phone = in.nextLine();
            phoneBook.put(name, phone);
        }
        
        while (in.hasNext()) {
            String query = in.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }
        
        in.close();
	}
}



