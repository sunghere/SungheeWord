package kr.co.ensof.reader;

import javax.swing.*;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by SungHere on 2017-10-27.
 */

public class ReaderThread extends Thread {

    private JTextArea area;
    private String path;

    public ReaderThread(String path, JTextArea area) {
        super();
        this.area = area;
        area.setText("경로 확인 [" + path + "]\n");

        area.append("작업 시작...\n");
        this.path = path;

    }

    @Override
    public void run() {
        super.run();
        LogReader reader = new LogReader();
        Vector<String> messages = null;
        try {
            reader.fileRead(path);
            messages = reader.infoMessage();
            for (String message : messages) {
                area.append(message + "\n");
            }

        } catch (IOException e) {
            area.append("Error 0 : 경로 재확인\n " + e);
        }
        interrupt();
    }

    @Override
    public void interrupt() {
        super.interrupt();

        area.append("Success! \n");
    }

}
