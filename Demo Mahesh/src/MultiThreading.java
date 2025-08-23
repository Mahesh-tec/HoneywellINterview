
/*Write a Java program to print a sequence of numbers up to N using 3 threads.
For example, if we want to print a sequence of numbers up to 10 then it’ll look like this:

THREAD-1 : 1
THREAD-2 : 2
THREAD-3 : 3
THREAD-1 : 4
THREAD-2 : 5
THREAD-3 : 6
THREAD-1 : 7
THREAD-2 : 8
THREAD-3 : 9
THREAD-1 : 10*/

import javax.sound.midi.Sequence;

public class MultiThreading {

    private static int n = 10;
    private static int count = 1;
    private static int turn = 1;

    public synchronized  void print(int threadId) {

        while (count <= n) {
            while (threadId != turn) {
                try {
                    wait();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (count <= n) {
                    System.out.println(("Thread Id : " + threadId + " " + count));
                    count ++;
                }
            }

            turn = threadId % 3 + 1;//1,2,3,1,2,3
            notifyAll();

        }
    }

        public static void main(String[] args) {



            MultiThreading printer = new MultiThreading();

            Runnable task1 = () -> printer.print(1);
            Runnable task2 = () -> printer.print(2);
            Runnable task3 = () -> printer.print(3);

            Thread t1 = new Thread((task1));
            Thread t2 = new Thread((task2));
            Thread t3 = new Thread((task3));

            t1.start();
            t2.start();
            t3.start();



    }
}
