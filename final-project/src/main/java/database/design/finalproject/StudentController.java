package database.design.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController()
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    public JdbcTemplate connector;

    @GetMapping("/")
    public List<Student> Get(){
        List<Student> students = this.connector.query("SELECT * FROM Student;", BeanPropertyRowMapper.newInstance(Student.class));
        return students;
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") int id){
        this.connector.execute("DELETE FROM Student WHERE Id = " + id);
    }
}
