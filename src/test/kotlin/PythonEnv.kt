@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class PythonEnv(val version: String, val packages: Array<String>)
