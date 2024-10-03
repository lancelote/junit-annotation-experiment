import ext.PythonEnv
import org.junit.jupiter.api.Test

class MethodDecoratedTests {

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

    @Test
    fun testWithDefaultEnv() {
        // Test with default environment
    }
}


@PythonEnv(version = "3.12", packages = ["tensorflow", "pytest"])
class ClassDecoratedTests {
    @Test
    fun testFirst() {}

    @Test
    fun testSecond() {}
}
