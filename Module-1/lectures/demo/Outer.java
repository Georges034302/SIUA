
    public class Outer{
        private String type = "Outer";
    
        public void show(){
            System.out.println(type);
        }
    
       static class Inner{
            private String type = "Innner (public)";
    
            public static void showInner(){
                System.out.print("Static Inner Class ");                
            }
        }
    }

