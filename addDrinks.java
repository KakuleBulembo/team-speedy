
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class addDrinks extends JFrame{
    JPanel mypanel=new JPanel();
    JLabel namelbl=new JLabel("Name: ");
    JTextField Name=new JTextField();
    JLabel pricelbl=new JLabel("price: ");
    JTextField Price=new JTextField();
    
    JButton clear=new JButton("CLEAR");
    JButton add=new JButton("SAVE");
    JButton logout=new JButton("LOGOUT");
  
    
    
    

         
            
    
    addDrinks(){
    //calling Methods
        JFrame();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToJPanel();
        addActionEvent();
       
        close();
       
    }
    

        private void addActionPerformed(ActionEvent evt) {
            lnjDataBase db = new lnjDataBase();
            
            db.insertDrinksData(Name.getText(),Price.getText());
              Name.setText("");
              Price.setText("");
          
              JOptionPane.showMessageDialog(null, "Drink Inserted");
        }
        
    private void clearActionPerformed(ActionEvent evt) {
              Name.setText("");
              Price.setText("");
              
    }
   
        
     


    public void JFrame() {
      JFrame myframe=new JFrame("ADD DRINKS"); 
      myframe.setSize(500,300);
      myframe.add(mypanel);
      myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myframe.setLocationRelativeTo(null);
      myframe.setVisible(true);
      
    }
     
    public void setLayoutManager() {
        mypanel.setLayout(null);
    }

    public void setLocationAndSize() {
     namelbl.setBounds(50, 70, 100, 20);
     Name.setBounds(150, 70, 150, 20);
     pricelbl.setBounds(50,100,100,20);
     Price.setBounds(150, 100, 150, 20);
     add.setBounds(75, 150, 100, 20);
     clear.setBounds(200,150,100,20);
    }

    public void addComponentsToJPanel() {
        mypanel.setBackground(Color.pink);
        mypanel.add(namelbl);
        mypanel.add(Name);
        mypanel.add(pricelbl);
        mypanel.add(Price);
        mypanel.add(add);
        mypanel.add(clear);
    }
        public void close() {
             
        }
        
    public void addActionEvent() {
        add.addActionListener((java.awt.event.ActionEvent evt)->{
        addActionPerformed(evt);});
        clear.addActionListener((java.awt.event.ActionEvent evt)->{
        clearActionPerformed(evt);});      
}
   
 
    public static void main(String[] a){
        new addDrinks();
    
    }

       
    }

   

       
    

  
    
 

    
      
      

    
    