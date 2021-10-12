package lpsim;

import java.util.Scanner;

import quickfix.*;

public class ReceiverApp {
    private FIXReceiver fixReceiver;
    private static String MESSAGE_W_EXAMPLE = "8=FIX.4.2 | 9=244 | 35=S | 34=321742 | 49=ampm.streaming.tradair | 52=20210715-12:31:29.367 | 56=ampm4.ampm.streaming.tradair | 55=USD/TRY | 64=20210719 | 117=2b36b111-f4ac-f863-78cf-652252189922 | 131=USD/TRY_1000000.0 | 132=4.58447 | 133=4.58788 | 134=1000000 | 135=1000000 | 647=0 | 648=0 | 10=047 |";
    /**
     * init the lp receiver app
     * @param cfg
     * @throws ConfigError
     */
    public void init(String cfg) throws ConfigError {
        SessionSettings settings = new SessionSettings(cfg);
        fixReceiver = new FIXReceiver();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketAcceptor acceptor = new SocketAcceptor(fixReceiver, fileStoreFactory,
                settings, screenLogFactory, msgFactory);

        acceptor.start();

        Scanner reader = new Scanner(System.in);
        System.out.println("press <enter> to quit");

        //get user input for a
        reader.nextLine();

        acceptor.stop();
    }

    public void sendPrice(String msg) throws IllegalAccessException, FieldNotFound, InvalidMessage, InstantiationException, ConfigError, SessionNotFound {
        fixReceiver.sendStep(MESSAGE_W_EXAMPLE);
    }

    public static void main(String[] args) throws ConfigError {

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

}