import java.util.regex.Matcher;

class MatchTest {
    public static void main(String[] args) {
        Match match = new Match();
//        MatchRecursion match = new MatchRecursion();
        System.out.println(match.match(new char[]{'a', 'a', 'a'}, new char[]{
                'a', 'b', '*', 'a', 'c', '*', 'a'
        }));
        System.out.println(match.match(new char[]{'a', 'a', 'b'}, new char[]{
                'a', '*', 'b'
        }));
        System.out.println(match.match(new char[]{ 'b', 'c'}, new char[]{
                'a', '*', 'b','b'
        }));
        System.out.println(match.match(new char[]{ 'a'}, new char[]{
                'a', 'b','*'
        }));
        System.out.println(match.match(new char[]{ 'a'}, new char[]{
                '.','*'
        }));
        System.out.println(match.match(new char[]{'a','a'}, new char[]{
                'a','*'
        }));
        System.out.println(match.match(new char[]{'a','a','a'}, new char[]{
                'a','*','a'
        }));
        System.out.println(match.match(new char[]{'a','b'}, new char[]{
                '.','*'
        }));
        System.out.println(match.match(new char[]{'b','c','b','b','a','b','a','b'}, new char[]{
                '.','*','a','*','a'
        }));
        System.out.println(match.match(new char[0], new char[]{'.'}));
    }

}