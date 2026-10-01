public class ejem2 {
   public ejem2() {
   }

   public void suma() {
      byte var1 = 7;
      byte var2 = 3;
      int var3 = var1 + var2;
      System.out.println("el valor de la suma es: " + var3);
   }

   private void mensaje() {
      System.out.println("bienvenido a estructura de datos");
   }

   public static void main(String var0) {
      ejem2 var1 = new ejem2();
      var1.suma();
      var1.mensaje();
   }
}
