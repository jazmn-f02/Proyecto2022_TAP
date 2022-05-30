package sample.components;

import javafx.scene.control.ProgressBar;

public class Corredor extends Thread{

    private ProgressBar pgbCarril;

    public Corredor(String nombre,ProgressBar pgb){
        super(nombre);
        this.pgbCarril=pgb;
    }

    @Override
    public void run() {
        super.run();
        double avance=0;
        //for (int i = 1; i < 10; i++) {
        while (avance<1){
            try {
                avance+=Math.random()/10;
                Thread.sleep((long)(Math.random()*4000));
                pgbCarril.setProgress(avance);
                //System.out.println("Corredor"+getName()+"(KM "+i+")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(getName()+"llegó a la meta");
    }
}
