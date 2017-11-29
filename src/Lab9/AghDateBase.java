package Lab9;

import java.sql.*;

public class AghDateBase {
    private Connection conn = null;
    private Statement stmt = null; // with this object we are making queries to DB
    private ResultSet rs = null;
    private boolean isConnected = false;
    public int i=1;

    public void connect() {
        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/papior",
                    "papior", "xmx4Hr3SMo8B924C");
            isConnected = true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            isConnected = false;
        } catch (Exception e) {
            e.printStackTrace();
            isConnected = false;
        }

    }

    public void listNames() {
        try {
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

    public void displayTable() { // ASK FOR DOUBLE LOOP DECLARITON WHY NOT ALLOWED ?
        try {
            if (isConnected) {
                this.stmt = this.conn.createStatement();

                this.rs = stmt.executeQuery("SELECT * from books");
                ResultSetMetaData resultSetMetaData = this.rs.getMetaData();

                while (rs.next()) {
                    String row = "";
                    for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { //iterate thorough rows in table
                        row += resultSetMetaData.getColumnLabel(i) +
                                ": " + rs.getString(i) + " ";// get string in column

                    }  //iterate thorough rows in table
                    System.out.println(row);
                }
            } else {
                while (i <= 3 && !isConnected) {
                        System.out.println("Proba " + i);
                        connect();
                        if(isConnected)
                            displayTable();
                        i++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            while (i <= 3 && !isConnected) {
                System.out.println("Proba " + i);
                connect();
                if(isConnected)
                    displayTable();
                i++;
            }

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

    public void deleteByAuthorOrIsbn(String pattern) {
        try {
            if (isConnected) {
                this.stmt = conn.createStatement();

                stmt.executeUpdate(String.format("DELETE FROM books WHERE author='%s'", pattern));

                stmt.executeUpdate(String.format("DELETE FROM books WHERE isbn='%s'", pattern));
            } else {
                while (i <= 3 && !isConnected) {
                        System.out.println("Proba " + i);
                        connect();
                        if(isConnected)
                            deleteByAuthorOrIsbn(pattern);
                        i++;

                }
            }

        } catch (Exception e) {

        } finally {
        }
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

    public void searchByAuthorOrIsbn(String pattern) {
        try {
            if (isConnected) {
                this.i=1;
                this.stmt = conn.createStatement();
                this.rs = stmt.executeQuery(String.format("SELECT * FROM books WHERE author='%s'", pattern));
                if (rs.next()) {
                    rs.previous();
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                } else {
                    this.rs = this.stmt.executeQuery(String.format("SELECT * FROM books WHERE isbn='%s'", pattern));
                    while (rs.next())
                        System.out.println(rs.getString("author"));
                }
            }
            else {
                while (i <= 3 && !isConnected) {
                        System.out.println("Proba " + i);
                        connect();
                        if(isConnected) {
                            searchByAuthorOrIsbn(pattern);
                        }
                        i++;
                }
            }
        }
        catch (Exception e) { }

        finally {
        }
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


