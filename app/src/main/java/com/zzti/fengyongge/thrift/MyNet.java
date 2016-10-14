package com.zzti.fengyongge.thrift;

import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;


/**
 * Created by fengyongge on 2016/10/13 0013.
 */

public class MyNet {

    private static MyNet _instance = null;
    public final static String NET_DOMAIN = "";
    public static THttpClient transport;
    public static String device = android.os.Build.MODEL;
    private MyNet() {

    }

    public static MyNet Inst() {
        synchronized (MyNet.class) {
            if (_instance == null) {
                _instance = new MyNet();
                try {
                    transport = new THttpClient(MyNet.NET_DOMAIN);
                    transport.open();
                } catch (TTransportException e) {
                    e.printStackTrace();
                }
            }
        }
        return _instance;
    }


//    /**
//     * 获取client对象
//     *
//     * @return
//     */
//    public static App.Client getClient() {
//        TProtocol protocol = new TBinaryProtocol(transport);
//        client = new App.Client(protocol);
//        return client;
//    }

    /**
     * 关闭通信
     */
    public static void getClose(){
        transport.close();
    }
}
