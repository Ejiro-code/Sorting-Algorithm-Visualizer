import javax.swing.*;
import java.awt.*;

public class BubbleSort extends JPanel {
    int [] arr;
    boolean [] arr1;

    //Panel maybe;
    public BubbleSort(int[] arr, boolean [] arr1){
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

                int i = 0;
                int j = 1;
                int count = arr.length - 1;
                int swap_count = 0;

                while (count > 0) {
                    while (i < arr.length - 1 && j < arr.length) {

                        if (arr[i] > arr[j]) {
                            arr1[i] = true;
                            arr1[j] = true;
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            swap_count++;
                        }
                        //this.remove(newPanel);
                        //maybe = new Panel(arr,arr1);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        revalidate();
                        repaint();


                        i++;
                        j++;
                    }
                    i = 0;
                    j = 1;
                    if (swap_count == 0) {
                        break;
                    }
                    count--;
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
