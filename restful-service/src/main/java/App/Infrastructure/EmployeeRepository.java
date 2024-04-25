package App.Infrastructure;

import App.Domain.Employee;
import App.Domain.IEmployeeRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO UNIVERSITY.EMPLOYEE VALUES ('" + employee.getSsn() + "', '" + employee.getName() + "', '" + employee.getDateOfBirth() + "');";
        this.databaseConnection.execute(sql);
        return employee;
    }

    @Override
    public int update(String id, Employee employee) {
        String sql = "UPDATE UNIVERSITY.EMPLOYEE SET ssn = '" + employee.getSsn() + "', name = '" + employee.getName() + "', dateofbirth = '" + employee.getDateOfBirth() + "' WHERE ssn = '" + id + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM UNIVERSITY.EMPLOYEE WHERE Ssn = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Employee> get(String id){
        String sql = "SELECT * FROM UNIVERSITY.EMPLOYEE WHERE Ssn = " + id + ";";
        List<Employee> employees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public List<Employee> get() {
        String sql = "SELECT * FROM UNIVERSITY.EMPLOYEE;";
        List<Employee> employees = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }
}
