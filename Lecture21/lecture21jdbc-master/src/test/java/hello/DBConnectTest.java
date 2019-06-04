package hello;

import db.Postgres;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static utils.ResourseLoader.getResourceAsString;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBConnectTest {
    private Postgres postgres;

    @BeforeAll
    void init(){
        postgres = new Postgres();
        postgres.openConnection();
    }

    @Test
    void openConnect(){
        assertThat(postgres.isOpen()).isTrue();
    }

    @Test
    void createDb(){
        int result = postgres.executeUpdate("CREATE TABLE customers (\n" +
                "                             age INTEGER NOT NULL,\n" +
                "                             first_name TEXT,\n" +
                "                             second_name INTEGER not null\n" +
                ");\n");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void deleteDb(){
        int result = postgres.executeUpdate("DROP TABLE customers");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void insertIntoDb(){
        int result = postgres.executeUpdate("INSERT INTO customers VALUES (33, 'Bruce', 'Wayne');");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void selectFromDb() throws Exception{
        ResultSet result = postgres.execute("SELECT * FROM customers;");
        result.next();
        assertThat(result.getInt(1)).isEqualTo(18);
        assertThat(result.getString("first_name")).isEqualTo("Peter");
    }

    @Test
    void selectFromDbNew(){
        List<Map<String, String>> results = postgres.executeNew("SELECT * FROM customers;");
        assertThat(results.get(0).get("age")).isEqualTo("18");
        assertThat(results.get(0).get("first_name")).isEqualTo("Peter");
    }

    @ParameterizedTest
    @MethodSource("ageNameProvider")
    void testAge(String name, int age) throws Exception{
        ResultSet result = postgres.execute(String.format("SELECT age FROM customers where first_name = '%s'", name));
        result.next();
        int ageActual = result.getInt("age");
        assertThat(ageActual).isEqualTo(age);
    }

    static Stream<Arguments> ageNameProvider() {
        return Stream.of(
                arguments("Peter", "Parker", 18),
                arguments("Ahmed", "Ahmed", 19)
        );
    }

    @ParameterizedTest
    @MethodSource("ageNameProvider")
    void testPreparedStatement(String name, int age) throws Exception{
        ResultSet result = postgres.executeWithParams("SELECT age FROM customers where first_name = ?", name);
        result.next();
        int ageActual = result.getInt("age");
        assertThat(ageActual).isEqualTo(age);
    }

    @ParameterizedTest
    @MethodSource("ageNameProvider")
    void testPreparedStatementTwoParams(String name, String second_name, int age) throws Exception{
        ResultSet result = postgres.executeWithParams("SELECT age FROM customers where first_name = ? and second_name = ?", name, second_name);
        result.next();
        int ageActual = result.getInt("age");
        assertThat(ageActual).isEqualTo(age);
    }

    @Test
    void script(){
        postgres.executeScript(getResourceAsString("/createTable.sql"));
    }

    @AfterAll
    void close(){
        postgres.closeConnection();
    }
}