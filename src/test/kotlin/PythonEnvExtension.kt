import org.junit.jupiter.api.extension.*
import java.nio.file.Files
import java.nio.file.Path

class PythonEnvExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        // Setup Python environment
        val version = context?.getElement()?.get()?.getAnnotation(PythonEnv::class.java)?.version ?: "3.8"
        val packages = context?.getElement()?.get()?.getAnnotation(PythonEnv::class.java)?.packages ?: arrayOf()
        println("Setting up Python $version with packages: ${packages.joinToString()}")

        // Example setup for environment
        val envPath = Files.createTempDirectory("python-env")
        setupPythonEnvironment(envPath, version, packages)
        context?.getStore(ExtensionContext.Namespace.GLOBAL)?.put("envPath", envPath)
    }

    override fun afterEach(context: ExtensionContext?) {
        // Teardown Python environment
        val envPath = context?.getStore(ExtensionContext.Namespace.GLOBAL)?.get("envPath", Path::class.java)
        envPath?.let { teardownPythonEnvironment(it) }
    }

    private fun setupPythonEnvironment(envPath: Path, version: String, packages: Array<String>) {
        // Code to setup the environment, e.g., using virtualenv or similar tools
        println("Creating virtual environment at $envPath for Python $version")
        // Install packages
        packages.forEach { packageName ->
            println("Installing package $packageName in environment $envPath")
        }
    }

    private fun teardownPythonEnvironment(envPath: Path) {
        // Code to teardown the environment
        println("Removing virtual environment at $envPath")
        envPath.toFile().deleteRecursively()
    }
}
