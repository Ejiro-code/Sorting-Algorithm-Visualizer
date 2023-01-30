import javax.swing.*;
import java.awt.*;

public class MergeSort extends JPanel {
    int [] arr;
    boolean [] arr1;

    //Panel maybe;
    public MergeSort(int[] arr, boolean [] arr1){
        this.arr = arr;
        this.arr1 = arr1;

//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
        this.setVisible(true);
        this.setBounds(0,50,605,600);
        //maybe = new Panel(arr,arr1);
        //this.add(maybe);
        //newSorter();
        mergeSort(0,arr.length-1);

    }

    public void mergeSort( int start, int end){
        if(start >= end){
            return;
        }

        int midpoint = (end + start)/2;
        mergeSort(start, midpoint);
        //newSorter(start,midpoint);
        mergeSort(midpoint+1, end);

        newSorter(start,end);

//        for (int m:
//                this.arr) {
//            System.out.print(m + "  ");
//        }
//        System.out.println();
    }

    public void newSorter( int start, int end) {
        SwingWorker<Void, String> Worker = new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {
                int begin = start;
                int mid1 = (start + end)/2;
                int mid2 = mid1;
                int temp = 0;
                while(begin <= mid1){
                    int t = begin;
                    while(mid2 <= end){
                        if(arr[t] >= arr[mid2]){
                            arr1[t] = true;
                            arr1[mid2] = true;
                            temp = arr[t];
                            arr[t] = arr[mid2];
                            arr[mid2] = temp;
                            t = mid2;

                        }
                        mid2++;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    revalidate();
                    repaint();
                    begin++;
                    mid2 = mid1;
                }
                //InsertionSort

//                int s = start;
//                int k;
//                int j = 0;
//                while(s < end){
//                    j = (start + end)/2;
//                    k = s;
//
//                    if(arr[s] > arr[j]){
//                        while( j < end && arr[k] > arr[j] ){
//                            arr1[s] = true;
//                            arr1[j] = true;
//                            int temps = arr[k];
//                            arr[k] = arr[j];
//                            arr[j] = temps;
//                            //k--;
//                            j++;
//
//                            try {
//                                Thread.sleep(80);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                            revalidate();
//                            repaint();
//                        }
//                    }
//                    s++;
//                }
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
                arr1[i] = false;
            }
            g.fillRect(i*20,500-arr[i],20 - 2*5,arr[i]);
        }
        for(int k = 0; k < arr1.length; k++){
            arr1[k] = false;
        }

    }
}
