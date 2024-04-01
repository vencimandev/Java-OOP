package Zoo;


public class Main {
    public static void main(String[] args) {
        Animal lizard = new Lizard("Larry the Lizard");
        Animal snake = new Snake("Sally the Snake");
        Animal gorilla = new Gorilla("Gary the Gorilla");
        Animal bear = new Bear("Barry the Bear");

        System.out.println(lizard.getName());
        System.out.println(snake.getName());
        System.out.println(gorilla.getName());
        System.out.println(bear.getName());
    }
}
