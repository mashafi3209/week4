package sample;

import java.sql.*;


public class Databasemanager extends Main {
    String NameF;
    int result;



    private Connection con = null;

    public Databasemanager() throws SQLException {
        con = DriverManager.getConnection("jdbc:h2:C:\\Users\\shafi\\IdeaProjects\\week4\\libs\\productDB");
    }

    public void insertProd(String iQuery, String[] insertValues) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(iQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setString(2, insertValues[1]);
        pstmt.executeUpdate();
    }

    public void selectAll() {
        ResultSet rs = null;
        String NameF;
        int result;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee where uid = 830;");

            while(rs.next()) {

                result = rs.getInt("uid");
                NameF = rs.getString("name");
                System.out.printf("%s",NameF);

                System.out.printf("\n%s",result);
                this.NameF = NameF;
                this.result = result;







            }

        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }
    public String getNameF(){
        return NameF;
    }
    public int getResult(){
        return result;
    }




    public void closeCon() {
        try {
            con.close();
        } catch (SQLException e) {
            sqlExceptionHandler(e);
        }
    }

    public void sqlExceptionHandler(SQLException error) {
        // add logging, could make into a wrapper function
        System.out.println("Standard Failure: " + error.getMessage());
    }
}
