package Lab9;

import java.sql.*;

public class AghDateBase {
    private Connection conn = null;
    private Statement stmt = null; // with this object we are making queries to DB
    private ResultSet rs = null;
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn=DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/papior",
                    "papior","xmx4Hr3SMo8B924C");
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}

    }

    public void listNames() {
        try {
            connect();
            this.stmt = this.conn.createStatement();

            this.rs = stmt.executeQuery("SELECT author from books");
            ResultSetMetaData resultSetMetaData = this.rs.getMetaData();

            while (rs.next()) { //go to the next row
                String name = rs.getString(1);
//                System.out.println(resultSetMetaData.getColumnLabel(1));
//                System.out.println("Uzytkowanik: " + name);

            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());

        } finally {
            //tu zwalniamy zasoby
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void displayTable(){ // ASK FOR DOUBLE LOOP DECLARITON WHY NOT ALLOWED ?
        try {
            connect();

            this.stmt = this.conn.createStatement();

            this.rs = stmt.executeQuery("SELECT * from books");
            ResultSetMetaData resultSetMetaData = this.rs.getMetaData();

            while (rs.next()) {
                String row="";
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++){ //iterate thorough rows in table
                        row+=resultSetMetaData.getColumnLabel(i) +
                    ": "+rs.getString(i) + " ";// get string in column

                }  //iterate thorough rows in table
                System.out.println(row);
            }
        }
        catch(SQLException e){
            System.out.println(e.getSQLState());

        }
        finally {
            //tu zwalniamy zasoby
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }
}
