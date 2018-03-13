public class Test {
    public static void main(String[] args) {
        long phoneNum = 123456789;
        System.out.println(String.valueOf(phoneNum).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));

    }
}
