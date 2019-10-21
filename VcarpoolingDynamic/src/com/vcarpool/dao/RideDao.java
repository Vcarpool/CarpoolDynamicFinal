package com.vcarpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vcarpool.connection.ConnectionUtil;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.Ride;
import com.vcarpool.model.User;
import com.vcarpool.services.RideService;
import com.vcarpool.services.UserServiceImpl;

public class RideDao implements RideService {
	Logger log = Logger.getLogger(RideDao.class.getName());

	public RideDao() {
		
	}

	@Override
	public int insert(Ride r) throws VCarpoolException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = 0;
		String query = "insert into Ride(rideId, rideStatus, riderId, providerId) values(?,?,?,?)";
		try {
			pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, r.getRideId());
			pst.setString(2, r.getStatus());
			pst.setInt(3, r.getRider().getUserId());
			pst.setInt(4, r.getProvider().getUserId());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next())
				key = rs.getInt(1);
		} catch (SQLException e) {
			log.error("error-dao", e);
			throw new VCarpoolException("exception-dao");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

		return key;


	}

	@Override
	public int update(Ride r, String feild, String value) throws VCarpoolException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = 0;
		String query = "update ride set " + feild + "=? where rideId= ?";

		System.out.println(query);
		try {
			pst = con.prepareStatement(query);

			pst.setString(1, value);
			pst.setInt(2, r.getRideId());
			key = pst.executeUpdate();
		} catch (SQLException e) {
			log.error("update error- dao", e);
			throw new VCarpoolException("error-dao-update");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

		return key;

	}

	@Override
	public Ride delet(Ride r) throws VCarpoolException {

		Ride temp = r;

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		int key = 0;
		String query = "delete from ride where rideId=?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, r.getRideId());
			key = pst.executeUpdate();
			if (key > 0)
				return temp;
			else
				return null;
		} catch (SQLException e) {
			log.error("deletion error- dao", e);
			throw new VCarpoolException("error in deleting data");
		} finally {

			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

	}

	@Override
	public List<Ride> showRides() throws VCarpoolException {
		UserServiceImpl ser = new UserServiceImpl();
		ArrayList<Ride> arr = new ArrayList<Ride>();
		ResultSet rs = null;
		Connection con = ConnectionUtil.getConnection();
		Statement st = null;
		String query = "select * from ride";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs == null)
				return null;
			else {
				Ride user = null;
				while (rs.next()) {
					user = new Ride();
					user.setRideId(rs.getInt("rideId"));
					user.setStatus(rs.getString("rideStatus"));

					User rider = ser.getUser(rs.getInt("riderId"));
					user.setRider(rider);
					User provider = ser.getUser(rs.getInt("providerId"));
					user.setProvider(provider);

					arr.add(user);
					user = null;
				}
			}
		} catch (SQLException e) {
			log.error("selection error- dao", e);
			throw new VCarpoolException("error in selecting data");
		}

		return arr;


		
	}

	
}
