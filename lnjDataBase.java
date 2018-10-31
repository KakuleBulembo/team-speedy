import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class lnjDataBase {
    Connection con;
    ResultSet r;
    String USER = "root";
    String PASS = "";
    String URL = "jdbc:mysql://localhost:3306/restaurantlnj";
    
    public Connection Connect(){
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(URL,USER,PASS);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet loginData(){
        try {
            Connection c = this.Connect();
            String sql = "select * from loginadmin";
            PreparedStatement st = c.prepareStatement(sql);
            r= st.executeQuery();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }}
         public DefaultTableModel getBookingData(){
             //add columns
            DefaultTableModel dtm=new DefaultTableModel();
            dtm.addColumn("FirstName");
            dtm.addColumn("LastName");
            dtm.addColumn("Email");
            dtm.addColumn("Telephone");
            dtm.addColumn("DateO");
            dtm.addColumn("NoOfSeats");
            dtm.addColumn("TableNo");
            String sql="SELECT * FROM bookingable ";
            
          try{
                //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String FirstName=r.getString(1);
                    String LastName=r.getString(2);
                    String Email=r.getString(3);
                    String Telephone=r.getString(4);
                    String Date=r.getString(5);
                    String NoOfSeats=r.getString(6);
                    String TableNo=r.getString(7);
                    dtm.addRow(new String[]{FirstName,LastName,Email,Telephone,Date,NoOfSeats,TableNo});
                }
                return dtm;
            }catch(SQLException ex){}
            return null;
            }
        public void insertBookingData(String FirstName, String LastName,String Email, String telephone, String Date,String NoOfSeats, int TableNo)
        {
        try {
            String sql = "insert into bookingtable(FirstName,LastName,Email,Telephone,Date,NoOfSeats,TableNo) Values('" + FirstName+"','"+ LastName +"','" + Email  +"','"+ telephone + "','" + Date +"','"+NoOfSeats+"','" + TableNo + "')";
            PreparedStatement st = this.Connect().prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public DefaultTableModel getDrinksData(){
        //add column
          DefaultTableModel dtm=new DefaultTableModel();
          dtm.addColumn("ID");
          dtm.addColumn("Name");
          dtm.addColumn("Price");
          String sql="SELECT * FROM drinks";
          try{
              //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String ID=r.getString(1);
                    String Name=r.getString(2);
                    String Price=r.getString(3);
                    dtm.addRow(new String[]{ID,Name,Price});
                }
                return dtm;
          }catch(SQLException ex){}
          return null;
          
        }
        //Update
        public Boolean updateIntoDrinks(String Name,String Price){
        //SQL STATEMENT
            String sql="UPDATE drinks SET Namr='"+Name+"',Price='"+Price+"'";
            try{
                //get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                st.execute(sql);
                return true;
            }catch(SQLException ex){
        return false;
        }
            }
        public Boolean deleteIntoDrinks(String ID){
        String sql="DELETE FROM drinks WHERE ID='"+ID+"'";
        try{
        Connection c=this.Connect();
        PreparedStatement st=c.prepareStatement(sql);
        st.execute(sql);
        return true;
        }catch(SQLException ex){
            return false;
        }
        }
        public void insertDrinksData(String Name,String Price){
             try{
                 String sql="insert into drinks(Name,Price) Values('"+Name+"','"+Price+"')";
                 PreparedStatement st=this.Connect().prepareStatement(sql);
                 st.executeUpdate();
             }catch(SQLException ex){
              Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             }
       public DefaultTableModel getBreakfastData(){
        //add column
          DefaultTableModel dtm=new DefaultTableModel();
          dtm.addColumn("Name");
          dtm.addColumn("Price");
          String sql="SELECT * FROM breakfast";
          try{
              //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String Name=r.getString(1);
                    String Price=r.getString(2);
                    dtm.addRow(new String[]{Name,Price});
                }
                return dtm;
          }catch(SQLException ex){}
          return null;
          
        }
        public void insertBreakfastData(String Name,String Price){
             try{
                 String sql="insert into breakfast(Name,Price) Values('"+Name+"','"+Price+"')";
                 PreparedStatement st=this.Connect().prepareStatement(sql);
                 st.executeUpdate();
             }catch(SQLException ex){
                 
              Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             }
         public DefaultTableModel getLunchData(){
        //add column
          DefaultTableModel dtm=new DefaultTableModel();
          dtm.addColumn("Name");
          dtm.addColumn("Price");
          String sql="SELECT * FROM lunch";
          try{
              //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String Name=r.getString(1);
                    String Price=r.getString(2);
                    dtm.addRow(new String[]{Name,Price});
                }
                return dtm;
          }catch(SQLException ex){}
          return null;
          
        }
        public void insertLunchData(String Name,String Price){
             try{
                 String sql="insert into lunch(Name,Price) Values('"+Name+"','"+Price+"')";
                 PreparedStatement st=this.Connect().prepareStatement(sql);
                 st.executeUpdate();
             }catch(SQLException ex){
              Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             }
         public DefaultTableModel getDessertData(){
        //add column
          DefaultTableModel dtm=new DefaultTableModel();
          dtm.addColumn("Name");
          dtm.addColumn("Price");
          String sql="SELECT * FROM desserts";
          try{
              //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String Name=r.getString(1);
                    String Price=r.getString(2);
                    dtm.addRow(new String[]{Name,Price});
                }
                return dtm;
          }catch(SQLException ex){}
          return null;
          
        }
        public void insertDessertData(String Name,String Price){
             try{
                 String sql="insert into desserts(Name,Price) Values('"+Name+"','"+Price+"')";
                 PreparedStatement st=this.Connect().prepareStatement(sql);
                 st.executeUpdate();
             }catch(SQLException ex){
              Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             }
        public ResultSet loginCustomerData(){
        try {
            Connection c = this.Connect();
            String sql = "select * from customer";
            PreparedStatement st = c.prepareStatement(sql);
            r= st.executeQuery();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }}
        
         public DefaultTableModel getCustomerData(){
            //add columns
            DefaultTableModel dtm=new DefaultTableModel();
            dtm.addColumn("Customer_id");
            dtm.addColumn("Name");
            dtm.addColumn("Address");
            dtm.addColumn("Contactno");
            String sql="SELECT * FROM customers ";
            
          try{
                //Get connection
                Connection c=this.Connect();
                PreparedStatement st=c.prepareStatement(sql);
                r=st.executeQuery();
                while (r.next()){
                //get values
                    String Customer_id=r.getString(1);
                    String Name=r.getString(2);
                    String Address=r.getString(3);
                    String Contactno=r.getString(4);
                    dtm.addRow(new String[]{Customer_id,Name,Address,Contactno});
                }
                return dtm;
            }catch(SQLException ex){}
            return null;
            }
        public void insertCustomerData( String Name,String Address, String Contactno, String Username,String Password)
        {
        try {
            String sql = "insert into customers(Name,Address,Contactno,Username,Password) Values('" +Name+"','"+ Address +"','" + Contactno  +"','"+ Username+ "','" +Password+"')";
            PreparedStatement st = this.Connect().prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(lnjDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}

    

