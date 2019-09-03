public class Modul7P implements Runnable {

    private Thread t;
    private String name;
    private String threadName;
    private int delay;
    private int position;

    public Modul7P(String name, int delay) {
        this.name=name;
        this.delay=delay;
        this.threadName="thread:"+threadName;
    }

    public void run() {
        System.out.println("Thread : " + name + ", Counting Down");
        position=10;
        //Start Running
        while (position > 0) {
            System.out.println("Thread : " + name + ", " + position);
            //Delay Running
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted.");
            }
            position--;
        }
    }

    public void start() {
        if (t == null) {
            //Creating the Thread
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
