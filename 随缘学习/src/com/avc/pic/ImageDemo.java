package com.avc.pic;

/**
 * @author AmVilCres
 * @desc 
 * @date 2018��1��19��
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDemo {

    // ��ͼƬ�������ݿ�
    public static void readImage2DB() {
        String path = "E:/1.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into photo (id,name,photo)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "lang");
            ps.setBinaryStream(3, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("����ɹ���");
            } else {
                System.out.println("����ʧ�ܣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // ��ȡ���ݿ���ͼƬ
    public static void readDB2Image() {
        String targetPath = "D:/image/1.png";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from photo where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("photo");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //����
    public static void main(String[] args) {
        //readImage2DB();
        readDB2Image();
    }
}