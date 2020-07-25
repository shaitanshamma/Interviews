package ru.shamma.lesson4;

import ru.shamma.lesson4.annotations.DBColumn;
import ru.shamma.lesson4.annotations.DBId;
import ru.shamma.lesson4.annotations.DBtable;

import java.lang.reflect.Field;
import java.sql.*;

public class ReflectionRepo<T> {
    PreparedStatement ps;
    Connection connection;
    DbName dbName;

    public T getById(Long id) throws SQLException, IllegalAccessException, ClassNotFoundException {
        connect(dbName.name());
        T obj= (T) new Object();
        Class c = obj.getClass();
        String table = ((DBtable)c.getAnnotation(DBtable.class)).name();
        if(c.isAnnotationPresent(DBId.class)){
            //Long dbId = ((DBId)c.getAnnotation(DBId.class)).id();
            String query ="SELECT * FROM " + table + " WHERE ID =?";
            ps.setLong(1, id);
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery(query);
            Field[] fields = c.getDeclaredFields();
            while (resultSet.next()){
                for(Field f : fields){
                    f.set(obj,resultSet.next());
                }
            }
        }
        return obj;
    }

    public void save(T t) throws SQLException, IllegalAccessException {
        Class c = t.getClass();
        String table = ((DBtable)c.getAnnotation(DBtable.class)).name();
        String query ="INSERT INTO " + table + " (";
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DBId.class)) {
                query += f.getName() + ", ";
            }
            if (f.isAnnotationPresent(DBColumn.class)) {
                query += f.getName() + ", ";
            }
        }
        query = query.substring(0, query.length() - 2);
     //   query += ");";
        query += " ) VALUES ( ";
        for (Field f : fields) {
            if (f.isAnnotationPresent(DBId.class)) {
                query += "?, ";
            }
            if (f.isAnnotationPresent(DBColumn.class)) {
                query += "?, ";
            }
        }
        query = query.substring(0, query.length() - 2);
        query += ");";
        ps = connection.prepareStatement(query);
        int cout = 1;
        for (Field f : fields) {
            if (f.isAnnotationPresent(DBId.class)) {
                ps.setObject(cout, f.get(t));
                cout++;
            }
            if (f.isAnnotationPresent(DBColumn.class)) {
                ps.setObject(cout, f.get(t));
                cout++;
            }
        }
        ps.executeQuery(query);
        disconnect();
    }
    public void connect(String dbName) throws ClassNotFoundException, SQLException {
        if (dbName.equals("MYSQL")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "user", "pass");
        }
        if (dbName.equals("PosgreSQL")){
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test_db", "user", "pass");
        }
    }
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException {
        DbName name = DbName.MYSQL;
        ReflectionRepo<Test> reflectionRepo = new ReflectionRepo<>();
        Test test = new Test(1,"2");
        reflectionRepo.save(test);
        reflectionRepo.connect(name.name());
    }
}
