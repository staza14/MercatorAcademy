package Week2CodeAlongs

class Calculator {

    // putting ??? after the '=' means that its not implemented yet. Scala knows this and it wont cause problems
    // Them we can go write tests before we develop

    // Now go to src/test/scala
    def add(x:Int, y:Int): Int = {
        x + y
    }

    def multiply(x:Int, y:Int):Int = {
        x * y
    }

    def subtract(x:Int, y:Int) = {
        x - y
    }

    def divide(x:Int, y:Int) = {
        x / y
    }
}
