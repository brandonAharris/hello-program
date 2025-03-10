import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

class Hello {
    public static void main(String[] args) {
        Scanner newObj = new Scanner(System.in);
        String newName;
        String errorResponse = "That response is not valid, try again.";

        while(true) {
            System.out.println("What's your name? ");

            newName = newObj.nextLine().trim();
            if (newName.isEmpty()) {
                System.out.println(errorResponse);
            } else {
                break;
            }
        }

        System.out.println("\nHello there, " + newName + ".");

        boolean continueConvo = true;
        while(continueConvo) {
            System.out.println("How are you feeling today?");
            System.out.println("1 for good, 2 for meh, 3 for bad.\n");

            String response = newObj.nextLine().trim();

            if (response.length() != 1) {
                System.out.println(errorResponse);
            } else {
                switch (response) {
                    case "":
                        System.out.println(errorResponse);
                        break;

                    case "1":
                        System.out.println("\nI am happy to hear that :)");
                        continueConvo = false;
                        break;

                    case "2":
                        System.out.println("\nHopefully we can make today more exciting!");
                        continueConvo = false;
                        break;

                    case "3":
                        System.out.println("\nIn that case, I think you need this...");
                        kitty();
                        continueConvo = false;
                        break;
                }
            }   
        }
        newObj.close();
    }

    public static void kitty() {
        try {
            Desktop desk=Desktop.getDesktop();
            desk.browse(new URI("https://genrandom.com/cats/")); 
        } catch(Exception e) {
            System.out.println("I'm sorry, something went wrong.");
        }
    }
}