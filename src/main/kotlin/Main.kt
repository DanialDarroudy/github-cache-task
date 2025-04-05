import microkernel.dependencyInjection.DependencyProvider
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val starter = DependencyProvider.starter
    starter.startProgram()
    kotlin.system.exitProcess(0)
}