package extras;

public class RemoveCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != charToRemove) {
                result.append(input.charAt(i));
            }
        }
        
        System.out.println("Modified String: " + result.toString());
    }
}
