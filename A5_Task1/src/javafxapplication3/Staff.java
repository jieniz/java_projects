/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

/**
 * Class Staff connects to the Staff table in EmployeeDB embedded derby database
 * and operates the table, such as insert data, display by order, etc.
 *
 * @author jieni
 */
public class Staff {

    /**
     * database driver
     */
    public final String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    /**
     * database url
     */
    public final String url = "jdbc:derby:EmployeeDB;create=true";

    /**
     * database connection
     */
    public Connection conn = null;

    /**
     * database statement
     */
    public Statement stmt = null;

    /**
     * database result set
     */
    public ResultSet rs = null;

    /**
     * initialize and connect to the database
     */
    public void init() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * close the connection to database
     */
    public void close() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * display the Staff table from EmployeeDB database
     *
     * @return all records from Staff table
     */
    public String display() {
        String s = "";
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");//pass all values in Staff table to rs resultset
            Formatter formatter = new Formatter();
            s = s + formatter.format("%-5s %-12s %-12s %-12s %7s %5s\n", "No.", "First Name", "Last Name", "Position", "Salary", "Age");
            int i = 1;
            while (rs.next()) {
                s = "" + formatter.format("%-7s %-12s %-12s %-12s %7d %5d\n", i++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));//store the values in the String
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    /**
     * take input as one row of Staff table and insert the values to Staff table
     *
     * @param fname first name
     * @param lname last name
     * @param position position
     * @param salary salary, integer
     * @param age age, integer
     */
    public void enterData(String fname, String lname, String position, int salary, int age) {

        PreparedStatement pstmt;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");
            pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO STAFF VALUES (?,?,?,?,?)");//insert data into Staff
            pstmt.setString(1, fname);//set the value of first column
            pstmt.setString(2, lname);
            pstmt.setString(3, position);
            pstmt.setInt(4, salary);
            pstmt.setInt(5, age);
            int i = pstmt.executeUpdate();//execute
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * display the Staff table ordered by Position
     *
     * @return staff members by position
     */
    public String displayByPosition() {
        String s = "";
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY POSITION");//order by position
            int i = 1;
            Formatter formatter = new Formatter();
            s = s + formatter.format("%-5s %-12s %-12s %-15s %7s %5s\n", "No.", "Position", "First Name", "Last Name", "Salary", "Age");
            while (rs.next()) {
                s = "" + formatter.format("%-5d %-12s %-12s %-15s %7d %5d\n", i++, rs.getString(3), rs.getString(1), rs.getString(2), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    /**
     * output staff members earning the highest salaries
     *
     * @return staff members with highest salaries
     */
    public String printMaxSalary() {
        String s = "Staff earning the HIGHEST salaries\n\n";

        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY SALARY DESC");//ordered by salary, decrease
            rs.next();
            s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
            int max = rs.getInt(4);
            while (rs.next() && max == rs.getInt(4)) {
                s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    /**
     * output staff members earning the least salaries
     *
     * @return staff members with least salaries
     */
    public String printMinSalary() {
        String s = "Staff earning the LEAST salaries\n\n";
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY SALARY");//ordered by salary
            rs.next();
            s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
            int max = rs.getInt(4);
            while (rs.next() && max == rs.getInt(4)) {
                s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    /**
     * output staff members earning above average salaries
     *
     * @return staff members with above average salaries
     */
    public String printAveSalary() {
        String s = "Staff earning the ABOVE AVERAGE salaries\n\n";
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY SALARY");
            int sum = 0;
            int i = 0;
            while (rs.next()) {
                sum = sum + rs.getInt(4);
                i++;
            }
            int ave = sum / i;//calculate the average salary

            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY SALARY DESC");

            while (rs.next() && ave <= rs.getInt(4)) {
                s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
                //store the staff members if their salaries are higher than average salary
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }

    /**
     * output staff members earning salaries above $55000
     *
     * @return staff members with salaries higher than $ 55000
     */
    public String printAboveSalary() {

        String s = "Staff earning MORE THAN $55000 salaries\n\n";
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF ORDER BY SALARY DESC");

            while (rs.next() && 55000 <= rs.getInt(4)) {
                s = s + rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + ", Salary " + rs.getInt(4) + ", Age " + rs.getInt(5) + "\n";
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;

    }

    /**
     * create the database and staff table, insert original data to Staff table
     */
    public void createDB() {
        try {
            stmt.execute("create table Staff (Firstname varchar(20), Lastname varchar(20), Position varchar(20), Salary integer, Age integer)");//create Staff table
            stmt.execute("INSERT INTO STAFF VALUES ('Woman', 'Wonder', 'Engineer', 51494, 42)");//insert data
            stmt.execute("INSERT INTO STAFF VALUES ('Python', 'monty', 'Clerk', 70653, 22)");
            stmt.execute("INSERT INTO STAFF VALUES ('Kent', 'Clark', 'Cook', 62194, 31)");
            stmt.execute("INSERT INTO STAFF VALUES ('Doctor', 'Strange', 'Technician', 81245, 56)");
            stmt.execute("INSERT INTO STAFF VALUES ('Simpson', 'Homer', 'Mechanic', 70003, 34)");
            stmt.execute("INSERT INTO STAFF VALUES ('Granger', 'Hermione', 'Doctor', 184247, 48)");

            stmt.execute("INSERT INTO STAFF VALUES('Parks','Hamilton','Mechanic',127098,56),('Wolf','Felix','Engineer',171229,27),('Floyd','Glenna','Cook',196708,48),('Blair','Denise','Mechanic',184711,31),('Valencia','Kaye','Cook',174910,50),('Madden','Harper','Doctor',177839,40),('Albert','Tamekah','Doctor',178506,20),('Hyde','Garth','Technician',101644,31),('Vance','Charlotte','Engineer',182890,30),('May','Rama','Doctor',90589,59)");
            stmt.execute("INSERT INTO STAFF VALUES('Fleming','Cadman','Engineer',184508,30),('Byers','Michelle','Mechanic',104874,41),('Bailey','Colby','Clerk',153262,24),('Dean','Demetria','Technician',169296,33),('Jarvis','Wyoming','Clerk',63893,24),('Moody','Chancellor','Clerk',85025,56),('Harrington','Keaton','Engineer',75637,41),('Watts','Zephania','Mechanic',155041,58),('Gardner','Josiah','Cook',94955,47),('Callahan','Gavin','Clerk',144222,43)");
            stmt.execute("INSERT INTO STAFF VALUES('Waller','Patience','Engineer',190098,26),('Bernard','Adam','Clerk',188422,29),('Adams','Illana','Clerk',166998,28),('Bass','Samson','Clerk',168980,40),('Cunningham','Clark','Doctor',129179,58),('Pena','Peter','Doctor',114007,47),('Hancock','Jayme','Clerk',198460,47),('Ewing','Zelda','Cook',72580,39),('Farley','Kenneth','Cook',107992,26),('Lucas','Thomas','Mechanic',68875,23)");
            stmt.execute("INSERT INTO STAFF VALUES('Pennington','Mariam','Clerk',66022,40),('Macdonald','Joshua','Mechanic',148455,38),('Middleton','Ella','Mechanic',74271,47),('Richards','Wayne','Clerk',66613,48),('Buckley','Mallory','Mechanic',68859,26),('Gomez','Brynn','Engineer',127615,46),('Kramer','Evan','Clerk',71669,38),('Bender','Callie','Technician',107256,35),('Ball','Alyssa','Engineer',180666,55),('Morton','Jesse','Technician',129390,44)");
            stmt.execute("INSERT INTO STAFF VALUES('Snyder','Brody','Doctor',142439,35),('Weeks','Jamalia','Technician',69502,32),('Boone','Reese','Technician',115288,33),('Pratt','Chantale','Engineer',192231,36),('Ferguson','Mechelle','Doctor',85009,54),('Kennedy','Julie','Doctor',62325,33),('Mathis','Bevis','Clerk',91140,30),('Wheeler','Keefe','Mechanic',117387,43),('Palmer','Dahlia','Cook',140081,36),('Ratliff','Kelly','Engineer',191779,34)");
            stmt.execute("INSERT INTO STAFF VALUES('Chase','Tanner','Technician',52501,30),('Strong','Vielka','Engineer',76281,30),('Anthony','Wendy','Doctor',199245,47),('Oconnor','Amena','Mechanic',93496,34),('Chandler','Samson','Mechanic',56695,52),('Hunt','Maya','Clerk',141102,26),('Long','Carol','Engineer',150295,34),('Russo','Jameson','Doctor',140268,55),('Pierce','Ashely','Doctor',65245,21),('Mullins','Mari','Clerk',67419,50)");
            stmt.execute("INSERT INTO STAFF VALUES('Mcneil','Quynn','Engineer',182044,48),('Mccullough','Theodore','Cook',175802,25),('Franco','Ayanna','Engineer',122269,44),('Summers','Kiayada','Cook',113107,21),('Patrick','Farrah','Doctor',138817,39),('Snyder','Amethyst','Doctor',136987,38),('Dale','Kellie','Clerk',98300,60),('Kane','Nissim','Engineer',123371,45),('Ortiz','Jarrod','Mechanic',166946,46),('Chavez','Teagan','Technician',153126,35)");
            stmt.execute("INSERT INTO STAFF VALUES('Phelps','Amelia','Cook',84459,53),('Herring','Destiny','Technician',75527,51),('Cooley','Quynn','Doctor',123311,28),('Campos','Camden','Cook',174939,48),('Howe','Amity','Technician',93000,57),('Thompson','Quintessa','Cook',144225,30),('Rodgers','Preston','Mechanic',76025,46),('Vaughan','Odessa','Doctor',116277,55),('Miles','Zoe','Cook',159864,44),('Booker','Jordan','Doctor',103239,48)");
            stmt.execute("INSERT INTO STAFF VALUES('Lancaster','Ulysses','Clerk',164417,36),('Stevenson','Basil','Engineer',92129,40),('Gray','Ezekiel','Technician',78767,33),('Chaney','Jack','Mechanic',85742,25),('Hughes','Ashely','Mechanic',136121,46),('Prince','Nell','Doctor',194327,27),('Rivera','Devin','Cook',87215,42),('Lane','Kyle','Clerk',117196,27),('English','Norman','Cook',90138,32),('Sloan','Dieter','Cook',122397,57)");
            stmt.execute("INSERT INTO STAFF VALUES('Blankenship','Basia','Clerk',81145,28),('Dillard','Keegan','Engineer',180592,47),('Pruitt','Leonard','Technician',116081,23),('Castaneda','Darryl','Cook',156079,37),('Wise','Brynne','Clerk',111644,24),('Doyle','Taylor','Cook',69648,36),('French','Eric','Doctor',147076,41),('Oneil','Jonah','Cook',196681,58),('Goodwin','Britanney','Clerk',114418,31),('Walters','Lewis','Mechanic',156068,56)");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * delete rows with certain value from the Staff table
     */
    public void deleteRow() {
        try {
            stmt.execute("delete from Staff where Age = 30");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * delete the whole table
     */
    public void dropTable() {
        try {
            stmt.execute("DROP TABLE STAFF");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * get the average salary of engineers
     *
     * @return the average salary of engineers
     */
    public int getSalary1() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Engineer".equals(rs.getString(3))) {//if the position is engineer
                    sum = sum + rs.getInt(4);//add it to sum
                    i++;//count the number
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;//avarage salary for engineer
        return ave;
    }

    /**
     * get the average salary of clerks
     *
     * @return the average salary of clerks
     */
    public int getSalary2() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Clerk".equals(rs.getString(3))) {
                    sum = sum + rs.getInt(4);
                    i++;
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;
        return ave;
    }

    /**
     * get the average salary of cooks
     *
     * @return the average salary of cooks
     */
    public int getSalary3() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Cook".equals(rs.getString(3))) {
                    sum = sum + rs.getInt(4);
                    i++;
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;
        return ave;
    }

    /**
     * get the average salary of technicians
     *
     * @return the average salary of technicians
     */
    public int getSalary4() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Technician".equals(rs.getString(3))) {
                    sum = sum + rs.getInt(4);
                    i++;
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;
        return ave;
    }

    /**
     * get the average salary of mechanics
     *
     * @return the average salary of mechanics
     */
    public int getSalary5() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Mechanic".equals(rs.getString(3))) {
                    sum = sum + rs.getInt(4);
                    i++;
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;
        return ave;
    }

    /**
     * get the average salary of doctors
     *
     * @return the average salary of doctors
     */
    public int getSalary6() {
        int sum = 0;
        int i = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM STAFF");

            while (rs.next()) {
                if ("Doctor".equals(rs.getString(3))) {
                    sum = sum + rs.getInt(4);
                    i++;
                }
            }
        } catch (SQLException ex) {
        }
        int ave = sum / i;
        return ave;
    }
}
