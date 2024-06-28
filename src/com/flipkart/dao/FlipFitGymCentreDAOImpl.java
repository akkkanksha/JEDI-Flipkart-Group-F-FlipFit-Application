package com.flipkart.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.constant.DBConstants;
import com.flipkart.bean.FlipFitSlots;

public class FlipFitGymCentreDAOImpl {
    Random rand = new Random();

//    public static void main(String[] args) {
//        FlipFitGymCentre FFGC = new FlipFitGymCentre();
//
//        //test part
//        FFGC.setOwnerID(344);
//        FFGC.setApproved(true);
//        FFGC.setCapacity(45);
//        FFGC.setCity("Pune");
//        FFGC.setState("MH");
//        FFGC.setPincode("411027");
//
//        FlipFitGymCentreDAOImpl FFGCDAO = new FlipFitGymCentreDAOImpl();
//
//
//        FFGCDAO.createGymCentre(FFGC);
//        FFGC.setPincode("560066");
//        FFGCDAO.updateGymCentre(FFGC);
//        FFGC.setCentreID(61);
//        FFGCDAO.deleteGymCentre(FFGC);
//        ArrayList<FlipFitGymCentre> arr = FFGCDAO.viewCentres("Pune");
//        for(FlipFitGymCentre ffgc : arr){
//            System.out.println(ffgc.getCentreID());
//        }
//        FFGC.setCentreID(187);
//        ArrayList<FlipFitSlots> ffsarr = FFGCDAO.viewAvailableSlots(FFGC);
//        for(FlipFitSlots fs : ffsarr){
//            System.out.println(fs.getSlotId());
//        }
//    }
    public void createGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO GymCentre VALUES (?, ?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            FFGC.setCentreID(rand.nextInt(1000));
            stmt.setInt(1, FFGC.getCentreID());
            stmt.setInt(2, FFGC.getOwnerID());
            stmt.setInt(3,FFGC.getCapacity());
            stmt.setBoolean(4, FFGC.isApproved());
            stmt.setString(5, FFGC.getCity());
            stmt.setString(6, FFGC.getState());
            stmt.setString(7, FFGC.getPincode());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre added");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    };

    public void updateGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE GymCentre SET ownerID = ?, capacity = ?, approved = ?, city = ?, state = ?, pincode = ? WHERE centreID = ?"));


            stmt.setInt(1, FFGC.getOwnerID());
            stmt.setInt(2,FFGC.getCapacity());
            stmt.setBoolean(3, FFGC.isApproved());
            stmt.setString(4, FFGC.getCity());
            stmt.setString(5, FFGC.getState());
            stmt.setString(6, FFGC.getPincode());
            stmt.setInt(7, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre updated");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    };

    public void deleteGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM GymCentre WHERE centreID=(?)");

            stmt.setInt(1, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println( i + " centre deleted");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    };

    public ArrayList<FlipFitGymCentre> viewCentres(String city){
        ArrayList<FlipFitGymCentre> ffarray = new ArrayList<FlipFitGymCentre>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM GymCentre WHERE city = ?");
            stmt.setString(1, city);

            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                FlipFitGymCentre FFGC = new FlipFitGymCentre();
                FFGC.setCentreID(rs.getInt("centreID"));
                FFGC.setOwnerID(rs.getInt("ownerID"));
                FFGC.setCapacity(rs.getInt("capacity"));
                FFGC.setApproved(rs.getBoolean("approved"));
                FFGC.setCity(rs.getString("city"));
                FFGC.setState(rs.getString("state"));
                FFGC.setPincode(rs.getString("pincode"));

                ffarray.add(FFGC);
            };


            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return ffarray;
    }

    public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC){
            ArrayList<FlipFitSlots> ffarray = new ArrayList<FlipFitSlots>();

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE centreID = ? and seatsAvailable > 0");
                stmt.setInt(1, FFGC.getCentreID());

                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    FlipFitSlots FFS = new FlipFitSlots();
                    FFS.setSlotId(rs.getInt("slotID"));
                    FFS.setCentreId(rs.getInt("centreID"));
                    FFS.setSeatsAvailable(rs.getInt("seatsAvailable"));
                    FFS.setSlotTime(rs.getInt("slotTime"));

                    ffarray.add(FFS);
                };


                con.close();
            } catch(Exception e){
                System.out.println(e);
            }
            return ffarray;
    };


}
