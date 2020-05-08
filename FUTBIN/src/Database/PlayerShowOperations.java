package Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import Data.PlayerData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerShowOperations implements DataBaseOP{

    public PlayerData fetchPlayer(String key)
    {
        Connection con = null;
        Statement stmt1 = null;
        ResultSet rs = null;
        PlayerData bo = new PlayerData();

        try
        {
            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "select PlayerID, PlayerSurname, PlayerName,PlayerSalary from players "
                    + "where PlayerID = '"+key+"' and rownum = 1";

            rs = stmt1.executeQuery(strQuery1);

            while(rs.next())
            {
                bo.setPlayerID(rs.getString(1));
                bo.setPlayerSurname(rs.getString(2));
                bo.setPlayerName(rs.getString(3));
                bo.setPlayerSalary(rs.getString(4));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        { try{
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
           PlayerData bo = (PlayerData) obj;

            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "insert into players (PlayerID, PlayerSurname, PlayerName,PlayerSalary) values "
                    + "('"+bo.getPlayerID()+"','"+bo.getPlayerSurname()+"','"+bo.getPlayerName()+"','"+bo.getPlayerSalary()  +"')";

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
            String strQuery = "select PlayerID, PlayerSurname, PlayerName,PlayerSalary from players order by PlayerID";
            con = DBManager.connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(strQuery);

            while(rs.next())
            {
                Map<String, String> dataRow = new HashMap<>();
                dataRow.put("PlayerID", rs.getString(1));
                dataRow.put("PlayerSurname", rs.getString(2));
                dataRow.put("PlayerName", rs.getString(3));
                dataRow.put("PlayerSalary", rs.getString(4));

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
        Statement stmt = null;

        String strStatus = "fail";

        try
        {
            con = DBManager.connection;

            stmt =  con.createStatement();
            String strQuery = "DELETE FROM players WHERE PlayerID  = '"+key+"'";
            stmt.executeQuery(strQuery);

            con.commit();

            strStatus = "success";
        }
        catch(Exception e)
        {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        finally
        {
            try
            {
                stmt.close();
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
            PlayerData bo = (PlayerData) obj;

            con = DBManager.connection;

            stmt1 = con.createStatement();
            String strQuery1 = "UPDATE players SET PlayerSurname = '"+bo.getPlayerName()+"', PlayerName = '"+bo.getPlayerName()+"' , PlayerSalary = '"+bo.getPlayerSalary()  +"' "
                    + " where PlayerID = '"+bo.getPlayerID()+"'";

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
