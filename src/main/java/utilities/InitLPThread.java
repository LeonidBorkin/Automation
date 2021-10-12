package utilities;

import lpsim.FIXReceiver;
import quickfix.*;

import java.util.Scanner;

public class InitLPThread extends Thread{

   public void run() {

       try{
           SessionSettings settings =  new SessionSettings("./Configuration/receiver.cfg");
           Application myApp = new FIXReceiver();
           FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
           ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
           DefaultMessageFactory msgFactory = new DefaultMessageFactory();
           SocketAcceptor acceptor = new SocketAcceptor(myApp, fileStoreFactory,
                   settings, screenLogFactory, msgFactory);

           acceptor.start();

           Scanner reader = new Scanner(System.in);
           System.out.println("press <enter> to quit");

           //get user input for a
           reader.nextLine();

           acceptor.stop();
   }
       catch (Exception e){
           System.out.println("Running Additional Thread for LP Error: \n" + e);
       }



   }


   public void ini(){

   }


}
