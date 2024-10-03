package ext

import org.junit.jupiter.api.extension.ExtendWith

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(PythonEnvExtension::class)
annotation class PythonEnv(val version: String, val packages: Array<String>)
