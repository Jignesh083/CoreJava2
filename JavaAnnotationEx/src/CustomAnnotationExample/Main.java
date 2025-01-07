package CustomAnnotationExample;

@MyAnno
public class Main {
    public static void main(String[] args) {
        Demo d = new Demo();
        Class result = d.getClass();
        System.out.println(result.getName());
        MyAnno an = (MyAnno) result.getAnnotation(MyAnno.class);
        System.out.println(an.myValue());
        System.out.println(an.name());
        System.out.println(an.city());

    }
}