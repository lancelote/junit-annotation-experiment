package dsl

@DslMarker
annotation class PythonDsl

@PythonDsl
data class PythonBuilder(
    var version: String = "3.8",
    var packages: MutableList<String> = mutableListOf()
)

@PythonDsl
data class EnvironmentsBuilder(var pythons: List<PythonBuilder> = mutableListOf()) {
    @PythonDsl
    fun python(init: PythonBuilder.() -> Unit) {
        pythons += PythonBuilder().apply(init)
    }
}

@PythonDsl
abstract class PythonEnvironments(init: EnvironmentsBuilder.() -> Unit) {
    val environments: EnvironmentsBuilder = EnvironmentsBuilder().apply(init)
}
