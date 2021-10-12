package lpsim;

import quickfix.*;
import quickfix.field.*;
import quickfix.fix42.MarketDataIncrementalRefresh;
import quickfix.fix42.MarketDataSnapshotFullRefresh;
import quickfix.fix42.MessageCracker;
import quickfix.fix42.NewOrderSingle;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class FIXReceiver extends MessageCracker implements Application {


    private static DataDictionary dataDictionary = null;
    private static SessionID cachedSession;
    private boolean isLoggedOn;

    private static String buildStrFixMessage(String msg){
        StringTokenizer tokenizer = new StringTokenizer(msg, "|");
        StringBuilder strFixMessage = new StringBuilder();
        while(tokenizer.hasMoreElements()){
            strFixMessage.append(tokenizer.nextToken().trim());
            strFixMessage.append("\u0001");
        }
        System.err.println(strFixMessage);
        return strFixMessage.toString();
    }

    public void load(String dataDictionaryFile) throws ConfigError {
        dataDictionary = new DataDictionary(dataDictionaryFile);
        dataDictionary.setCheckFieldsOutOfOrder(false);
        dataDictionary.setCheckUserDefinedFields(false);
        dataDictionary.setAllowUnknownMessageFields(true);
        dataDictionary.setCheckUnorderedGroupFields(false);
    }

    public void sendStep(String msg) throws InstantiationException, IllegalAccessException, InvalidMessage, FieldNotFound, SessionNotFound, ConfigError {
//        String msgType = findMsgType(step);
        if(dataDictionary==null){
            String directory = System.getenv("IC_DIC_DIR") + "/fix/dictionary/";
            //load(directory + "/Barx-Fix4.2-DataDictionary.xml");
            load(directory + "/FxPure-Fix.4.4-DataDictionary.xml");
        }
        Message rawFixMessage = new quickfix.fix42.Quote();
        rawFixMessage.fromString(buildStrFixMessage(msg), dataDictionary, false);
//        String senderCompID = rawFixMessage.getHeader().getString(49);
//        SessionID sessionID = sessionIDBySenderCompID.get(senderCompID);
        Session.sendToTarget(rawFixMessage, cachedSession);
    }

    @Override
    public void onMessage(NewOrderSingle order, SessionID sessionID) {
        System.out.println("Receiver onMessage..  " + order);
    }

    @Override
    public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound, IncorrectDataFormat,
            IncorrectTagValue, RejectLogon {
    }

    public void sendPriceVadim(Double rate){
        MarketDataSnapshotFullRefresh marketDataSnapshotFullRefresh = new MarketDataSnapshotFullRefresh();
        marketDataSnapshotFullRefresh.set(new MDReqID("Leonid"));
        marketDataSnapshotFullRefresh.set(new Symbol("EUR/USD"));
        marketDataSnapshotFullRefresh.set(new SecurityType(SecurityType.FOREIGN_EXCHANGE_CONTRACT));

        MarketDataSnapshotFullRefresh.NoMDEntries noMDEntriesGroup = new MarketDataSnapshotFullRefresh.NoMDEntries();
        noMDEntriesGroup.setField(new MDEntryType(MDEntryType.BID));
        noMDEntriesGroup.setField(new MDEntryPx(1.5));
        noMDEntriesGroup.setField(new MDEntrySize(1000_000));
        noMDEntriesGroup.setField(new QuoteEntryID("quote1"));
        marketDataSnapshotFullRefresh.addGroup(noMDEntriesGroup);

        Session session = Session.lookupSession(cachedSession);
        session.send(marketDataSnapshotFullRefresh);
    }

    public void sendPrice(Double rateBid, Double rateOffer){
        MarketDataSnapshotFullRefresh marketDataMessage = new MarketDataSnapshotFullRefresh();

       /* marketDataMessage.setString(OrderID.FIELD, "");                                          //37
        marketDataMessage.setString(ExecID.FIELD, "");                                           //17
        marketDataMessage.setString(ExecType.FIELD, "2");                                        //150
        marketDataMessage.setString(OrdStatus.FIELD, "0");                                       //39
        marketDataMessage.setString(Side.FIELD, "");                                             //54
        marketDataMessage.setString(MsgSeqNum.FIELD, "");           //added                      //34
        marketDataMessage.setString(Symbol.FIELD, "");              //added                      //55
        marketDataMessage.setString(MDReqID.FIELD, "");             //added                      //262
        marketDataMessage.setString(NoMDEntries.FIELD, "");         //added                      //268
        //marketDataMessage.setString(MDEntryPx.FIELD, "");           //added                      //270
        marketDataMessage.setString(MDEntrySize.FIELD, "");         //added                      //271
        marketDataMessage.setString(NumberOfOrders.FIELD, "");      //added                      //346
        marketDataMessage.setString(TradingSessionID.FIELD, "");    //added                      //336
        marketDataMessage.setString(MDEntryPositionNo.FIELD, "");   //added                      //290
        marketDataMessage.setString(MDEntryTime.FIELD, "");         //added                      //273
        //marketDataMessage.setString(Username.FIELD, "");            //added                      //553
        marketDataMessage.setString(LeavesQty.FIELD, "");                                        //151
        marketDataMessage.setString(CumQty.FIELD, "0");                                          //14
        marketDataMessage.setString(ClOrdID.FIELD, "");                                          //11
        marketDataMessage.setString(SecurityType.FIELD, "");                                       //167
        marketDataMessage.setString(SecurityID.FIELD, "");                                       //48
        marketDataMessage.setString(SecurityIDSource.FIELD, "");                                 //22
        marketDataMessage.setString(OrdType.FIELD, "");                                          //40
        marketDataMessage.setString(OrderQty.FIELD,"");                                          //38
        marketDataMessage.setUtcTimeStamp(TransactTime.FIELD, Timestamp.valueOf(LocalDateTime.now())); //60*/
        

        //Naked code before editing
        //marketDataMessage.getHeader().setString(MsgType.FIELD, "W");
        //marketDataMessage.setString(ExecType.FIELD, "2");
        //marketDataMessage.setString(LeavesQty.FIELD, "");
        //marketDataMessage.setString(SecurityID.FIELD, "");
        //marketDataMessage.setUtcTimeStamp(TransactTime.FIELD, Timestamp.valueOf(LocalDateTime.now()));
        //marketDataMessage.setString(SecurityType.FIELD, "");                                       //167


        marketDataMessage.setString(Symbol.FIELD, "EUR/USD");       //added                      //55
        marketDataMessage.setString(MDReqID.FIELD, "Leon");             //added                      //262
        //marketDataMessage.setString(NoMDEntries.FIELD, "");         //added                      //268


        MarketDataIncrementalRefresh.NoMDEntries noMDEntriesGroupSell = new MarketDataIncrementalRefresh.NoMDEntries();
        noMDEntriesGroupSell.setField(new MDEntryType(MDEntryType.BID));
        noMDEntriesGroupSell.setField(new MDEntryPx(rateBid));
        //noMDEntriesGroup.setField(new SecurityType(SecurityType.FOREIGN_EXCHANGE_CONTRACT));
        noMDEntriesGroupSell.setField(new MDEntrySize(1000000));


        MarketDataIncrementalRefresh.NoMDEntries noMDEntriesGroupBuy = new MarketDataIncrementalRefresh.NoMDEntries();
        noMDEntriesGroupBuy.setField(new MDEntryType(MDEntryType.OFFER));
        noMDEntriesGroupBuy.setField(new MDEntryPx(rateOffer));
        //noMDEntriesGroup.setField(new SecurityType(SecurityType.FOREIGN_EXCHANGE_CONTRACT));
        noMDEntriesGroupBuy.setField(new MDEntrySize(1000000));


        //noMDEntriesGroup.setField(new Symbol(""));
        marketDataMessage.addGroup(noMDEntriesGroupSell);
        marketDataMessage.addGroup(noMDEntriesGroupBuy);


        Session session = Session.lookupSession(cachedSession);
        session.send(marketDataMessage);
//        crack(arg0, arg1); // calls onMessage(..,..)
    }

    @Override
    public void fromApp(Message arg0, SessionID arg1) throws FieldNotFound, IncorrectDataFormat,
            IncorrectTagValue, UnsupportedMessageType {
        //System.out.println(".....This is fromApp Call...");
        /*Message marketDataMessage = new Message();
        marketDataMessage.getHeader().setString(MsgType.FIELD, "W" );
        marketDataMessage.setString(OrderID.FIELD, "");
        marketDataMessage.setString(ExecID.FIELD, "");
        marketDataMessage.setString(ExecType.FIELD, "2");
        marketDataMessage.setString(OrdStatus.FIELD, "0");
        marketDataMessage.setString(Side.FIELD, arg0.getString(Side.FIELD));
        marketDataMessage.setString(LeavesQty.FIELD, arg0.getString(OrderQty.FIELD));
        marketDataMessage.setString(CumQty.FIELD, "0");
        marketDataMessage.setString(ClOrdID.FIELD, arg0.getString(ClOrdID.FIELD));
        marketDataMessage.setString(SecurityID.FIELD, arg0.getString(SecurityID.FIELD));
        marketDataMessage.setString(SecurityIDSource.FIELD, "");
        marketDataMessage.setString(OrdType.FIELD, arg0.getString(OrdType.FIELD));
        marketDataMessage.setString(OrderQty.FIELD, arg0.getString(OrderQty.FIELD));
        marketDataMessage.setUtcTimeStamp(TransactTime.FIELD, Timestamp.valueOf(LocalDateTime.now()));

        Session session = Session.lookupSession(cachedSession);
        session.send(marketDataMessage);*/
//        crack(arg0, arg1); // calls onMessage(..,..)
    }

    @Override
    public void onCreate(SessionID arg0) {
        System.out.println("Receiver onCreate.. " + arg0);
    }

    @Override
    public void onLogon(SessionID arg0) {
        System.out.println("Receiver onLogon.." + arg0);
        cachedSession=arg0;
        setLoggedOn(true);
//        try {
//            sendStep();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void onLogout(SessionID arg0) {}

    @Override
    public void toAdmin(Message arg0, SessionID arg1) {}

    @Override
    public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
        /*System.out.println("Receiver fromApp..  " + arg0);
//        ISession iSession = getSession(sessionId);

        Message marketDataMessage = new Message();
        marketDataMessage.getHeader().setString(MsgType.FIELD, "W" );
        marketDataMessage.setString(OrderID.FIELD, String.valueOf(orderIdGenerator.incrementAndGet()));
        marketDataMessage.setString(ExecID.FIELD, String.valueOf(execIdGenerator.incrementAndGet()));
        marketDataMessage.setString(ExecType.FIELD, "2");
        marketDataMessage.setString(OrdStatus.FIELD, "0");
        marketDataMessage.setString(Side.FIELD, arg0.getString(Side.FIELD));
        marketDataMessage.setString(LeavesQty.FIELD, arg0.getString(OrderQty.FIELD));
        marketDataMessage.setString(CumQty.FIELD, "0");
        marketDataMessage.setString(ClOrdID.FIELD, arg0.getString(ClOrdID.FIELD));
        marketDataMessage.setString(SecurityID.FIELD, arg0.getString(SecurityID.FIELD));
        marketDataMessage.setString(SecurityIDSource.FIELD, message.getString(SecurityIDSource.FIELD));
        marketDataMessage.setString(OrdType.FIELD, arg0.getString(OrdType.FIELD));
        marketDataMessage.setString(OrderQty.FIELD, arg0.getString(OrderQty.FIELD));
        marketDataMessage.setUtcTimeStamp(TransactTime.FIELD, Timestamp.valueOf(LocalDateTime.now()));

        Session session = Session.lookupSession(arg1);
        session.send(marketDataMessage);
*/
    }


    public boolean isLoggedOn() {
        return isLoggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        isLoggedOn = loggedOn;
    }
}