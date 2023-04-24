
package javachatsystem;
import java.util.Scanner;

class Chat {
    Scanner sc1= new Scanner(System.in);
    Scanner sc2= new Scanner(System.in);
    Scanner sc3= new Scanner(System.in);
    String string1, string2, string3;
    
    int flag=0;

    public synchronized void talk1() throws InterruptedException {

        if(flag==1) {
            wait();
        }


        System.out.print("Nabid :");
        string1 = sc1.nextLine();

        if(string1.equals("Bye")) {

            System.out.println("\n Nabid has left from the conversation");
            System.out.println("\tGroup discussion has ended.");

            System.exit(0);
        }

        flag=1;
        notify();

    }

    public synchronized void talk2() throws InterruptedException {
        if(flag==2) {
            wait();
        }

        System.out.print("Maria :");
        string2 = sc2.nextLine();

        if( string2.equals("Bye")) {

            System.out.println("\n Maria has left from the conversation.");
            System.out.println("\tGroup discussion has ended.");
            System.exit(0);

        }

        flag=2;
        notify();

    }


    public synchronized void talk3() throws InterruptedException {

        wait();

        System.out.print("Arjun :");
        string3 = sc3.nextLine();

        if(string3.equals("Bye")) {


            System.out.println("\n Arjun has left from the conversation.");
            System.out.println("\tGroup Discussion has ended.");
            System.exit(0);


        }

        notify();

    }
}


class Thread1 extends Thread {
    Chat message;

    public  Thread1(Chat message) {
        this.message=message;

    }

    public void run() {
        try {
            while(true) {

                message.talk1();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class Thread2 extends Thread {
    Chat message;


    public Thread2(Chat message) {
        this.message=message;
    }

    public void run() {
        try {
            while(true) {
                message.talk2();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread {
    Chat message;


    public Thread3(Chat message) {
        this.message=message;
    }

    public void run() {
        try {
            while(true) {
                message.talk3();
            }
        } catch( InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class JavaChatSystem {

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\tGroup Discussion ");
        System.out.println("\t\t\t\tMembers: Nabid, Maria, Arjun\n");

        Chat message = new Chat();

        new Thread1(message).start();
        new Thread2(message).start();
        new Thread3(message).start();

    }

}
