import javax.swing.*;
import java.awt.*;

public class InsertionSort extends JPanel {
    int [] arr;
    boolean [] arr1;

    //Panel maybe;
    public InsertionSort(int[] arr, boolean [] arr1){
        this.arr = arr;
        this.arr1 = arr1;

        for(int j : arr){
            System.out.println(j);
        }
        this.setVisible(true);
        this.setBounds(0,50,605,600);
        //maybe = new Panel(arr,arr1);
        //this.add(maybe);
        newSorter();

    }

    public void newSorter() {
        SwingWorker<Void, String> Worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int k = 0; k < arr1.length; k++) {
                    arr1[k] = false;
                }

                int k;
                int j = 1;
                for(int i = 0; i < arr.length-1; i++){
                    j = i+1;
                    k = i;
                    if(arr[i] > arr[j]){
                        while( k >= 0 && arr[k] > arr[j] ){
                            arr1[i] = true;
                            arr1[j] = true;
                            int temp = arr[k];
                            arr[k] = arr[j];
                            arr[j] = temp;
                            k--;
                            j--;

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            revalidate();
                            repaint();
                        }
                    }

                }

                return null;
            }
        };

        Worker.execute();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,605,520);



        for(int i = 0; i < arr.length; i++){
            if(arr1[i] == false){
                g.setColor(Color.ORANGE);
            }
            else {
                g.setColor(Color.MAGENTA);
            }
            g.fillRect(i*20,500-arr[i],20 - 2*5,arr[i]);
        }
        for(int k = 0; k < arr1.length; k++){
            arr1[k] = false;
        }

    }
}
