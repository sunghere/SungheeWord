package kr.co.ensof.screen;


import kr.co.ensof.reader.ReaderThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SungHere on 2017-09-08.
 */
public class Screen extends JFrame {


    private boolean setLive = false;
    private Setting setting;
    private JFileChooser jfc;
    private JPanel topPanel;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    private JLabel jLabel;
    private JTextField jf;

    private JTextArea ja;
    private JScrollPane jp;

    private JButton geneBtn;
    private JButton resetBtn;
    private JButton findBtn;
    private JButton clearBtn;
    private JButton settingBtn;

    private JPanel leftPanel;
    private SettingScreen settingScreen;

    private ActionListener fileFind;


    public void setClose() {
        this.setLive = false;
    }

    public void init() {
        this.setName("McCube.과제");
        this.setTitle("McCube.과제");
        setting = Setting.getInstance();
        gbl = new GridBagLayout();
        topPanel = new JPanel(gbl);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // GridBagConstraints.fill: 컴포넌트의 디스플레이 영역이 컴포넌트가 요청한 크기보다 클 때,
        // 크기설정을 다시 할 것인가를 결정합니다. GridBagConstraints 클래스는 다음과 같은 값을 가능한 값으로 제공해 주고 있습니다.
        // ridBagConstraints.NONE: 디폴트 값
        // GridBagConstraints.HORIZONTAL: 수평적으로 확장하고 수직적으로는 확장하지 않습니다.
        // GridBagConstraints. VERTICAL: 수직적으로 확장하고 수평적으로는 확장하지 않습니다.
        // GridBagConstraints.BOTH: 수평 및 수직으로 확장합니다.
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        jLabel = new JLabel("경로 : ");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        findBtn = new JButton("Find..");

        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jfc.showOpenDialog(Screen.this) == JFileChooser.APPROVE_OPTION) {
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                    jf.setText(jfc.getSelectedFile().toString());
                }

            }
        });
        jf = new JTextField("", 20);
        jf.setEditable(false);

        ScreenUtil.gridAdd(topPanel, gbl, gbc, jLabel, 0, 0, 1, 1);
        ScreenUtil.gridAdd(topPanel, gbl, gbc, jf, 1, 0, 1, 1);
        ScreenUtil.gridAdd(topPanel, gbl, gbc, findBtn, 2, 0, 1, 1);
        // topPanel.add(findBtn);

        this.add(topPanel, BorderLayout.NORTH);

        // ---------------파일선택
        jfc = new JFileChooser();
        jfc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("log & txt file", "log", "txt"));

        ja = new JTextArea();
        jp = new JScrollPane(ja);

        ja.setEditable(false);
        this.add(jp);

        leftPanel = new JPanel();

        leftPanel.setLayout(new GridLayout(0, 1, 10, 20));

        geneBtn = new JButton("Read");

        geneBtn.addActionListener(new ActionListener() {

            private ReaderThread generator;

            @Override
            public void actionPerformed(ActionEvent e) {
                String path = Screen.this.jf.getText();

                if (!path.equals("") && path != null) {
                    generator = new ReaderThread(path, Screen.this.ja);
                    generator.run();
                } else {
                    Screen.this.ja.append("경로 확인 불가\n");
                    if (jfc.showOpenDialog(Screen.this) == JFileChooser.APPROVE_OPTION) {
                        // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                        jf.setText(jfc.getSelectedFile().toString());
                    }
                }
            }
        });


        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf.setText("");
            }
        });

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ja.setText("");
            }
        });


        settingBtn = new JButton("Setting");
        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (setLive) settingScreen.requestFocus();
                else {
                    settingScreen = new SettingScreen(Screen.this, setting);
                    setLive = true;
                }

            }
        });

        leftPanel.add(geneBtn);
        leftPanel.add(resetBtn);
        leftPanel.add(clearBtn);
        leftPanel.add(settingBtn);

        this.add(leftPanel, BorderLayout.EAST);

    }

    public Screen() {
        setSize(500, 300);

        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScreenUtil.setLocation(this);
        this.setVisible(true);

    }

}
