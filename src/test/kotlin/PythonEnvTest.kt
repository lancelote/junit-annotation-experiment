import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PythonEnvExtension::class)
class MyTests {

    @Test
    @PythonEnv(version = "3.8", packages = ["numpy", "pandas"])
    fun testWithPython38() {
        // Test code that requires Python 3.8 with numpy and pandas
    }

    @Test
    @PythonEnv(version = "3.9", packages = ["requests"])
    fun testWithPython39() {
        // Test code that requires Python 3.9 with requests
    }
}
