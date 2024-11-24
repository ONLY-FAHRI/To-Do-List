public class AplicationToDoList {

    public static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static String[] dataMain = new String[10];

    public static void main(String[] args) {
        viewToDoList();
    }



    /**
     * menampilkan to do list
     */

    public static void showDoList() {
        System.out.println("To Do List");
        for (int i = 0; i < dataMain.length; i++) {
            String data = dataMain[i];
            int no = i+1 ;

            if (data!=null) {
                System.out.println(no + ". " + data);
            };
        }
    }

    public  static void printDoList() {
        dataMain [0] = "Belajar Java Nih Ges" ;
        dataMain [1] = "Programmer Jangan Lupa Mandi" ;
        showDoList();
    }


    /**
     *
     * menambah to do list
     */

    public  static  void addToDoList(String addData){
        // melihat apakah model penuh ?
        boolean isFull = true;
        for (int i = 0; i < dataMain.length; i++) {
            if (dataMain[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh buat data array menjadi 2 kali lipat
        if (isFull) {
            var temp = dataMain ;
            dataMain = new String[dataMain.length *2 ];

            for (int i = 0; i < dataMain.length; i++) {
                dataMain[i] = temp[i];
            }
        }


        // tambahkan ke posisi ke array nilainya null
        for (int i = 0; i < dataMain.length; i++) {
            if (dataMain[i]==null) {
                dataMain[i] = addData;
                break;
            }
        }
    }

    public static void testAddToDoList(){
        System.out.print("Add To Do List : ");
        addToDoList(sc.nextLine());

    }


    /**
     * menghapus to do list
     */

    public static boolean removeDoList(Integer number){

        if ((number -1) >= dataMain.length) {
            return false;
        }else if (dataMain[number -1] == null) {
            return false;
        }else {
            for (int i = (number - 1);i <dataMain.length;i++){
                if (i == dataMain.length -1) {
                    dataMain[i] = null;
                } else {
                    dataMain[i] = dataMain[i+1];
                }
            }
            return true;
        }

    }

    public  static void testRemoveFromDoList(){
        addToDoList("uhuy");
        addToDoList("uyas");
        addToDoList("nigger");

        var result = removeDoList(20);
        System.out.println(result);

        result = removeDoList(4);
        System.out.println(result);

        result = removeDoList(2);
        System.out.println(result);

        showDoList();

    }

    public  static String input (String info){
        System.out.print(info+" : ");
        String data = sc.nextLine();
        return data;

    }

    public  static void testInput(){
        String name = input("Nama");
        System.out.println("Hi "+name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * menampilkan view menambahkan to do list
     */

    public static void viewToDoList (){
    while (true){
        showDoList();
        System.out.println("MENU : ");
        System.out.println("1. Add List");
        System.out.println("2. Remove List");
        System.out.println("X. Back");

        var input = input("Chose");

        if (input.equals("1")){
            testAddToDoList();
        }else if (input.equals("2")){
            viewRemoveToDoList();
        }else if (input.equals("X")){
            break;
        }else {
            System.out.println("Invalid Choice");
        }
    }

    }


    public static void testViewShowToDoList(){

        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        viewToDoList();
    }


    /**
     * menampilkan dengan cara mencambah
     */
    public static void viewAddToDoList(){
        System.out.println("Added To Do List");

        var todo = input("Todo (x jika batal)");


        if (todo.equals("X")){
            //batal
        }else {
            addToDoList(todo);
        }

    }

    public static void testViewAddToDoList(){

        addToDoList("Satu");
        addToDoList("Dua");

        viewAddToDoList();
        showDoList();
    }

    /**
     * menampilkan view menghapus to do list
     */

    public static void viewRemoveToDoList (){
        showDoList();
        System.out.printf("Removed To Do List");

        var number = input("Removed Number (Select X To Cancel)");

        if (number.equals("X")){
            //batal
        }else {
            boolean succes = removeDoList(Integer.parseInt(number));
            if (!succes) {
                System.out.println("Error Deleting From To Do List "+number);
            }
        }

    }


    public  static void  testViewRemoveToDoList(){

        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        showDoList();
        viewRemoveToDoList();

        showDoList();
    }
}
