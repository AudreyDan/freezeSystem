package com.sery.freezesys.dllTest;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class TestDll {
    public interface TscLibDll extends Library {
        TscLibDll INSTANCE = (TscLibDll) Native.loadLibrary ("TSCLIB", TscLibDll.class);
        int about ();
        int openport (String pirnterName);
        int closeport ();
        int sendcommand (String printerCommand);
        int setup (String width,String height,String speed,String density,String sensor,String vertical,String offset);
        int downloadpcx (String filename,String image_name);
        int barcode (String x,String y,String type,String height,String readable,String rotation,String narrow,String wide,String code);
        int printerfont (String x,String y,String fonttype,String rotation,String xmul,String ymul,String text);
        int clearbuffer ();
        int printlabel (String set, String copy);
        int formfeed ();
        int nobackfeed ();
        int windowsfont (int x, int y, int fontheight, int rotation, int fontstyle, int fontunderline, String szFaceName, String content);
    }

    public static void main(String[] args) {
        String a = "F1254";
        String b = "李先生";
        String c = "DD123";
        //TscLibDll.INSTANCE.about();
        TscLibDll.INSTANCE.openport("Brady BBP12 #2");
        //TscLibDll.INSTANCE.downloadpcx("C:\\UL.PCX", "UL.PCX");
        TscLibDll.INSTANCE.sendcommand("REM ***** This is a test by JAVA. *****");
        TscLibDll.INSTANCE.setup("25.4", "9.5", "5", "8", "0", "0", "0");
        TscLibDll.INSTANCE.clearbuffer();
        //TscLibDll.INSTANCE.sendcommand("PUTPCX 550,10,\"UL.PCX\"");
        TscLibDll.INSTANCE.printerfont ("100", "10", "3", "0", "1", "1", a+""+b+""+c);
        TscLibDll.INSTANCE.barcode("100", "40", "128", "50", "1", "0", "2", "2", "123456789");
        TscLibDll.INSTANCE.windowsfont(10, 500, 60, 0, 0,0, "标楷体", "标楷体字型");
        TscLibDll.INSTANCE.windowsfont(10, 500, 60, 90, 0,0, "标楷体", "标楷体字型");
        /*TscLibDll.INSTANCE.windowsfont(400, 200, 48, 0, 3, 0, "arial", "DEG 0");
        TscLibDll.INSTANCE.windowsfont(400, 200, 48, 90, 3, 0, "arial", "DEG 90");
        TscLibDll.INSTANCE.windowsfont(400, 200, 48, 180, 3, 0, "arial", "DEG 180");
        TscLibDll.INSTANCE.windowsfont(400, 200, 48, 270, 3, 0, "arial", "DEG 270");*/
        TscLibDll.INSTANCE.printlabel("1", "1");
        TscLibDll.INSTANCE.closeport();
    }
}
