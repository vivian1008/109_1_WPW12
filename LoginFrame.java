import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class LoginFrame extends JFrame{
    private Container cp;
    private JLabel id = new JLabel("id:");
    private JTextField tid = new JTextField("");
    private JLabel pw = new JLabel("pw:");
    private JPasswordField tpw = new JPasswordField("");
    private JButton ext = new JButton("Exit");
    private JButton bod = new JButton("board");
    private JButton log = new JButton("Log in");
    private JPanel jpn1 = new JPanel(new GridLayout(2,1,1,1));
    private JPanel jpn2 = new JPanel(new GridLayout(2,1,1,1));
    private JPanel jpn3 = new JPanel(new GridLayout(1,3,1,1));

    public LoginFrame(){
        init();
    }
    
    private void init(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpn1,BorderLayout.WEST);
        cp.add(jpn2,BorderLayout.CENTER);
        cp.add(jpn3,BorderLayout.SOUTH);
        this.setTitle("Log in");
        this.setBounds(100,100,500,200);
        
        
    
        jpn1.add(id);
        jpn2.add(tid);
        jpn1.add(pw);
        jpn2.add(tpw);
        jpn3.add(ext);
        jpn3.add(bod);
        jpn3.add(log);
    
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    
        ext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });

        bod.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                KeyboardFrame kFrm = new KeyboardFrame(LoginFrame.this);
                kFrm.setVisible(true);
            }
        });

        log.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println("Submit"+tpw.getText());
                if(tid.getText().equals("123") && tpw.getText().equals("000")){
                    EncryptFrame eFrm = new EncryptFrame();
                    eFrm.setVisible(true);
                }
               
            }

        });
    }
    public void setPW(String passwd){
        tpw.setText(passwd);
        System.out.println("In LoginFrame PW =>" + tpw.getText());
    }
}
