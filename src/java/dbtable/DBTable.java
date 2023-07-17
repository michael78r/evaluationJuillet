/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtable;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author P14A_77_Michael
 */
public abstract class DBTable {

    public abstract String getSeqName();

    public String toUpper(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public void create() throws Exception {
        Connection con = new Connexion().getConnection();
        String nomTable = getClass().getSimpleName();
        String[] lesAttributs = new String[getClass().getDeclaredFields().length];
        String tousLesAtr = new String();
        String allValues = new String();
        String seqName = getSeqName();

        for (int i = 0; i < lesAttributs.length; i++) {
            lesAttributs[i] = getClass().getDeclaredFields()[i].getName();
            lesAttributs[i] = toUpper(lesAttributs[i]);
            Object attributValue = getClass().getMethod("get" + lesAttributs[i]).invoke(this);
            tousLesAtr += lesAttributs[i];

            if ((attributValue == null && i == 0) || (attributValue instanceof Integer && (int) attributValue == 0) && i == 0) {
                allValues += "concat('" + seqName + "',nextval('seq" + nomTable + "'))";
            } else if (attributValue != null) {
                allValues += "'" + attributValue.toString() + "'";
            } else if (attributValue == null && i != 0) {
                allValues += "null";
            }

            if (i < lesAttributs.length - 1) {
                tousLesAtr += ",";
                allValues += ",";
            }
        }
        String requete = "insert into " + nomTable + " (" + tousLesAtr + ") values (" + allValues + ")";
        System.out.println(requete);
        PreparedStatement stmt = con.prepareStatement(requete);

        stmt.executeUpdate();
        con.close();
    }

    public void delete() throws Exception {
        Connection con = new Connexion().getConnection();
        String req = "delete from " + getClass().getSimpleName() + " where ";
        String[] lesAttributs = new String[getClass().getDeclaredFields().length];

        lesAttributs[0] = getClass().getDeclaredFields()[0].getName();
        lesAttributs[0] = toUpper(lesAttributs[0]);
        Object attributValue = getClass().getMethod("get" + lesAttributs[0]).invoke(this);

        if (attributValue != null) {
            req += lesAttributs[0] + "=";
            req += "'" + attributValue.toString() + "'";
        } else {
            req += lesAttributs[0];
            req += " is null";
        }
        System.out.println(req);
        PreparedStatement stmt = con.prepareStatement(req);
        stmt.executeUpdate();
        con.close();
    }

    /*public void delete(Connection con) throws Exception {
        String req = "delete from " + getClass().getSimpleName() + " where ";
        String[] lesAttributs = new String[getClass().getDeclaredFields().length];

        for (int i = 0; i < lesAttributs.length; i++) {
            lesAttributs[i] = getClass().getDeclaredFields()[i].getName();
            lesAttributs[i] = toUpper(lesAttributs[i]);
            Object attributValue = getClass().getMethod("get" + lesAttributs[i]).invoke(this);

            if (attributValue != null) {
                req += lesAttributs[i] + "=";
                req += "'" + attributValue.toString() + "'";
            } else {
                req += lesAttributs[i];
                req += " is null";
            }
            if (i < lesAttributs.length - 1) {
                req += " or ";
            }
        }
        System.out.println(req);
        PreparedStatement stmt = con.prepareStatement(req);
        stmt.executeUpdate();
    }*/

    public void update(Connection con) throws Exception {
        String req = "update " + getClass().getSimpleName() + " set ";
        String[] attributsName = new String[getClass().getDeclaredFields().length];
        int count = 0;

        for (int i = 0; i < attributsName.length; i++) {
            attributsName[i] = getClass().getDeclaredFields()[i].getName();
            attributsName[i] = toUpper(attributsName[i]);
            Object attributsValues = getClass().getMethod("get" + attributsName[i]).invoke(this);

            if ((attributsValues instanceof String && attributsValues != null) || (attributsValues instanceof Integer && (int) attributsValues != 0) || (attributsValues instanceof BigDecimal && attributsValues != new BigDecimal(0))) {
                if (count == 0) {
                    req += attributsName[i] + "=" + "'" + attributsValues.toString() + "'";
                }
                if (count > 0) {
                    req += "," + attributsName[i] + "=" + "'" + attributsValues.toString() + "'";
                }
                count++;
            }
        }

        req += " where ";
        for (int i = 0; i < attributsName.length; i++) {
            attributsName[i] = getClass().getDeclaredFields()[i].getName();
            attributsName[i] = toUpper(attributsName[i]);
            Object attributValue = getClass().getMethod("get" + attributsName[i]).invoke(this);

            if (attributsName[i].equalsIgnoreCase("Id")) {
                req += attributsName[i] + "=";
                req += "'" + attributValue.toString() + "'";
            }
        }
        System.out.println(req);
        PreparedStatement stmt = con.prepareStatement(req);
        stmt.executeUpdate();
        con.close();

    }
    

    public DBTable getDbObject(ResultSet r) throws Exception {
        Object DBTable = getClass().newInstance();

        Field[] attrObj = getClass().getDeclaredFields();
        String[] nomAttr = new String[getClass().getDeclaredFields().length];

        for (int i = 0; i < attrObj.length; i++) {
            nomAttr[i] = attrObj[i].getName();
            Class classType = attrObj[i].getType();
            String allType = classType.getSimpleName();
            Object resultDb = new Object();

            try {
                resultDb = r.getString(nomAttr[i]);
                if (resultDb != null) {
                    if (allType.equalsIgnoreCase("int")) {
                        resultDb = Integer.parseInt((String) resultDb);
                    } else if (allType.equalsIgnoreCase("double")) {
                        resultDb = Double.parseDouble((String) resultDb);
                    } else if (allType.equalsIgnoreCase("float")) {
                        resultDb = Float.parseFloat((String) resultDb);
                    } else if (allType.equalsIgnoreCase("BigDecimal")){
                        resultDb = new BigDecimal((String)resultDb);
                    }
                    else {
                        resultDb = (String) resultDb;
                    }
                    DBTable.getClass().getMethod("set" + toUpper(nomAttr[i]), classType).invoke(DBTable, resultDb);
                }
            } catch (java.sql.SQLException ee) {
            }

        }
        return (DBTable) DBTable;
    }

    public DBTable[] find(String requete, Connection con) throws Exception {
        System.out.print(requete);
        java.sql.Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(requete);
        Vector DBTable = new Vector();
        while (res.next()) {
            DBTable.addElement(getDbObject(res));
        }
        con.close();
        DBTable[] allDb = new DBTable[DBTable.size()];
        for (int i = 0; i < allDb.length; i++) {
            allDb[i] = ((DBTable) DBTable.elementAt(i));
        }
        return allDb;
        
    }
    
}
