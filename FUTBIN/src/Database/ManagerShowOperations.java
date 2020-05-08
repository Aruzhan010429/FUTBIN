package Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import Data.ManagerData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ManagerShowOperations implements DataBaseOP {

    public ManagerData fetchManager(String key)
    {
        Connection con = null;
        Statement stmt1 = null;
        ResultSet rs = null;
        ManagerData bo = new ManagerData();

        try
        {


            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "select ManagerID, ManagerSurname, ManagerName,ManagerSurname  from managers "
                    + "where ManagerID = '"+key+"' and rownum = 1";

            rs = stmt1.executeQuery(strQuery1);

            while(rs.next())
            {
                bo.setManagerID(rs.getString(1));
                bo.setManagerSurname(rs.getString(2));
                bo.setManagerName(rs.getString(3));
                bo.setManagerSalary(rs.getString(4));

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                rs.close();
                stmt1.close();
                con.close();
            }
            catch(Exception e)
            {

            }
        }



        return bo;
    }


    @Override
    public String addOperation(Object obj) {

        Connection con = null;
        Statement stmt1 = null;
        String strStatus = "error";

        try
        {
            ManagerData bo = (ManagerData)obj;

            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "insert into managers (ManagerID, ManagerSurname, ManagerName, ManagerSalary) values "
                    + "('"+bo.getManagerID()+"','"+bo.getManagerSurname()+"','"+bo.getManagerName()+"','"+bo.getManagerSalary()  +"')";

            stmt1.executeQuery(strQuery1);

            con.commit();

            strStatus = "success";
        }
        catch(Exception e)
        {
            try {
                con.rollback();
            } catch (SQLException e1) {

            }
            e.printStackTrace();
        }
        finally
        {
            try{
                stmt1.close();
                con.close();
            }
            catch(Exception e)
            {

            }
        }
        return strStatus;
    }

    @Override
    public ObservableList<Map> viewOperation() {

        ObservableList<Map> allData = FXCollections.observableArrayList();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            String strQuery = "select ManagerID, ManagerSurname, ManagerName, ManagerSalary from managers order by ManagerID";
            con = DBManager.connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(strQuery);

            while(rs.next())
            {
                Map<String, String> dataRow = new HashMap<>();
                dataRow.put("ManagerId", rs.getString(1));
                dataRow.put("ManagerSurname", rs.getString(2));
                dataRow.put("ManagerName", rs.getString(3));
                dataRow.put("ManagerSalary", rs.getString(4));

                allData.add(dataRow);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                rs.close();
                stmt.close();
                con.close();
            }
            catch(Exception e)
            {
            }
        }


        return allData;
    }

    @Override
    public String deleteOperation(String key) {

        Connection con = null;
        Statement stmt1 = null;

        String strStatus = "fail";

        try
        {
            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "DELETE FROM managers WHERE ManagerID = '"+key+"'";
            stmt1.executeQuery(strQuery1);

            con.commit();

            strStatus = "success";
        }
        catch(Exception e)
        {

            e.printStackTrace();
        }
        finally
        {
            try
            {
                stmt1.close();
                con.close();
            }catch(Exception e)
            {
            }
        }
        return strStatus;
    }

    @Override
    public String updateOperation(Object obj) {
        Connection con = null;
        Statement stmt1 = null;
        String strStatus = "error";

        try
        {
            ManagerData bo = (ManagerData)obj;

            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "UPDATE managers SET ManagerSurname = '"+bo.getManagerSurname()+"' , ManagerName = '"+bo.getManagerName()+"' , ManagerSalary = '"+bo.getManagerSalary()  +"' "
                    + "WHERE ManagerID = '"+bo.getManagerID()+"'";

            stmt1.executeQuery(strQuery1);

            con.commit();

            strStatus = "success";
        }
        catch(Exception e)
        {
            try {
                con.rollback();
            } catch (SQLException e1) {

            }
            e.printStackTrace();
        }
        finally
        {
            try{
                stmt1.close();
                con.close();
            }
            catch(Exception e)
            {

            }
        }
        return strStatus;
    }

}
