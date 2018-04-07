package Task2;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class PingPong implements Runnable {
    static Game game = new Game();
    static boolean check = true;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(check)
        try {
            System.out.println("Bamm");
            Thread.sleep(2000);
            if(game.getSt() == null){
                check = false;
                System.out.println("Game Over");
                System.exit(0);
            }
            game.setSt(null);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
