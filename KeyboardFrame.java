import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class KeyboardFrame extends JFrame{
    private Container cp;
    private JButton jbtn[] = new JButton[54];
    private JPanel jpl1 = new JPanel(new GridLayout(5,10,3,3));
    private JPanel jpl2 = new JPanel(new GridLayout(1,4,3,3));
    private JPasswordField jpf = new JPasswordField();
    private JToggleButton cap = new JToggleButton();
    private LoginFrame loginfrm;
    private String btnlab[] ={"0","1","2","3","4","5","6","7","8","9",
                              "!","@","#","$","%","^","&","(",")","+",
                              "-","*","_","-","a","b","c","d","e","f",
                              "g","h","i","j","k","l","m","n","o","p",
                              "q","r","s","t","u","v","w","x","y","z",
                              "Exit","Reset","Submit"};
    private int randMap[] = new int[50];
    private Random rand = new Random();
    public KeyboardFrame(LoginFrame logFrm){
        loginfrm = logFrm;
        init();
    }

    private void init(){
        cp = this.getContentPane();
        this.setBounds(200,200,800,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        int x = 0;
        boolean flag = true;
        randMap[x] = rand.nextInt(50);
        int y = 0;
        while(y < x && flag){
           if(randMap[x] == randMap[y]){
               flag = false;
               break;
           } 
           y++;
        }
        if(flag){
            x++;
        }
        cp.setLayout(new BorderLayout(3,3));
        for(int i = 0; i < btnlab.length; i++){
            if(i > jbtn.length - 5){
                jbtn[i] = new JButton(btnlab[i]);
                jpl2.add(jbtn[i]);
            }
            else{
                jbtn[i] = new JButton(btnlab[randMap[i]]);
                jpl1.add(jbtn[i]);
            }
            jbtn[i].setFont(new Font(null, Font.PLAIN,28));
            jbtn[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e2){
                    JButton jbtmp = (JButton)e2.getSource();
                    switch(jbtmp.getText()){
                        case "Exit":
                        KeyboardFrame.this.dispose();
                        break;
                        case "Reset":
                        jpf.setText("");
                        break;
                        case "Submit":
                        loginfrm.setPW(jpf.getText());
                        KeyboardFrame.this.dispose();
                        break;
                        default:
                        char c = jbtmp.getText().charAt(0);
                        int n = c - 'a';
                        if(n >= 0 && n < 26){
                            if(cap.isSelected()){
                                c = Character.toUpperCase(c);
                            }
                        }
                        jpf.setText(jpf.getText() + c);
                        System.out.println(jpf.getText());
                    }
                }
            });
        }   
    }
}