
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

public class Drinks extends JFrame{
    JPanel mypanel=new JPanel();
  
    JButton d=new JButton("DELETE");
    JButton b=new JButton("BACK");
    JButton showtab=new JButton("REFRESH TABLE");
    JButton a=new JButton("ADD");
    JButton u=new JButton("UPDATE");
    
    JTable show = new JTable();
    JScrollPane sc = new JScrollPane();
    
    

            private void showtable() {  
                DefaultTableModel dtm=new DefaultTableModel();
                lnjDataBase db = new lnjDataBase();
                dtm = db.getDrinksData();
                show.setModel(dtm);
                sc.setViewportView(show);
          }
           
            
    
    Drinks(){
    //calling Methods
        JFrame();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToJPanel();
        addActionEvent();
        showtable();
        
       
    }
    

            
   
   private void bActionPerformed(java.awt.event.ActionEvent evt) {
         
         
         this.pack();
         this.dispose();
          }


    public void JFrame() {
      JFrame myframe=new JFrame("DRINKS"); 
      myframe.setSize(625,600);
      myframe.add(mypanel);
      myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myframe.setLocationRelativeTo(null);
      myframe.setVisible(true);
      
    }
     private void uActionPerformed(ActionEvent evt) {
        
    }

    private void aActionperformed(ActionEvent evt) {
     new addDrinks();
     
     
     
    }

    private void dActionPerformed(ActionEvent evt) {
    
    }

     private void showtabActionPerformed(ActionEvent evt) {
                DefaultTableModel dtm=new DefaultTableModel();
                lnjDataBase db = new lnjDataBase();
                dtm = db.getDrinksData();
                show.setModel(dtm);
                sc.setViewportView(show);
     }
    public void setLayoutManager() {
        mypanel.setLayout(null);
    }

    public void setLocationAndSize() {
     a.setBounds(400,400,100,20);
    
    
     b.setBounds(105,400,100,20);
     showtab.setBounds(225, 400, 150, 20);
     sc.setBounds(50, 50, 500, 300);
     
    }

    public void addComponentsToJPanel() {
        mypanel.setBackground(Color.pink);
        mypanel.add(a);
        mypanel.add(u);
        mypanel.add(b);
        mypanel.add(showtab);
        mypanel.add(d);
        mypanel.add(sc);
        
    }
       
        
    public void addActionEvent() {
        u.addActionListener((java.awt.event.ActionEvent evt)->{
        uActionPerformed(evt);});
        a.addActionListener((java.awt.event.ActionEvent evt)->{
        aActionperformed(evt);});
        d.addActionListener((java.awt.event.ActionEvent evt)->{
        dActionPerformed(evt);
        });
        b.addActionListener((java.awt.event.ActionEvent evt)->{
        bActionPerformed(evt);
        
        });
       showtab.addActionListener((java.awt.event.ActionEvent evt)->{
           showtabActionPerformed(evt);
       });
       
}
   
 
    public static void main(String[] a){
        new Drinks();
    
    }

   
}  
       
    

   

       
    

  
    
 

    
      
      

    
    