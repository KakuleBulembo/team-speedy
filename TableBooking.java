
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.JOptionPane;

public class TableBooking extends JFrame{
    JPanel p=new JPanel();
    JLabel Lfname=new JLabel("Fist Name: ");
    JTextField fname=new JTextField();
    JLabel Llname=new JLabel("Last Name: ");
    JTextField lname=new JTextField();
    JLabel Lemail=new JLabel("Email: ");
    JTextField email=new JTextField();
    JLabel Lphone=new JLabel("Phone Number: ");
    JTextField phone=new JTextField();
    JLabel Lseat=new JLabel("Number Of Seats");
    JRadioButton a=new JRadioButton("2");
    JRadioButton b=new JRadioButton("4");
    JRadioButton c=new JRadioButton("8");
    ButtonGroup g=new ButtonGroup();
    JLabel Ldate=new JLabel("Date: ");
    JTextField date=new JTextField();
    JButton order=new JButton("ORDER");
    JButton clear=new JButton("CLEAR");
    
    TableBooking(){
    //calling methods
    JFrame();
    setLocationAndSize();
    addComponentToPanel();
    setLayoutManager();
    addActionEvent();
    }
    private void JFrame() {
       JFrame f=new JFrame();
       f.add(p);
       f.setSize(350,350);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);
       f.setLocationRelativeTo(null);
       
    }
    private void setLocationAndSize() {
       Lfname.setBounds(20,30,100,20);
       fname.setBounds(120, 30, 150, 20);
       Llname.setBounds(20, 65, 100, 20);
       lname.setBounds(120, 65, 150, 20);
       Lemail.setBounds(20, 100, 100, 20);
       email.setBounds(120,100,150,20);
       Lphone.setBounds(20, 135, 100, 20);
       phone.setBounds(120, 135, 150, 20);
       Lseat.setBounds(20, 170, 100, 20);
       a.setBounds(120,170,50,20);
       b.setBounds(180, 170, 50, 20);
       c.setBounds(240, 170, 50, 20);
       Ldate.setBounds(20, 205, 100, 20);
       date.setBounds(120,205,150,20);
       order.setBounds(50,240,100,20);
       clear.setBounds(170, 240, 100, 20);
       g.add(a);
       g.add(b);
       g.add(c);
    }
        private void addComponentToPanel() {
        p.add(Lfname);
        p.add(fname);
        p.add(Llname);
        p.add(lname);
        p.add(Lemail);
        p.add(email);
        p.add(Lphone);
        p.add(phone);
        p.add(a);
        p.add(b);
        p.add(c);
        p.add(Ldate);
        p.add(date);
        p.add(order);
        p.add(Lseat);
        p.add(clear);
        p.setBackground(Color.pink);
        }
 private void setLayoutManager() {
        p.setLayout(null);
    }
     private void addActionEvent() {
        order.addActionListener((java.awt.event.ActionEvent evt)->{
        orderActionPerformed(evt);});
        clear.addActionListener((java.awt.event.ActionEvent evt)->{
        clearActionPerformed(evt);});
        
    }
        private void orderActionPerformed(ActionEvent evt) {
            lnjDataBase db=new lnjDataBase();
            String No=null;
            Random x=new Random();
            int TableNo=0;
            for(int z=1;z<=3;z++){
            TableNo=1+x.nextInt(10);
            }
            if(a.isSelected()){
            No="2";
            }
            else if(b.isSelected()){
            No="4";
            }
            else if(c.isSelected()){
            No="8";
            }
            db.insertBookingData(fname.getText(), lname.getText(), email.getText(), phone.getText(), date.getText(), No, TableNo);
            JOptionPane.showMessageDialog(null, "Your table No "+TableNo+" has been reserved");
            fname.setText("");
            lname.setText("");
            email.setText("");
            phone.setText("");
            date.setText("");
            g.clearSelection();
        }
        private void clearActionPerformed(ActionEvent evt) {
        fname.setText("");
        lname.setText("");
        email.setText("");
        phone.setText("");
        date.setText("");
        g.clearSelection();
        
    }
     
    
    public static void main(String[] args) {
       new TableBooking();
    }
}
    

    

        
    

    
   

        
    