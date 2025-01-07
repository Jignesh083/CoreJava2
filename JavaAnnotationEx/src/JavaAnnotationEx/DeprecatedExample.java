package JavaAnnotationEx;



class OldClass{
    @Deprecated
    public void oldMethod(){
        System.out.println("This is an old Method.");
    }
}


public class DeprecatedExample {
    public static void main(String[] args) {
        OldClass oldClass = new OldClass();
        oldClass.oldMethod(); // Compiler warning: 'oldMethod' is deprecated
    }
}
