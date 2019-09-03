public class RunModul7P {
    public static void main(String[] args)
    {
        Modul7P node1 = new Modul7P("Node 1", 1000);
        Modul7P node2 = new Modul7P("Node 2", 2000);
        Modul7P node3 = new Modul7P("Node 3", 3000);

        node1.start();
        node2.start();
        node3.start();
    }
}
