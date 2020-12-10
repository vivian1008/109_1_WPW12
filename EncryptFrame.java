import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EncryptFrame extends JFrame{
    private Container cp;
    private JTextField jtf = new JTextField("");
    private JTextField jtf2 = new JTextField("");
    private JTextArea jtaP = new JTextArea("");
    private JScrollPane jspP = new JScrollPane(jtaP);
    private JTextArea jtaC = new JTextArea("");
    private JScrollPane jspC = new JScrollPane(jtaC);
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmu = new JMenu("File");
    private JMenuItem jmi = new JMenuItem("Open");
    private JPanel jpnCtr = new JPanel(new GridLayout(2,5,1,1));
    private JPanel jpnC = new JPanel(new GridLayout(1,2,1,1));
    private JLabel jlbA = new JLabel("Encrypt Algotithm");
    private JLabel jlbP = new JLabel("");
    private JLabel jlb = new JLabel("Encrypt/Decrypt");
    private JButton go = new JButton("GO!");
    private JButton re = new JButton("Resset");
    private JButton ext = new JButton("Exit");
    private JRadioButton jrbE = new JRadioButton("Encrypt");
    private JRadioButton jrbD = new JRadioButton("Decrypt");
    private ButtonGroup bg = new ButtonGroup();
    private JFileChooser jfc = new JFileChooser();
    //private String algos[] = {"XOR" , "Caeser"} ;
    private JComboBox jcb = new JComboBox();

    public EncryptFrame(){
        init();
    }

    private void init(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setTitle("Encrypt System");
        this.setJMenuBar(jmb);
        jmu.add(jmi);
        jmb.add(jmu);
        this.setBounds(10,10,700,500);
        jpnC.setSize(400,200);
        cp.add(jpnCtr,BorderLayout.NORTH);
        cp.add(jpnC,BorderLayout.CENTER);
        jpnCtr.add(jrbE);
        jpnCtr.add(jrbD);
        jpnCtr.add(jlbA);
        jpnCtr.add(jcb);
        jpnCtr.add(jtf);
        jpnCtr.add(go);
        jpnCtr.add(jrbE);
        jpnCtr.add(jrbD);
        jpnCtr.add(re);
        jpnCtr.add(ext);
        jpnC.add(jspC);
        jpnC.add(jspP);
        jcb.addItem(new String("XOR"));
        jcb.addItem(new String("Caeser"));

        this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    });
    go.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            switch (jcb.getSelectedIndex()){
                case 0 :
                char data[] = jtaC.getText().toCharArray();
                char passwd[] = jtf.getText().toCharArray();
                char newdata[] = new char[data.length];
                for(int i = 1; i < data.length; i++){
                    newdata[i] = (char)((int)data[i]^(int)passwd[i % passwd.length]);
                }
                jtaP.setText(new String(newdata));
                break;

                case 1 :
                char data1[] = jtaC.getText().toCharArray();
                int key  = Integer.parseInt(jtf.getText());
                char newdata1 [] = new char[data1.length];
                for(int i = 1; i < data1.length; i++){
                    newdata1[i] = (char)((int)data1[i] + key);
                }
                jtaP.setText(new String(newdata1));
                break;
            }
        }
    });

    re.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
               jtf.setText("");
               jtaP.setText("");
               jtaC.setText("");
               jrbE.setSelected(true);
        }
    });
    
    ext.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            System.exit(0);
        }
    });
    }
    }

