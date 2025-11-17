# Java-JDBC-Inheritance

Here is a **clean, professional, marks-scoring README.md** for your practical submission.

You can paste this directly into your GitHub repo → `README.md`
(Everything is formatted for maximum clarity.)

---

# 📌 Java JDBC – Multilevel Inheritance Project

This project demonstrates **Multilevel Inheritance in Java** combined with **JDBC Database Connectivity** using MySQL.
It shows how to fetch employee data from a database and represent it using an inheritance hierarchy:

```
Person → Employee → Manager
```

---

## 🧱 **Project Structure**

```
Java-JDBC-Inheritance/
│── src/
│   ├── Person.java
│   ├── Employee.java
│   ├── Manager.java
│   └── Main.java
│
│── lib/
│   └── mysql-connector-java-5.1.49.jar
│
│── setup.sql
│── run.sh
│── README.md
```

---

# 🧬 **OOP Concept: Multilevel Inheritance**

The program uses three classes:

### **1️⃣ Person (Base Class)**

* Stores name
* Has method `showPerson()`

### **2️⃣ Employee (Derived from Person)**

* Adds `id` and `salary`
* Method: `showEmployee()`

### **3️⃣ Manager (Derived from Employee)**

* Adds `department`
* Method: `display()` prints all details

Thus forming the multilevel chain:

```
Person → Employee → Manager
```

---

# 🗄️ **Database Details**

### Database name: `testdb`

### Table: `employee`

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE
);
```

### Sample Data (inserted via `setup.sql`)

```sql
INSERT INTO employee VALUES (1, 'Jahnvi', 55000);
INSERT INTO employee VALUES (2, 'Aarav', 60000);
```

---

# ⚙️ **How the Project Works**

1. Java loads MySQL JDBC driver
2. Connects to MySQL database
3. Fetches employees from `employee` table
4. Creates a `Manager` object for each record
5. Prints full multilevel-inherited details

---

# 🚀 **How to Run the Project (For Evaluators)**

> Works on GitHub Codespaces / Linux / Windows / macOS

### **STEP 1 — Start MySQL**

```bash
sudo service mysql start
```

### **STEP 2 — Run setup.sql (only first time)**

```bash
sudo mysql < setup.sql
```

### **STEP 3 — Compile Java**

```bash
javac -cp ".:lib/mysql-connector-java-5.1.49.jar" src/*.java
```

### **STEP 4 — Run Program**

```bash
java -cp ".:src:lib/mysql-connector-java-5.1.49.jar" Main
```

### ✔ Expected Output:

```
Employee Data:
-----------------------------------
Name: Jahnvi
ID: 1
Salary: 55000.0
Department: Software Department
-----------------------------------
Name: Aarav
ID: 2
Salary: 60000.0
Department: Software Department
-----------------------------------
```

---

# 📜 **Main Class Code**

```java
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "javauser",
                    "mypassword"
            );

            String sql = "SELECT id, name, salary FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("Employee Data:");
            System.out.println("-----------------------------------");

            while (rs.next()) {
                Manager mgr = new Manager(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        "Software Department"
                );

                mgr.display();
                System.out.println("-----------------------------------");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

# 📂 **Automation Script (run.sh)**

```bash
#!/bin/bash
echo "⬆️ Compiling Java files..."
javac -cp ".:lib/mysql-connector-java-5.1.49.jar" src/*.java

echo "▶️ Running program..."
java -cp ".:src:lib/mysql-connector-java-5.1.49.jar" Main
```

Run with:

```bash
chmod +x run.sh
./run.sh
```

---

# 🏁 **Conclusion**

This project successfully demonstrates:

✔ Multilevel inheritance in Java
✔ JDBC connectivity
✔ Fetching & displaying database records
✔ Clean folder structure suitable for academic submission
