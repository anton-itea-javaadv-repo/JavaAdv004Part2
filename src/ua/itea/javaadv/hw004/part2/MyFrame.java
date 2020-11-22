package ua.itea.javaadv.hw004.part2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Four labels frame");
        URL urlIn  = MyFrame.class.getResource("/ua/itea/javaadv/hw004/part2/in.txt");
        URL urlOut;
        try {
            urlOut = new File("out.txt").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        String inTxt = null;
        try {
            StringBuilder sbIn = new StringBuilder();
            InputStream isIn = urlIn.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(isIn, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                if (sbIn.length() != 0) {sbIn.append('\n');}
                sbIn.append(line);
            }
            br.close();
            inTxt = sbIn.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String outTxt = null;
        try {
            StringBuilder sbOut = new StringBuilder();
            InputStream isOut = urlOut.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(isOut, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                if (sbOut.length() != 0) {sbOut.append('\n');}
                sbOut.append(line);
            }
            br.close();
            outTxt = sbOut.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JTextArea textAreaIn1 = new JTextArea();
        textAreaIn1.setText(inTxt);
        textAreaIn1.setEditable(false);

        JTextArea textAreaIn2 = new JTextArea();
        textAreaIn2.setText(urlIn.getPath());
        textAreaIn2.setEditable(false);

        JTextArea textAreaOut1 = new JTextArea();
        textAreaOut1.setText(outTxt);
        textAreaOut1.setEditable(false);

        JTextArea textAreaOut2 = new JTextArea();
        textAreaOut2.setText(urlOut.getPath());
        textAreaOut2.setEditable(false);

        Container contentPane = getContentPane();

        BoxLayout boxLayout = new BoxLayout(contentPane, BoxLayout.PAGE_AXIS);
        setLayout(boxLayout);

        contentPane.add(textAreaIn1);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaIn2);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaOut1);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(textAreaOut2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
