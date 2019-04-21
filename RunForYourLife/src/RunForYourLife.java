public class RunForYourLife implements Runnable {
    private Thread t;
    private String name;
    private String threadName;
    private int checkpoint;
    private double weight;
    private int totalCheckpoint=20;

    public RunForYourLife(String name, double weight) {
        this.name=name;
        this.threadName=name+"Thread";
        this.weight=weight;
        this.checkpoint=0;
    }

    public void run(){
        //First Time Thread Running
        System.out.println(name + ", go!");

        //Start Running
        while(getCheckpoint() != totalCheckpoint){
            //Delay Running
            int randNumber = (int) Math.round(LetsGo.getRandomNumber()*weight);
            try {
                Thread.sleep(randNumber);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted.");
            }
            System.out.println(name + " has passed checkpoint " +  checkpoint);
            checkpoint++;
        }

        //Finished Running
        System.out.println(name + " has finished!");
    }

    public void start() {
        if (t == null) {
            //Creating the Thread
            t = new Thread(this, threadName);
            System.out.println(name + ", ready!");
            //Starting the Thread
            System.out.println(name + ", set!");
            t.start();
        }
    }

    public String getName(){
        return name;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setCheckpoint(int checkpoint){
        this.checkpoint=checkpoint;
    }
}
