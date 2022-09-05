public class First{
        private String name;
        private int age;



       public First(){
                name = "George";
                age = 45;
        } //default constructor



       public void sayHello(){
                System.out.println("Welcome "+name+" age = "+age);
                name = "Jason";
                System.out.println("Welcome "+name);
        }



       public void sayBye(){
                name = "Carla";
                System.out.println("goodbye "+name);
        }



       public static void main(String[] args){
                First first = new First();
                first.sayHello();
                first.sayBye();
        }
}
