package ext

import org.junit.jupiter.api.extension.*
import java.nio.file.Files
import java.nio.file.Path

class PythonEnvExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        // Get annotation data
        val testMethod = context?.requiredTestMethod
        val testClass = context?.requiredTestClass

        val pythonEnv = testMethod?.getAnnotation(PythonEnv::class.java)
            ?: testClass?.getAnnotation(PythonEnv::class.java)

        val version = pythonEnv?.version ?: "3.8"
        val packages = pythonEnv?.packages ?: arrayOf()

        // Example setup for environment
        println("Setting up Python $version with packages: ${packages.joinToString()}")
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
        // Code to set up the environment, e.g., using virtualenv or similar tools
        println("Creating virtual environment at $envPath for Python $version")
        // Install packages
        packages.forEach { packageName ->
            println("Installing package $packageName in environment $envPath")
        }
    }

    private fun teardownPythonEnvironment(envPath: Path) {
        // Code to tear down the environment
        println("Removing virtual environment at $envPath")
        envPath.toFile().deleteRecursively()
    }
}
