import dsl.PythonEnvironments

object Environments : PythonEnvironments({
    python {
        version = "3.8"
        packages = mutableListOf("numpy", "pandas")
    }
    python {
        version = "3.9"
        packages = mutableListOf("pandas", "pytest")
    }
})
