package usothreads;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class SincronizandoHilos {

    public static void main(String[] args) {

        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);

        hilo1.start();
        hilo2.start();

        /*try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Terminadas las tareas");

    }

}

class HilosVarios extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Ejecutando hilo " + getName());
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class HilosVarios2 extends Thread {

    private Thread hilo;

    public HilosVarios2(Thread hilo) {

        this.hilo = hilo;

    }

    @Override
    public void run() {

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Ejecutando hilo " + getName());
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
