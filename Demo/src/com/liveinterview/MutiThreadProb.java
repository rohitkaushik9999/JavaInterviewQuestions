package com.liveinterview;

class DataSource{
    private int x = 0;
    synchronized public int getX(){
        return x;
    }
    synchronized public void setX(int x){
        this.x = x;
    }
}


public class MutiThreadProb {
    public static void main(String[] s) throws InterruptedException {
        DataSource ds = new DataSource();
        Thread t1=new Thread(new Worker(ds));
        Thread t2=new Thread(new Worker(ds));
        Thread t3=new Thread(new Worker(ds));
        t1.start();t2.start();t3.start();
        /*t1.join();
        t2.join();
        t3.join();*/
        System.out.println(ds.getX());
    }
}

class Worker implements Runnable{
private DataSource ds;
public Worker(DataSource ds){
    this.ds = ds;
}
    @Override
    public void run() {
        int x= ds.getX();
        x++;
        ds.setX(x);
    }
}
