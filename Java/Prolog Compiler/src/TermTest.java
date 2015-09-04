public class TermTest {

    public static void main(String[] args) {
        Variable x = new Variable("X");
        Variable y = new Variable("Y");
        Term c = new FunApp(new Symbol("c"));
        Term f = new FunApp(new Symbol("f"), new Term[]{x, y});
        Term g = new FunApp(new Symbol("g"), new Term[]{f, x, y, c});
        Trs.assertToStringEquals(
                "Testing Variable.toString().",
                "X",
                x.toString());
        Trs.assertToStringEquals(
                "Testing FunApp.toString() for constant.",
                "c",
                c.toString());
        Trs.assertToStringEquals(
                "Testing FunApp.toString() for simple function application.",
                "f(X, Y)",
                f.toString());
        Trs.assertToStringEquals(
                "Testing FunApp.toString() for complex function application.",
                "g(f(X, Y), X, Y, c)",
                g.toString());
    }

}
